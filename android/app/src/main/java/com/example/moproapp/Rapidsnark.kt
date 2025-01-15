package com.example.moproapp

import java.nio.charset.StandardCharsets


const val DEFAULT_PROOF_BUFFER_SIZE = 1024
const val DEFAULT_ERROR_BUFFER_SIZE = 256

// Prover status codes
private const val PROVER_OK = 0x0
private const val PROVER_ERROR = 0x1
private const val PROVER_ERROR_SHORT_BUFFER = 0x2
private const val PROVER_INVALID_WITNESS_LENGTH = 0x3

// Verifier status codes
private const val VERIFIER_VALID_PROOF = 0x0
private const val VERIFIER_INVALID_PROOF = 0x1
private const val VERIFIER_ERROR = 0x2


private val rapidsnarkJNI = RapidsnarkJniBridge()


/**
 * [groth16Prove] is a JNI bridge to the C library rapidsnark.
 * It takes a PATH to zkey and witness as byte array and returns a proof and public signals as byte arrays.
 * This function is used to generate groth16 proofs.
 * @param zkeyPath - path to zkey file
 * @param witness - witness file as byte array
 * @param proofBufferSize - size of the proof buffer, in most case default value should be ok ()
 * @param publicBufferSize - size of the public buffer, can be calculated with `calculate_public_buffer_size`
 * @param errorBufferSize - 256 should be enough
 * @return [ProveResponse] with proof and public signals
 * @throws [RapidsnarkProverError] or [RapidsnarkUnknownStatusError]
 */
@Throws(RapidsnarkProverError::class)
fun groth16Prove(
    zkeyPath: String,
    witness: ByteArray,
    proofBufferSize: Int = DEFAULT_PROOF_BUFFER_SIZE,
    publicBufferSize: Int? = null,
    errorBufferSize: Int = DEFAULT_ERROR_BUFFER_SIZE
): ProveResponse {
    val publicBufferSizeNonNull =
        publicBufferSize ?: groth16PublicBufferSize(zkeyPath, errorBufferSize)

    // Create buffers to get results
    val proofBuffer = ByteArray(proofBufferSize)
    val publicBuffer = ByteArray(publicBufferSizeNonNull)
    val errorBuffer = ByteArray(errorBufferSize)

    val statusCode = rapidsnarkJNI.groth16ProveWithZKeyFilePath(
        zkeyPath,
        witness, witness.size.toLong(),
        proofBuffer, longArrayOf(proofBufferSize.toLong()),
        publicBuffer, longArrayOf(publicBufferSizeNonNull.toLong()),
        errorBuffer, errorBufferSize.toLong()
    )

    if (statusCode == PROVER_OK) {
        // Convert byte arrays to strings
        val proof = String(proofBuffer, StandardCharsets.UTF_8).trim { it <= ' ' }
        val public = String(publicBuffer, StandardCharsets.UTF_8).trim { it <= ' ' }

        return ProveResponse(proof, public)
    }

    val error = String(errorBuffer, StandardCharsets.UTF_8).trim()
    when (statusCode) {
        PROVER_ERROR -> throw RapidsnarkProverError(error)
        PROVER_ERROR_SHORT_BUFFER -> throw RapidsnarkProverError.ShortBuffer(error)
        PROVER_INVALID_WITNESS_LENGTH -> throw RapidsnarkProverError.InvalidWitnessLength(error)
        else -> throw RapidsnarkUnknownStatusError(error)
    }
}

/** [groth16Verify] is a JNI bridge to the C library rapidsnark.
 * Verifies a proof and returns true or false.
 * @param proof - proof as string
 * @param inputs - public signals as string
 * @param proof - proof as string
 * @return - true if proof is valid, false otherwise
 * @throws [RapidsnarkVerifierError] if proof is invalid or error occurred
 */
@Throws(RapidsnarkVerifierError::class)
fun groth16Verify(
    proof: String,
    inputs: String,
    verificationKey: String,
    errorBufferSize: Int = DEFAULT_ERROR_BUFFER_SIZE
): Boolean {
    val errorBuffer = ByteArray(errorBufferSize)

    val result = rapidsnarkJNI.groth16Verify(
        proof,
        inputs,
        verificationKey,
        errorBuffer,
        errorBufferSize.toLong()
    )

    if (result == VERIFIER_VALID_PROOF) {
        return true
    }

    val error = String(errorBuffer, StandardCharsets.UTF_8).trim()
    when (result) {
        VERIFIER_INVALID_PROOF -> throw RapidsnarkVerifierError.InvalidProof(error)
        VERIFIER_ERROR -> throw RapidsnarkVerifierError(error)
        else -> throw RapidsnarkUnknownStatusError(error)
    }
}

/**
 * [groth16PublicBufferSize] is a JNI bridge to the C library rapidsnark.
 * Calculates the size of the public buffer for a given zkey file.
 * In production better to use hardcoded values or cashed values, because the calculation is slow.
 * @param zkeyPath - path to zkey file
 * @param errorBufferSize - 256 should be enough
 * @return - size of the public buffer
 * @throws [RapidsnarkProverError]
 */
@Throws(RapidsnarkProverError::class)
fun groth16PublicBufferSize(
    zkeyPath: String,
    errorBufferSize: Int = DEFAULT_ERROR_BUFFER_SIZE
): Int {
    val errorBuffer = ByteArray(errorBufferSize)

    val publicBufferSize = rapidsnarkJNI.groth16PublicSizeForZkeyFile(
        zkeyPath,
        errorBuffer,
        errorBufferSize.toLong(),
    ).toInt()

    val error = String(errorBuffer, StandardCharsets.UTF_8).trim()

    return publicBufferSize
//    if (error.isEmpty()) {
//        return publicBufferSize
//    } else {
//        throw RapidsnarkProverError(error)
//    }
}

abstract class RapidsnarkError(
    message: String? = null,
    cause: Throwable? = null,
    val code: Int,
) : Exception(message, cause)

open class RapidsnarkProverError(
    message: String? = null,
    cause: Throwable? = null,
    code: Int = PROVER_ERROR,
) : RapidsnarkError(message, cause, code) {
    class ShortBuffer(message: String) :
        RapidsnarkProverError(message, code = PROVER_ERROR_SHORT_BUFFER)

    class InvalidWitnessLength(message: String) : RapidsnarkProverError(
        message, code = PROVER_INVALID_WITNESS_LENGTH
    )
}

open class RapidsnarkVerifierError(
    message: String? = null,
    cause: Throwable? = null,
    code: Int = VERIFIER_ERROR,
) :
    RapidsnarkError(message, cause, code) {
    class InvalidProof(message: String) :
        RapidsnarkVerifierError(message, code = VERIFIER_INVALID_PROOF)
}

class RapidsnarkUnknownStatusError(message: String? = null, cause: Throwable? = null) :
    RapidsnarkError(message, cause, 1)

data class ProveResponse(
    val proof: String,
    val publicSignals: String
)


private class RapidsnarkJniBridge {
    companion object {
        init {
            System.loadLibrary("rapidsnark")
        }
    }

    external fun groth16ProveWithZKeyFilePath(
        zkeyPath: String,
        wtnsBuffer: ByteArray, wtnsSize: Long,
        proofBuffer: ByteArray, proofSize: LongArray,
        publicBuffer: ByteArray, publicSize: LongArray,
        errorMsg: ByteArray, errorMsgMaxSize: Long
    ): Int

    external fun groth16Verify(
        proof: String,
        inputs: String,
        verificationKey: String,
        errorMsg: ByteArray,
        errorMsgMaxSize: Long
    ): Int

    external fun groth16PublicSizeForZkeyFile(
        zkeyPath: String,
        errorMsg: ByteArray,
        errorMsgMaxSize: Long
    ): Long
}
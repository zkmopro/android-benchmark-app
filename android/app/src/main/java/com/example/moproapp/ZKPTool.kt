package com.example.moproapp

import android.content.Context
import java.io.ByteArrayOutputStream


class ZKPTools(val context: Context) {

   
    external fun witnesscalcKeccak256_256_test(circuitBuffer: ByteArray,
                               circuitSize: Long,
                               jsonBuffer: ByteArray,
                               jsonSize: Long,
                               wtnsBuffer: ByteArray,
                               wtnsSize: LongArray,
                               errorMsg: ByteArray,
                               errorMsgMaxSize: Long): Int
    
    // external fun CalcPublicBufferSize(zkeyBuffer: ByteArray, zkeySize: Long): Long
    external fun groth16_prover(
        zkeyBuffer: ByteArray, zkeySize: Long,
        wtnsBuffer: ByteArray, wtnsSize: Long,
        proofBuffer: ByteArray, proofSize: LongArray,
        publicBuffer: ByteArray, publicSize: LongArray,
        errorMsg: ByteArray, errorMsgMaxSize: Long
    ): Int

    init {
        System.loadLibrary("rapidsnark");
        System.loadLibrary("moproapp")
    }

    fun openRawResourceAsByteArray(resourceName: Int): ByteArray {
        val inputStream = context.resources.openRawResource(resourceName)
        val byteArrayOutputStream = ByteArrayOutputStream()

        try {
            val buffer = ByteArray(1024)
            var length: Int

            while (inputStream.read(buffer).also { length = it } != -1) {
                byteArrayOutputStream.write(buffer, 0, length)
            }

            // Process the content as needed

            return byteArrayOutputStream.toByteArray()
        } finally {
            // Close the streams in a finally block to ensure they are closed even if an exception occurs
            byteArrayOutputStream.close()
            inputStream.close()
        }
    }

    
}
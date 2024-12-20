import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream

public fun getKeccak256Inputs(): MutableMap<String, List<String>> {
    var input = mutableMapOf<String, List<String>>()
    input["in"] = listOf(
        "0",
        "0",
        "1",
        "0",
        "1",
        "1",
        "1",
        "0",
        "1",
        "0",
        "1",
        "0",
        "0",
        "1",
        "1",
        "0",
        "1",
        "1",
        "0",
        "0",
        "1",
        "1",
        "1",
        "0",
        "0",
        "0",
        "1",
        "0",
        "1",
        "1",
        "1",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
    )
    return input
}

public fun getSha256Inputs(): MutableMap<String, List<String>> {
    var input = mutableMapOf<String, List<String>>()
    input["in"] = listOf(
        "0",
        "0",
        "1",
        "0",
        "1",
        "1",
        "1",
        "0",
        "1",
        "0",
        "1",
        "0",
        "0",
        "1",
        "1",
        "0",
        "1",
        "1",
        "0",
        "0",
        "1",
        "1",
        "1",
        "0",
        "0",
        "0",
        "1",
        "0",
        "1",
        "1",
        "1",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "1",
        "0",
        "1",
        "1",
        "1",
        "0",
        "1",
        "0",
        "1",
        "0",
        "0",
        "1",
        "1",
        "0",
        "1",
        "1",
        "0",
        "0",
        "1",
        "1",
        "1",
        "0",
        "0",
        "0",
        "1",
        "0",
        "1",
        "1",
        "1",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
    )
    return input
}

public fun getRSAInputs(): MutableMap<String, List<String>> {
    var input = mutableMapOf<String, List<String>>()
    input["signature"] = listOf(
        "3582320600048169363",
    "7163546589759624213",
    "18262551396327275695",
    "4479772254206047016",
    "1970274621151677644",
    "6547632513799968987",
    "921117808165172908",
    "7155116889028933260",
    "16769940396381196125",
    "17141182191056257954",
    "4376997046052607007",
    "17471823348423771450",
    "16282311012391954891",
    "70286524413490741",
    "1588836847166444745",
    "15693430141227594668",
    "13832254169115286697",
    "15936550641925323613",
    "323842208142565220",
    "6558662646882345749",
    "15268061661646212265",
    "14962976685717212593",
    "15773505053543368901",
    "9586594741348111792",
    "1455720481014374292",
    "13945813312010515080",
    "6352059456732816887",
    "17556873002865047035",
    "2412591065060484384",
    "11512123092407778330",
    "8499281165724578877",
    "12768005853882726493"
    )
    input["modulus"] = listOf(
        "13792647154200341559",
        "12773492180790982043",
        "13046321649363433702",
        "10174370803876824128",
        "7282572246071034406",
        "1524365412687682781",
        "4900829043004737418",
        "6195884386932410966",
        "13554217876979843574",
        "17902692039595931737",
        "12433028734895890975",
        "15971442058448435996",
        "4591894758077129763",
        "11258250015882429548",
        "16399550288873254981",
        "8246389845141771315",
        "14040203746442788850",
        "7283856864330834987",
        "12297563098718697441",
        "13560928146585163504",
        "7380926829734048483",
        "14591299561622291080",
        "8439722381984777599",
        "17375431987296514829",
        "16727607878674407272",
        "3233954801381564296",
        "17255435698225160983",
        "15093748890170255670",
        "15810389980847260072",
        "11120056430439037392",
        "5866130971823719482",
        "13327552690270163501"
    )
    input["base_message"] = listOf(
        "18114495772705111902",
        "2254271930739856077",
        "2068851770",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0")
    return input
}

public fun getSemaphoreInputs(): MutableMap<String, List<String>> {
    var inputs = mutableMapOf<String, List<String>>()
    inputs["secret"] = listOf("2736030358979909402780800718157159386076813972158567259200215660948447373040")
    inputs["merkleProofLength"] = listOf("2")
    inputs["merkleProofIndices"]= listOf("0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0", "0", "0", "0", "0",
    "0", "0")
    inputs["merkleProofSiblings"]=listOf("2","3","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0")
    inputs["scope"] = listOf("32")
    inputs["message"] = listOf("43")
    return inputs
}

data class CircuitInputs(
    val circuitBuffer: ByteArray,
    val circuitSize: Long,
    val jsonBuffer: ByteArray,
    val jsonSize: Long,
    val wtnsBuffer: ByteArray,
    val wtnsSize: LongArray,
    val errorMsg: ByteArray,
    val errorMsgMaxSize: Long,
    val pubData: ByteArray,
    val pubLen: LongArray,
    val proofData: ByteArray,
    val proofLen: LongArray
)

fun readFileInChunks(filePath: String, chunkSize: Int = 2048): ByteArray {
    val file = File(filePath)
    val outputStream = ByteArrayOutputStream()

    BufferedInputStream(FileInputStream(file)).use { inputStream ->
        val buffer = ByteArray(chunkSize)
        var bytesRead: Int
        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            outputStream.write(buffer, 0, bytesRead)
        }
    }

    return outputStream.toByteArray()
}

fun prepareCircuitInputs(
    circuitPath: String,
    jsonPath: String,
    zkeyPath: String
): CircuitInputs {

    // 1. Load circuit data into circuitBuffer
    val circuitBuffer: ByteArray = readFileInChunks(circuitPath)
    val circuitSize: Long = circuitBuffer.size.toLong()

    // 2. Load JSON data into jsonBuffer
    val jsonBuffer: ByteArray = readFileInChunks(jsonPath)
    val jsonSize: Long = jsonBuffer.size.toLong()

    // 3. Prepare witness buffer (initially empty)
    val wtnsBuffer: ByteArray = ByteArray(200 * 1024 * 1024) // Allocate buffer size
    val wtnsSize = LongArray(1)
    wtnsSize[0] = wtnsBuffer.size.toLong()

    // 4. Prepare error message buffer (initially empty)
    val errorMsg: ByteArray = ByteArray(256) // Set buffer size
    val errorMsgMaxSize: Long = errorMsg.size.toLong()

    // 5. Prepare public data and proof buffers
    val pubData = ByteArray(4 * 1024 * 1024)
    val pubLen = LongArray(1)
    pubLen[0] = pubData.size.toLong()

    val proofData = ByteArray(4 * 1024 * 1024)
    val proofLen = LongArray(1)
    proofLen[0] = proofData.size.toLong()

    // Return all prepared inputs
    return CircuitInputs(
        circuitBuffer,
        circuitSize,
        jsonBuffer,
        jsonSize,
        wtnsBuffer,
        wtnsSize,
        errorMsg,
        errorMsgMaxSize,
        pubData,
        pubLen,
        proofData,
        proofLen
    )
}

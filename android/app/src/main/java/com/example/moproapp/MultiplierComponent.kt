import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.moproapp.ZKPTools
import com.example.moproapp.getFilePathFromAssets
import uniffi.mopro.GenerateProofResult
import uniffi.mopro.generateCircomProof
import uniffi.mopro.verifyCircomProof
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Paths

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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MultiplierComponent() {
    var initTime by remember { mutableStateOf("init time:") }
    var provingTime by remember { mutableStateOf("proving time:") }
    var verifyingTime by remember { mutableStateOf("verifying time: ") }
    var valid by remember { mutableStateOf("valid:") }
    var output by remember { mutableStateOf("output:") }
    var res by remember {
        mutableStateOf<GenerateProofResult>(
            GenerateProofResult(proof = ByteArray(size = 0), inputs = ByteArray(size = 0))
        )
    }

    val inputs = mutableMapOf<String, List<String>>()
    inputs["a"] = listOf("3")
    inputs["b"] = listOf("5")

    var keccak256Inputs = getKeccak256Inputs()
    var sha256Inputs = getSha256Inputs()
    var rsaInputs = getRSAInputs()
    var semaphoreInputs = getSemaphoreInputs()

    val context = LocalContext.current
    val zkpTools = ZKPTools(context)

    val keccak256ZkeyPath = getFilePathFromAssets("keccak256_256_test_final.zkey")
    //val sha256ZkeyPath = getFilePathFromAssets("sha256_512_final.zkey")
    //val rsaZkeyPath = getFilePathFromAssets("rsa_main_final.zkey")
    //val semaphoreZkeyPath = getFilePathFromAssets("semaphore-32.zkey")

    var keccak256CircuitPath = getFilePathFromAssets(name = "keccak256_256_test.dat")
    var keccak256JsonPath = getFilePathFromAssets(name = "keccak256.json")



    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                Thread(
                    Runnable {
                        // 1. Load circuit data into circuitBuffer
                        val keccak256CircuitBuffer: ByteArray = readFileInChunks(keccak256CircuitPath)
                        val keccak256CircuitSize: Long = keccak256CircuitBuffer.size.toLong()

                        // 2. Load JSON data into jsonBuffer
                        val keccak256JsonBuffer: ByteArray = readFileInChunks(keccak256JsonPath)
                        val keccak256JsonSize: Long = keccak256JsonBuffer.size.toLong()

                        // 3. Prepare witness buffer (initially empty)
                        val keccak256WtnsBuffer: ByteArray = ByteArray(100 * 1024 * 1024)  // Allocate buffer size based on expected data
                        val keccak256WtnsSize = LongArray(1)
                        keccak256WtnsSize[0] = (100 * 1024 * 1024).toLong() // Set the initial size
                        // 4. Prepare error message buffer (initially empty)
                        val keccak256ErrorMsg: ByteArray = ByteArray(256)  // Set buffer size based on expected error message length
                        val keccak256ErrorMsgMaxSize: Long = keccak256ErrorMsg.size.toLong()

                        var keccak256ZkeyBuffer: ByteArray = readFileInChunks(keccak256ZkeyPath)
                        val keccak256ZkeySize: Long = keccak256ZkeyBuffer.size.toLong()

                        val witnessData = keccak256WtnsBuffer.copyOfRange(0, keccak256WtnsSize[0].toInt())

                        val pubData = ByteArray(4 *1024 *1024)
                        val pubLen = LongArray(1)
                        pubLen[0] = pubData.size.toLong()

                        val proofData = ByteArray(4*1024*1024)
                        val proofLen = LongArray(1)
                        proofLen[0] = proofData.size.toLong()
                        val startTime = System.currentTimeMillis()
                        var res = zkpTools.witnesscalcKeccak256_256_test(
                            keccak256CircuitBuffer,
                            keccak256CircuitSize,
                            keccak256JsonBuffer,
                            keccak256JsonSize,
                            keccak256WtnsBuffer,
                            keccak256WtnsSize,
                            keccak256ErrorMsg,
                            keccak256ErrorMsgMaxSize
                        )
                        println(res)

                        var proofRes = zkpTools.groth16_prover(
                            keccak256ZkeyBuffer,
                            keccak256ZkeySize,
                            keccak256WtnsBuffer,
                            keccak256WtnsSize[0],
                            proofData,
                            proofLen,
                            pubData,
                            pubLen,
                            keccak256ErrorMsg,
                            keccak256ErrorMsgMaxSize
                        )

                        //res = generateCircomProof(rsaZkeyPath, rsaInputs)
                        val endTime = System.currentTimeMillis()
                        println(proofRes)
                        println(pubData.toString(Charsets.UTF_8))
                        provingTime = "proving time: " + (endTime - startTime).toString() + " ms"
                    }
                ).start()
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text(text = "generate proof") }
        Button(
            onClick = {
                val startTime = System.currentTimeMillis()
                //valid = "valid: " + verifyCircomProof(rsaZkeyPath, res.proof, res.inputs).toString()
                val endTime = System.currentTimeMillis()
                verifyingTime = "verifying time: " + (endTime - startTime).toString() + " ms"
                //output = "output: " + uniffi.mopro.toEthereumInputs(res.inputs)
            },
            modifier = Modifier.padding(top = 120.dp)
        ) { Text(text = "verify proof") }
        Text(
            text = "Multiplier proof",
            modifier = Modifier.padding(bottom = 180.dp),
            fontWeight = FontWeight.Bold
        )

        Text(text = provingTime, modifier = Modifier
            .padding(top = 250.dp)
            .width(200.dp))
        Text(text = valid, modifier = Modifier
            .padding(top = 300.dp)
            .width(200.dp))
        Text(text = verifyingTime, modifier = Modifier
            .padding(top = 350.dp)
            .width(200.dp))
        Text(text = output, modifier = Modifier
            .padding(top = 400.dp)
            .width(200.dp))
    }
}
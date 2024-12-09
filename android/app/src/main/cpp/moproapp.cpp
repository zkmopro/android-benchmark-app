#include <jni.h>
#include "include/prover.h"
#include "include/witnesscalc_keccak256_256_test.h"
#include "include/witnesscalc_rsa_main.h"
#include "include/witnesscalc_semaphore.h"
#include "include/witnesscalc_sha256_512.h"

// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("moproapp");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("moproapp")
//      }
//    }
int witnesscalc_keccak256_256_test(const char *buffer, unsigned long i, const char *buffer1,
                                   unsigned long i1, char *buffer2, unsigned long *pInt, char *msg,
                                   unsigned long i2);

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_moproapp_ZKPTools_witnesscalcKeccak256_1256_1test(JNIEnv *env, jobject thiz,
                                                                   jbyteArray circuit_buffer,
                                                                   jlong circuit_size,
                                                                   jbyteArray json_buffer,
                                                                   jlong json_size,
                                                                   jbyteArray wtns_buffer,
                                                                   jlongArray wtns_size,
                                                                   jbyteArray error_msg,
                                                                   jlong error_msg_max_size) {
    const char *circuitBuffer = reinterpret_cast<const char *>(env->GetByteArrayElements(
            circuit_buffer, nullptr));
    const char *jsonBuffer = reinterpret_cast<const char *>(env->GetByteArrayElements(json_buffer,
                                                                                      nullptr));
    char *wtnsBuffer = reinterpret_cast<char *>(env->GetByteArrayElements(wtns_buffer, nullptr));
    char *errorMsg = reinterpret_cast<char *>(env->GetByteArrayElements(error_msg, nullptr));

    unsigned long wtnsSize = env->GetLongArrayElements(wtns_size, nullptr)[0];


    int result = witnesscalc_keccak256_256_test(
            circuitBuffer, static_cast<unsigned long>(circuit_size),
            jsonBuffer, static_cast<unsigned long>(json_size),
            wtnsBuffer, &wtnsSize,
            errorMsg, static_cast<unsigned long>(error_msg_max_size));

    // Set the result and release the resources
    env->SetLongArrayRegion(wtns_size, 0, 1, reinterpret_cast<jlong *>(&wtnsSize));

    env->ReleaseByteArrayElements(circuit_buffer,
                                  reinterpret_cast<jbyte *>(const_cast<char *>(circuitBuffer)), 0);
    env->ReleaseByteArrayElements(json_buffer,
                                  reinterpret_cast<jbyte *>(const_cast<char *>(jsonBuffer)), 0);
    env->ReleaseByteArrayElements(wtns_buffer, reinterpret_cast<jbyte *>(wtnsBuffer), 0);
    env->ReleaseByteArrayElements(error_msg, reinterpret_cast<jbyte *>(errorMsg), 0);

    return result;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_moproapp_ZKPTools_groth16_1prover(JNIEnv *env, jobject thiz,
                                                   jbyteArray zkey_buffer, jlong zkey_size,
                                                   jbyteArray wtns_buffer, jlong wtns_size,
                                                   jbyteArray proof_buffer, jlongArray proof_size,
                                                   jbyteArray public_buffer, jlongArray public_size,
                                                   jbyteArray error_msg, jlong error_msg_max_size) {
    const void *zkeyBuffer = env->GetByteArrayElements(zkey_buffer, nullptr);
    const void *wtnsBuffer = env->GetByteArrayElements(wtns_buffer, nullptr);
    char *proofBuffer = reinterpret_cast<char *>(env->GetByteArrayElements(proof_buffer,
                                                                           nullptr));
    char *publicBuffer = reinterpret_cast<char *>(env->GetByteArrayElements(public_buffer,
                                                                            nullptr));
    char *errorMsg = reinterpret_cast<char *>(env->GetByteArrayElements(error_msg, nullptr));

    unsigned long proofSize = env->GetLongArrayElements(proof_size, nullptr)[0];
    unsigned long publicSize = env->GetLongArrayElements(public_size, nullptr)[0];

    int result = groth16_prover(zkeyBuffer, static_cast<unsigned long>(zkey_size),
                                wtnsBuffer, static_cast<unsigned long>(wtns_size),
                                proofBuffer, &proofSize,
                                publicBuffer, &publicSize,
                                errorMsg, static_cast<unsigned long>(error_msg_max_size));

    env->SetLongArrayRegion(proof_size, 0, 1, reinterpret_cast<const jlong *>(&proofSize));
    env->SetLongArrayRegion(public_size, 0, 1, reinterpret_cast<const jlong *>(&publicSize));

    env->ReleaseByteArrayElements(zkey_buffer,
                                  reinterpret_cast<jbyte *>(const_cast<void *>(zkeyBuffer)), 0);
    env->ReleaseByteArrayElements(wtns_buffer,
                                  reinterpret_cast<jbyte *>(const_cast<void *>(wtnsBuffer)), 0);
    env->ReleaseByteArrayElements(proof_buffer, reinterpret_cast<jbyte *>(proofBuffer), 0);
    env->ReleaseByteArrayElements(public_buffer, reinterpret_cast<jbyte *>(publicBuffer), 0);
    env->ReleaseByteArrayElements(error_msg, reinterpret_cast<jbyte *>(errorMsg), 0);

    return result;
}
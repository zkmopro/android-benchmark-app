#include <jni.h>
#include "include/prover.h"
#include "include/witnesscalc_keccak256_256_test.h"
#include "include/witnesscalc_rsa_main.h"
#include "include/witnesscalc_semaphore.h"
#include "include/witnesscalc_sha256_512.h"
#include "include/witnesscalc_aadhaar_verifier.h"

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
Java_com_example_moproapp_ZKPTools_witnesscalcSemaphore32(JNIEnv *env, jobject thiz,
                                                          jbyteArray circuit_buffer,
                                                          jlong circuit_size,
                                                          jbyteArray json_buffer, jlong json_size,
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


    int result = witnesscalc_semaphore(
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
Java_com_example_moproapp_ZKPTools_witnesscalcSHA256(JNIEnv *env, jobject thiz,
                                                     jbyteArray circuit_buffer, jlong circuit_size,
                                                     jbyteArray json_buffer, jlong json_size,
                                                     jbyteArray wtns_buffer, jlongArray wtns_size,
                                                     jbyteArray error_msg,
                                                     jlong error_msg_max_size) {
    const char *circuitBuffer = reinterpret_cast<const char *>(env->GetByteArrayElements(
            circuit_buffer, nullptr));
    const char *jsonBuffer = reinterpret_cast<const char *>(env->GetByteArrayElements(json_buffer,
                                                                                      nullptr));
    char *wtnsBuffer = reinterpret_cast<char *>(env->GetByteArrayElements(wtns_buffer, nullptr));
    char *errorMsg = reinterpret_cast<char *>(env->GetByteArrayElements(error_msg, nullptr));

    unsigned long wtnsSize = env->GetLongArrayElements(wtns_size, nullptr)[0];


    int result = witnesscalc_sha256_512(
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
Java_com_example_moproapp_ZKPTools_witnesscalcRSA(JNIEnv *env, jobject thiz,
                                                  jbyteArray circuit_buffer, jlong circuit_size,
                                                  jbyteArray json_buffer, jlong json_size,
                                                  jbyteArray wtns_buffer, jlongArray wtns_size,
                                                  jbyteArray error_msg, jlong error_msg_max_size) {
    const char *circuitBuffer = reinterpret_cast<const char *>(env->GetByteArrayElements(
            circuit_buffer, nullptr));
    const char *jsonBuffer = reinterpret_cast<const char *>(env->GetByteArrayElements(json_buffer,
                                                                                      nullptr));
    char *wtnsBuffer = reinterpret_cast<char *>(env->GetByteArrayElements(wtns_buffer, nullptr));
    char *errorMsg = reinterpret_cast<char *>(env->GetByteArrayElements(error_msg, nullptr));

    unsigned long wtnsSize = env->GetLongArrayElements(wtns_size, nullptr)[0];


    int result = witnesscalc_rsa_main(
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
Java_com_example_moproapp_ZKPTools_groth16ProveWithZKeyFilePath(JNIEnv *env, jobject obj,
                                                                jstring zkeyPath,
                                                                jbyteArray wtnsBuffer, jlong wtnsSize,
                                                                jbyteArray proofBuffer, jlongArray proofSize,
                                                                jbyteArray publicBuffer, jlongArray publicSize,
                                                                jbyteArray errorMsg, jlong errorMsgMaxSize) {

    // Convert jbyteArray to native types
    const char *nativeZkeyPath = env->GetStringUTFChars(zkeyPath, nullptr);

    void *nativeWtnsBuffer = env->GetByteArrayElements(wtnsBuffer, nullptr);

    char *nativeProofBuffer = (char *) env->GetByteArrayElements(proofBuffer, nullptr);
    char *nativePublicBuffer = (char *) env->GetByteArrayElements(publicBuffer, nullptr);
    char *nativeErrorMsg = (char *) env->GetByteArrayElements(errorMsg, nullptr);

    jlong *nativeProofSizeArr = env->GetLongArrayElements(proofSize, 0);
    jlong *nativePublicSizeArr = env->GetLongArrayElements(publicSize, 0);

    unsigned long nativeProofSize = nativeProofSizeArr[0];
    unsigned long nativePublicSize = nativePublicSizeArr[0];

    // Call the groth16_prover function`
    int status_code = groth16_prover_zkey_file(
            nativeZkeyPath,
            nativeWtnsBuffer, wtnsSize,
            nativeProofBuffer, &nativeProofSize,
            nativePublicBuffer, &nativePublicSize,
            nativeErrorMsg, errorMsgMaxSize
    );

    // Convert the results back to JNI types
    nativeProofSizeArr[0] = nativeProofSize;
    nativePublicSizeArr[0] = nativePublicSize;

    env->SetLongArrayRegion(proofSize, 0, 1, (jlong *) nativeProofSizeArr);
    env->SetLongArrayRegion(publicSize, 0, 1, (jlong *) nativePublicSizeArr);

    // Release the native buffers
    env->ReleaseByteArrayElements(wtnsBuffer, (jbyte *) nativeWtnsBuffer, 0);
    env->ReleaseByteArrayElements(proofBuffer, (jbyte *) nativeProofBuffer, 0);
    env->ReleaseByteArrayElements(publicBuffer, (jbyte *) nativePublicBuffer, 0);
    env->ReleaseByteArrayElements(errorMsg, (jbyte *) nativeErrorMsg, 0);

    env->ReleaseLongArrayElements(proofSize, (jlong *) nativeProofSizeArr, 0);
    env->ReleaseLongArrayElements(publicSize, (jlong *) nativePublicSizeArr, 0);

    return status_code;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_moproapp_ZKPTools_witnesscalcAadhaarVerifier(JNIEnv *env, jobject thiz,
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


    int result = witnesscalc_aadhaar_verifier(
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
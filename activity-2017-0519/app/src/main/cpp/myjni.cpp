#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_u_can_i_up_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++!!!12";
    return env->NewStringUTF(hello.c_str());
}

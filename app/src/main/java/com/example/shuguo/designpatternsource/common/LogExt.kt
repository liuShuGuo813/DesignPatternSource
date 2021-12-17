import android.os.Build
import android.util.Log
import com.example.shuguo.designpatternsource.BuildConfig

/**
 * @Time : 2021-02-25
 * @Author : lsg
 * @Description : Log工具类，打印具体代码行数
 **/
const val NONE = 6
const val ERROR = 5
const val WARN = 4
const val INFO = 3
const val DEBUG = 2
const val VERBOSE = 1

var printLevel = VERBOSE

fun Any?.logV() {
    if (printLevel <= VERBOSE) {
        Log.v(logTag, toString())
    }
}

fun Any?.logD() {
    if (printLevel <= DEBUG) {
        Log.d(logTag, toString())
    }
}

fun Any?.logI() {
    if (printLevel <= INFO) {
        Log.i(logTag, toString())
    }
}

fun Any?.logW() {
    if (printLevel <= WARN) {
        Log.w(logTag, toString())
    }
}

fun Any?.logW(t: Throwable) {
    if (printLevel <= WARN) {
        Log.w(logTag, toString(), t)
    }
}

fun Any?.logWRuntimeException(msg: Any = "") {
    if (printLevel <= WARN) {
        Log.w(logTag, msg.toString(), RuntimeException(msg.toString()))
    }
}

fun Any?.logE() {
    if (printLevel <= ERROR) {
        if(BuildConfig.DEBUG){
            Log.e(logTag, toString())
        }
    }
}

fun Any?.logE(t: Throwable) {
    if (printLevel <= ERROR) {
        Log.e(logTag, toString(), t)
    }
}

fun Any?.logERuntimeException(msg: Any = "") {
    if (printLevel <= ERROR) {
        Log.e(logTag, msg.toString(), RuntimeException(msg.toString()))
    }
}

private val logTag: String
    get() {
        val element = Thread.currentThread().stackTrace[4]
        return "(${element.fileName}:${element.lineNumber}) ${element.methodName}"
    }

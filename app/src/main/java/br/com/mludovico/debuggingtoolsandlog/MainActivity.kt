package br.com.mludovico.debuggingtoolsandlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

const val TAG = "Debug Project"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val debugButton = debug
        val errorButton = error
        val infoButton = info
        val warningButton = warning
        val verboseButton = verbose

        debugButton.setOnClickListener {
            logInfo(LogType.DEBUG, message.text.toString())
        }
        errorButton.setOnClickListener {
            logInfo(LogType.ERROR, message.text.toString())
        }
        infoButton.setOnClickListener {
            logInfo(LogType.INFO, message.text.toString())
        }
        warningButton.setOnClickListener {
            logInfo(LogType.WARNING, message.text.toString())
        }
        verboseButton.setOnClickListener {
            logInfo(LogType.VERBOSE, message.text.toString())
        }
    }

    private fun logInfo(type: LogType, message: String) {
        when(type){
            LogType.DEBUG -> Log.d(TAG, message)
            LogType.ERROR -> Log.e(TAG, message)
            LogType.INFO -> Log.i(TAG, message)
            LogType.WARNING -> Log.w(TAG, message)
            LogType.VERBOSE -> Log.v(TAG, message)
        }
    }
}

enum class LogType{
    DEBUG,
    ERROR,
    INFO,
    WARNING,
    VERBOSE
}
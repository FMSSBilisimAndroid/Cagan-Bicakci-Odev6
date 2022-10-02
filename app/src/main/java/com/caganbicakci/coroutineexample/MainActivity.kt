package com.caganbicakci.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.caganbicakci.coroutineexample.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        while(true){

            count++
            Log.i("COUNT", count.toString())

            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA", answer)
                }
            }
        }
    }

    private suspend fun doNetworkCall(): String {
        delay(2000L)
        return "Network Answer Called"
    }
}


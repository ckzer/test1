package com.example.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){

    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.txtSecond.text=intent.getStringExtra("data")
    }
}
package com.example.umc_week4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var memo: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        binding.btnMain.setOnClickListener {
            var intent=Intent(this, SecondActivity::class.java)
            intent.putExtra("data", binding.edtMain.text.toString())
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        memo = binding.edtMain.text.toString()
        binding.edtMain.text.clear()

        val stop = Toast.makeText(this.applicationContext, "onStop", Toast.LENGTH_SHORT)
        stop.show()
    }

    override fun onStart() {
        super.onStart()
        AlertDialog.Builder(this)
            .setTitle("물어보기")
            .setMessage("이어서 작성할까요?")
            .setPositiveButton("예") {dialog, which->
                binding.edtMain.setText(memo)
            }
            .setNegativeButton("아니요") {dialog, which ->
                binding.edtMain.text.clear()
            }
            .create()
            .show()
        val restart = Toast.makeText(this.applicationContext, "onStart", Toast.LENGTH_SHORT)
        restart.show()
    }

}
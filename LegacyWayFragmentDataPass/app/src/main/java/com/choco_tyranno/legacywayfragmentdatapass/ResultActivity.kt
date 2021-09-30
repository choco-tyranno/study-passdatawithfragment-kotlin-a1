package com.choco_tyranno.legacywayfragmentdatapass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        findViewById<Button>(R.id.result_button).setOnClickListener {
            val intent = Intent()
            intent.putExtra("data","Hello")
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}
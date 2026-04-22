package com.example.studentcalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var etStudentId : EditText ;
    private lateinit var btnLogin : Button ;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        etStudentId = findViewById<EditText>(R.id.etStudentId)
        btnLogin = findViewById<Button>(R.id.btnLogin)
            btnLogin.setOnClickListener {
                val studentId = etStudentId.text.toString()
                if (studentId.isEmpty()){
                    Toast.makeText(this,"Please enter your Student ID",Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, CalculatorActivity::class.java).apply {
                        putExtra("STUDENT_ID",studentId)
                    }
                    startActivity(intent)
                    finish()

                }


            }

    }
}
package com.example.kotlinpractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Scratch : AppCompatActivity() {
    val name = ("Joselito")
    var Age = (22)
    Age = Age + 1

    print(name + Age)

    fun greetUser(name: String): String{
        return ("Welcome, " + name)
    }
}
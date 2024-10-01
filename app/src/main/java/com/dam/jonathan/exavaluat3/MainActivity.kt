package com.dam.jonathan.exavaluat3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var myTextView: TextView
    private var displayText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        myTextView = findViewById(R.id.TEXT)


    }
    fun borra(view: View) {
        displayText = ""
        myTextView.text = displayText
    }
    fun numeros(view: View) {
        Log.i("Etiqueta", view.tag.toString())
        displayText += view.tag.toString()
        myTextView.text = displayText
    }
    fun dividir( n1 : Int,n2 : Int): Int {
        if (n2 == 0) {
            return -1
        }
        return  n1/n2;
    }
    fun resultat(view: View) {
        var t = ""
        val myList = mutableListOf<String>()
        val myListV = mutableListOf<String>()
        for (i in displayText) {
            if (i !in listOf('+', '-', 'X', '/')) {
                t += i
            } else {
                myList.add(t)
                myListV.add(i.toString())
                t = ""
            }
        }

        if (t.isNotEmpty()) {
            myList.add(t)
        }

        var result = myList[0].toInt()
        var index = 1

        for (i in myListV) {
            if(result == -1) {

            }else {
                when (i) {
                    "+" -> result += myList[index].toInt()
                    "-" -> result -= myList[index].toInt()
                    "X" -> result *= myList[index].toInt()
                    "/" -> result = dividir(result, myList[index].toInt())
                }
                index++
            }
        }
        myTextView.text = result.toString()

        if (result == -1){
            myTextView.text = "No es pot dividir per zero"

        }
    }

}
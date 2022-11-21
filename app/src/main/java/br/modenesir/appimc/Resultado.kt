package br.modenesir.appimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.text.DecimalFormat

class Resultado : AppCompatActivity() {
    private var tag = "App Calcula IMC"
    private var digitos = DecimalFormat("###,##0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        Log.d(tag, "Jogando resultado do imc..")

        val extras = intent.extras
        val imc = extras!!.getDouble("chave")
        val db = extras.getBoolean("chave2")
        val nome = extras.getString("chave3")
        val myName = findViewById<TextView>(R.id.nome)
        myName.text = nome
        digitos.format(imc)
        val myTxt = findViewById<TextView>(R.id.valor2)
        myTxt.text = digitos.format(imc)
        if (db) {
            if (imc < 18.5) {
                myTxt.setTextColor(Color.parseColor("#00008B"))
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt2.text = "Você está abaixo do peso"
            } else if (imc < 24.9) {
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt.setTextColor(Color.parseColor("#105c41"))
                myTxt2.text = "Você está com um peso saudável"
            } else if (imc < 29.9) {
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt2.text = "Você está com sobrepeso"
                myTxt.setTextColor(Color.parseColor("#8B8000"))
            } else if (imc < 34.9) {
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt.setTextColor(Color.parseColor("#FFAC1C"))
                myTxt2.text = "Você se encontra em um estado de obesidade Grau 1"
            } else if (imc < 39.9) {
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt.setTextColor(Color.parseColor("#A52A2A"))
                myTxt2.text = "Você se encontra em um estado de obesidade Grau 2 "
            } else {
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt.setTextColor(Color.parseColor("#8B0000"))
                myTxt2.text = "Você se encontra em um estado de obesidade Grau 3 "
            }
        } else {
            if (imc < 23) {
                myTxt.setTextColor(Color.parseColor("#00008B"))
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt2.text = "Você está abaixo do peso"
            } else if (imc < 28) {
                myTxt.setTextColor(Color.parseColor("#105c41"))
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt2.text = "Você está com um peso saudável"
            } else if (imc < 30) {
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt2.text = "Você está com sobrepeso"
                myTxt.setTextColor(Color.parseColor("#8B8000"))
            } else {
                myTxt.setTextColor(Color.parseColor("#8B0000"))
                val myTxt2 = findViewById<TextView>(R.id.valor3)
                myTxt2.text = "Você se encontra em um estado de obesidade"
            }
        }
    }
}
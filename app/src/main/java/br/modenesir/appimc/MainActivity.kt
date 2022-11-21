package br.modenesir.appimc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tag = "App Calcula IMC"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d(tag, "onCreate: Tela Principal Carregando...")
        val calcular = findViewById<Button>(R.id.submitCalcular)
        calcular.setOnClickListener {

            Log.d(tag,"teste0")

            val alturaStr : String = findViewById<EditText>(R.id.editAltura).text?.toString() ?: "0.00"
            Log.d(tag, "teste1")
            val massaStr = findViewById<EditText>(R.id.editMassa).text?.toString()  ?: "0.00"
            if((massaStr.isEmpty() ) || (alturaStr.isEmpty())) {
                Toast.makeText(
                    this@MainActivity,
                    "Por favor, preencha a massa e a altura",
                    Toast.LENGTH_LONG
                ).show()
            } else{



            Log.d(tag, "teste2")
            val nomeStr = findViewById<EditText>(R.id.editNome).text?.toString()   ?: ""
            Log.d(tag,"teste3")


            val massa : Double = massaStr.toDouble()

            val altura: Double = alturaStr.toDouble()
            Log.d(tag,"teste double")

            if ((massa == 0.00) || (altura == 0.00)) {
                Toast.makeText(
                    this@MainActivity,
                    "Massa e altura devem ser diferentes de zero",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                val rA = findViewById<RadioButton>(R.id.Adulto)
                val rB = findViewById<RadioButton>(R.id.Idoso)
                if (rA.isChecked) {
                    val db = true
                    val imc: Double = massa / (altura * altura)
                    val intent = Intent(this@MainActivity, Resultado::class.java)
                    intent.putExtra("chave", imc)
                    intent.putExtra("chave2", db)
                    intent.putExtra("chave3", nomeStr)
                    startActivity(intent)
                } else if (rB.isChecked) {
                    val db = false
                    val imc: Double = massa / (altura * altura)
                    val intent = Intent(this@MainActivity, Resultado::class.java)
                    intent.putExtra("chave", imc)
                    intent.putExtra("chave2", db)
                    intent.putExtra("chave3", nomeStr)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor, marque a faixa etária",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}}
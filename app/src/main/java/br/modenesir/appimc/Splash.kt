package br.modenesir.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log

class Splash : AppCompatActivity(){

    var tag = "App Calcula IMC"
    var tempoDeEspera = 4 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(tag, "onCreate: Carregada Tela Splash")
        trocarTela()
    }

    private fun trocarTela() {
        Log.d(tag, "Trocando de Tela")
        Handler(Looper.getMainLooper()).postDelayed({
            Log.d(tag, "Esperando um tempo...")
            val trocarDeTela = Intent(this@Splash, MainActivity::class.java)
            startActivity(trocarDeTela)
            finish()
        }, tempoDeEspera.toLong())
    }
}
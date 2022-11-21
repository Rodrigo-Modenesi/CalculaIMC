package br.modenesir.primeirocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class TelaSplashActivity extends AppCompatActivity {

    String Tag = "App Primeiro Cliente";
    int tempoDeEspera = 5 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        Log.d(Tag, "onCreate: Carregada Tela Splash");

        trocarTela();

    }

    private void trocarTela() {
        Log.d(Tag, "Trocando de Tela");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(Tag, "Esperando um Tempo...");

                Intent trocarDeTela = new Intent(TelaSplashActivity.this, MainActivity2.class);
                startActivity(trocarDeTela);
                finish();
            }

        }, tempoDeEspera);
    }

}




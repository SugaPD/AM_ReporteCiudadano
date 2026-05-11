package com.example.reporteciudadano;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnReporte, btnContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReporte = findViewById(R.id.btnReporte);
        btnContacto = findViewById(R.id.btnContacto);

        btnReporte.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, ReporteActivity.class);
            startActivity(intent);

        });

        btnContacto.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
            startActivity(intent);

        });
    }
}
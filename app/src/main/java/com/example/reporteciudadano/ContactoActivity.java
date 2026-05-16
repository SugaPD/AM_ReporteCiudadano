package com.example.reporteciudadano;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;

public class ContactoActivity extends AppCompatActivity {
    Button btnMapa, btnCorreo, btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacto);
        btnMapa = findViewById(R.id.btnMapa);
        btnCorreo = findViewById(R.id.btnCorreo);
        btnLlamar = findViewById(R.id.btnLlamar);

        btnMapa.setOnClickListener(v -> {

            Uri uri = Uri.parse(
                    "geo:0,0?q=Ayuntamiento+Guaymas"
            );

            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    uri
            );

            startActivity(intent);

        });

        btnCorreo.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SENDTO);

            intent.setData(Uri.parse(
                    "mailto:contacto@guaymas.gob.mx"
            ));

            intent.putExtra(
                    Intent.EXTRA_SUBJECT,
                    "Reporte Ciudadano"
            );

            startActivity(intent);

        });

        btnLlamar.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Intent.ACTION_DIAL
            );

            intent.setData(
                    Uri.parse("tel:6221234567")
            );

            startActivity(intent);

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
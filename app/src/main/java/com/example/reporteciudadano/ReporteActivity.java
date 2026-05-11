package com.example.reporteciudadano;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReporteActivity extends AppCompatActivity {

    Spinner spColonias, spTipoReporte;

    EditText etNombre, etDireccion, etCelular, etCorreo, etDescripcion;
    Button btnEnviar;

    Button btnImagen;
    ImageView imgReporte;

    private static final int PICK_IMAGE = 1;

    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        spColonias = findViewById(R.id.spColonias);
        spTipoReporte = findViewById(R.id.spTipoReporte);

        btnImagen = findViewById(R.id.btnImagen);
        imgReporte = findViewById(R.id.imgReporte);

        etNombre = findViewById(R.id.etNombre);
        etDireccion = findViewById(R.id.etDireccion);
        etCelular = findViewById(R.id.etCelular);
        etCorreo = findViewById(R.id.etCorreo);
        etDescripcion = findViewById(R.id.etDescripcion);

        btnEnviar = findViewById(R.id.btnEnviar);

        // Spinner colonias
        ArrayAdapter<CharSequence> adapterColonias =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.colonias,
                        android.R.layout.simple_spinner_item
                );

        adapterColonias.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spColonias.setAdapter(adapterColonias);

        // Spinner tipos de reporte
        ArrayAdapter<CharSequence> adapterTipos =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.tipos_reporte,
                        android.R.layout.simple_spinner_item
                );

        adapterTipos.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spTipoReporte.setAdapter(adapterTipos);

        btnImagen.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");

            startActivityForResult(intent, PICK_IMAGE);

        });

        btnEnviar.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString().trim();
            String direccion = etDireccion.getText().toString().trim();
            String celular = etCelular.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String descripcion = etDescripcion.getText().toString().trim();

            if(nombre.isEmpty()
                    || direccion.isEmpty()
                    || celular.isEmpty()
                    || correo.isEmpty()
                    || descripcion.isEmpty()) {

                Toast.makeText(
                        this,
                        "Completa todos los campos",
                        Toast.LENGTH_SHORT
                ).show();

            }
            else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {

                Toast.makeText(
                        this,
                        "Correo inválido",
                        Toast.LENGTH_SHORT
                ).show();

            }
            else {

                Toast.makeText(
                        this,
                        "Reporte listo para enviar",
                        Toast.LENGTH_SHORT
                ).show();

            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE
                && resultCode == Activity.RESULT_OK
                && data != null
                && data.getData() != null) {

            imageUri = data.getData();

            imgReporte.setImageURI(imageUri);
        }
    }
}
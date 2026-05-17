package com.example.reporteciudadano;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ReporteActivity extends AppCompatActivity {

    Spinner spColonias, spTipoReporte;

    EditText etNombre, etDireccion,
            etCelular, etCorreo,
            etDescripcion;

    Button btnEnviar, btnImagen, btnVolver;

    ImageView imgReporte;

    String imagenBase64 = "";

    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reporte);

        spColonias = findViewById(R.id.spColonias);
        spTipoReporte = findViewById(R.id.spTipoReporte);

        etNombre = findViewById(R.id.etNombre);
        etDireccion = findViewById(R.id.etDireccion);
        etCelular = findViewById(R.id.etCelular);
        etCorreo = findViewById(R.id.etCorreo);
        etDescripcion = findViewById(R.id.etDescripcion);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnImagen = findViewById(R.id.btnImagen);
        btnVolver = findViewById(R.id.btnVolver);

        imgReporte = findViewById(R.id.imgReporte);

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

            Intent intent = new Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            );

            startActivityForResult(intent, PICK_IMAGE);

        });

        btnVolver.setOnClickListener(v -> {
            finish();
        });

        btnEnviar.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString();
            String direccion = etDireccion.getText().toString();
            String celular = etCelular.getText().toString();
            String correo = etCorreo.getText().toString();
            String descripcion = etDescripcion.getText().toString();

            if(nombre.isEmpty() ||
                    direccion.isEmpty() ||
                    celular.isEmpty() ||
                    correo.isEmpty() ||
                    descripcion.isEmpty()){

                Toast.makeText(
                        ReporteActivity.this,
                        "Complete todos los campos",
                        Toast.LENGTH_LONG
                ).show();

                return;
            }

            if(!android.util.Patterns.EMAIL_ADDRESS
                    .matcher(correo)
                    .matches()){

                Toast.makeText(
                        ReporteActivity.this,
                        "Correo inválido",
                        Toast.LENGTH_LONG
                ).show();

                return;
            }

            Toast.makeText(
                    ReporteActivity.this,
                    "Reporte enviado correctamente",
                    Toast.LENGTH_LONG
            ).show();

        });

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        if(requestCode == PICK_IMAGE &&
                resultCode == RESULT_OK &&
                data != null &&
                data.getData() != null){

            Uri imageUri = data.getData();

            imgReporte.setImageURI(imageUri);

            try {

                Bitmap bitmap =
                        MediaStore.Images.Media.getBitmap(
                                this.getContentResolver(),
                                imageUri
                        );

                ByteArrayOutputStream baos =
                        new ByteArrayOutputStream();

                bitmap.compress(
                        Bitmap.CompressFormat.JPEG,
                        100,
                        baos
                );

                byte[] imageBytes =
                        baos.toByteArray();

                imagenBase64 =
                        Base64.encodeToString(
                                imageBytes,
                                Base64.DEFAULT
                        );

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}
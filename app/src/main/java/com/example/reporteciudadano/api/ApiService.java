package com.example.reporteciudadano.api;

import com.example.reporteciudadano.models.ReporteResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({
            "Accept: application/json"
    })

    @FormUrlEncoded
    @POST("reporte.php")
    Call<ReporteResponse> enviarReporte(

            @Field("nombre") String nombre,
            @Field("colonia") String colonia,
            @Field("direccion") String direccion,
            @Field("celular") String celular,
            @Field("correo") String correo,
            @Field("tipo_reporte") String tipo,
            @Field("descripcion") String descripcion,
            @Field("imagen") String imagen

    );

}
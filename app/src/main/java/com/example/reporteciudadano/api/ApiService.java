package com.example.reporteciudadano.api;

import com.example.reporteciudadano.models.ReporteRequest;
import com.example.reporteciudadano.models.ReporteResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("reporte.php")
    Call<ReporteResponse> enviarReporte(
            @Body ReporteRequest reporteRequest
    );

}
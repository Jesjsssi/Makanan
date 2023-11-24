package com.example.makanan.INTERFACE;

import com.example.makanan.MODUL.ModulGuru;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceGuru {
    @GET("guru/")
    Call<List<ModulGuru>> tampilkanGuru();
    //@POST("guru")
}

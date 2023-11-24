package com.example.makanan.CLASS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.makanan.ADAPTOR.AdaptorGuru;
import com.example.makanan.API.KoneksiAPI;
import com.example.makanan.INTERFACE.InterfaceGuru;
import com.example.makanan.MODUL.ModulGuru;
import com.example.makanan.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPIGuru extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModulGuru> guruArrayList=new ArrayList<>();
    InterfaceGuru interfaceGuru;
    KoneksiAPI koneksiAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_apiguru);
        recyclerView=findViewById(R.id.recyclerviewGuru);
        interfaceGuru=KoneksiAPI.Koneksi().create(InterfaceGuru.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        Call<List<ModulGuru>> gurumuncul=interfaceGuru.tampilkanGuru();
        gurumuncul.enqueue(new Callback<List<ModulGuru>>() {
            @Override
            public void onResponse(Call<List<ModulGuru>> call, Response<List<ModulGuru>> response) {
                ArrayList<ModulGuru> guruArrayList= (ArrayList<ModulGuru>) response.body();
                AdaptorGuru adaptorGuru=new AdaptorGuru(guruArrayList);
                recyclerView.setAdapter(adaptorGuru);
            }

            @Override
            public void onFailure(Call<List<ModulGuru>> call, Throwable t) {
                //Toast.makeText(RestAPIGuru.this,"Guru tidak mau tampil");
            }
        });
        super.onResume();
    }
}
package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entry_data_barang extends AppCompatActivity {
    EditText kode_brg, nama_brg, st_brg, hg_brg, kota_brg;
    Button btnsave, btnview;
    databasehelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_barang);

        kode_brg=findViewById(R.id.kode);
        nama_brg=findViewById(R.id.nama);
        st_brg=findViewById(R.id.satuan);
        hg_brg=findViewById(R.id.harga);
        kota_brg=findViewById(R.id.kota);
        btnsave=findViewById(R.id.kirim);
        btnview=findViewById(R.id.batal);
        db=new databasehelper(this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xkode= kode_brg.getText().toString();
                String xnama=nama_brg.getText().toString();
                String xsatuan=st_brg.getText().toString();
                String xharga=hg_brg.getText().toString();
                String xkota=kota_brg.getText().toString();
                db.input_data(xkode, xnama, xsatuan, xharga, xkota);
                boolean hasil= db.input_data(xkode, xnama, xsatuan, xharga, xkota);
                if(hasil)
                {
                    Toast.makeText(Entry_data_barang.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
package com.example.makanan.MODUL;

public class ModulGuru {
    String nip, nama,status;

    public ModulGuru(String nip, String nama, String status) {
        this.nip = nip;
        this.nama = nama;
        this.status = status;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Pasien {
    
    private int id_pasien;
    private String nama;
    private String jenis_kelamin;
    private int usia;
    private String no_telepon;

    public Pasien(int id_pasien, String nama, String jenis_kelamin, int usia, String no_telepon) {
        this.id_pasien = id_pasien;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.usia = usia;
        this.no_telepon = no_telepon;
    }
    
     public Pasien(String nama, String jenis_kelamin, int usia, String no_telepon) {
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.usia = usia;
        this.no_telepon = no_telepon;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
     
    @Override
    public String toString(){
        return this.nama;
    }
}

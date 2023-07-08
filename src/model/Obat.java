/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Obat {
    private int id_obat;
    private String nama;
    private String dosis;
    private String keterangan;
    private double harga;

    public Obat(int id_obat, String nama, String dosis, String keterangan, double harga) {
        this.id_obat = id_obat;
        this.nama = nama;
        this.dosis = dosis;
        this.keterangan = keterangan;
        this.harga = harga;
    }
    
    public Obat(String nama, String dosis, String keterangan, double harga) {
        this.id_obat = id_obat;
        this.nama = nama;
        this.dosis = dosis;
        this.keterangan = keterangan;
        this.harga = harga;
    }

    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    @Override
    public String toString(){
        return this.nama;
    }
}

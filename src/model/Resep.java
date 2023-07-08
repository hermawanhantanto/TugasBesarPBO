/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Resep {
    private int id_resep;
    private Pasien pasien;
    private Dokter dokter;
    private Obat obat;
    private String tanggal;
    private String keterangan;

    public Resep(int id_resep, Pasien pasien, Dokter dokter, Obat obat, String tanggal, String keterangan) {
        this.id_resep = id_resep;
        this.pasien = pasien;
        this.dokter = dokter;
        this.obat = obat;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }
    
    public Resep(Pasien pasien, Dokter dokter, Obat obat, String tanggal, String keterangan) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.obat = obat;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public Pasien getPasien() {
        return pasien;
    }
    
    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }
    
    public int getId_resep() {
        return id_resep;
    }

    public void setId_resep(int id_resep) {
        this.id_resep = id_resep;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Dokter getDokter() {
        return dokter;
    }
    
    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Obat getObat() {
        return obat;
    }
    
    public void setObat(Obat obat) {
        this.obat = obat;
    }
}

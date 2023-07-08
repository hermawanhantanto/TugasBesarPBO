/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Perawatan {
    private int id_perawatan;
    private Pasien pasien;
    private Obat obat;
    private String jenisPerawatan;
    private String status;
    private int durasi;

    public Perawatan(int id_perawatan, Pasien pasien, Obat obat, String jenisPerawatan, int durasi, String status) {
        this.id_perawatan = id_perawatan;
        this.pasien = pasien;
        this.obat = obat;
        this.jenisPerawatan = jenisPerawatan;
        this.durasi = durasi;
        this.status = status;
    }
    
    public Perawatan(Pasien pasien, Obat obat, String jenisPerawatan, int durasi, String status) {
        this.pasien = pasien;
        this.obat = obat;
        this.jenisPerawatan = jenisPerawatan;
        this.status = status;
        this.durasi = durasi;
    }

    public Pasien getPasien() {
        return pasien;
    }
    
    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }
    
    public int getId_perawatan() {
        return id_perawatan;
    }

    public void setId_perawatan(int id_perawatan) {
        this.id_perawatan = id_perawatan;
    }

    public Obat getObat() {
        return obat;
    }
    
    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public String getJenisPerawatan() {
        return jenisPerawatan;
    }

    public void setJenisPerawatan(String jenisPerawatan) {
        this.jenisPerawatan = jenisPerawatan;
    }

    public int getDurasi() {
        return durasi;
    }
    
    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


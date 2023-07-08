/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class RekamMedis {
    private int id;
    private Pasien pasien;
    private Dokter dokter;
    private String diagnosa;
    private String tanggal;
    private double totalBiaya;

    public RekamMedis(int id, Pasien pasien, Dokter dokter, String diagnosa, String tanggal, double totalBiaya) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.diagnosa = diagnosa;
        this.tanggal = tanggal;
        this.totalBiaya = totalBiaya;
    }
    
     public RekamMedis(Pasien pasien, Dokter dokter, String diagnosa, String tanggal, double totalBiaya) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.diagnosa = diagnosa;
        this.tanggal = tanggal;
        this.totalBiaya = totalBiaya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    } 
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Dokter {
    private String id_dokter;
    private String nama;
    private String spesialisasi;
    private String npaidi;
    private String telepon;

    public Dokter(String id_dokter, String nama, String spesialisasi, String npaidi, String telepon) {
        this.id_dokter = id_dokter;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.npaidi = npaidi;
        this.telepon = telepon;
    }

    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getNpaidi() {
        return this.npaidi;
    }

    public void setNpaidi(String npaidi) {
        this.npaidi = npaidi;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}

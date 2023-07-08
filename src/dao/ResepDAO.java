/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Resep;
import model.Obat;
import model.Dokter;
import connection.DbConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Pasien;

public class ResepDAO {
    
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Memasukkan Data Resep
    public void insertDataResep(Resep r){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO resep (id_pasien, id_dokter, id_obat, tanggal, keterangan)"
               +"VALUES ('"+r.getPasien().getId_pasien()+"', '"+r.getDokter().getId_dokter()+"', '"+r.getObat().getId_obat()+"', '"+r.getTanggal()+"', '"+r.getKeterangan()+"')";
        
        System.out.println("Adding Resep.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Resep");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Adding Resep.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan Data Resep
    public List<Resep> showDataResep(String query){
       con = dbCon.makeConnection();
        
       String sql = "SELECT r.*, p.*, d.*, o.* FROM pasien as p JOIN resep r ON p.id_pasien = r.id_pasien JOIN "
            + "dokter d on r.id_dokter = d.id_dokter JOIN "
            + "obat o on r.id_obat = o.id_obat WHERE (p.nama LIKE '%" +query+ "%'"
            + "OR r.id_resep LIKE '%" +query+ "%'"
            + "OR d.nama LIKE '%" +query+ "%'"
            + "OR o.nama LIKE '%" +query+ "%'"
            + "OR o.dosis LIKE '%" +query+ "%'"
            + "OR r.tanggal LIKE '%" +query+ "%'"
            + "OR r.keterangan LIKE '%" +query+ "%')";

        
        System.out.println("Mengambil data Resep...");
        
        List<Resep> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    Pasien p = new Pasien (
                                rs.getInt("p.id_pasien"),
                                rs.getString("p.nama"),
                                rs.getString("p.jenis_kelamin"),
                                rs.getInt("p.usia"),
                                rs.getString("p.no_telepon"));
                    
                    Dokter d = new Dokter (
                                rs.getString("d.id_dokter"),
                                rs.getString("d.nama"),
                                rs.getString("d.spesialisasi"),
                                rs.getString("d.npaidi"),
                                rs.getString("d.telepon"));
                    
                    Obat o = new Obat (
                        Integer.parseInt(rs.getString("o.id_obat")),
                        rs.getString("o.nama"),
                        rs.getString("o.dosis"),
                        rs.getString("o.keterangan"),
                        Double.parseDouble(rs.getString("harga")));
                    
                    Resep r = new Resep(
                            rs.getInt("r.id_resep"),
                            p,d,o,
                            rs.getString("r.tanggal"),
                            rs.getString("r.keterangan"));
                    list.add(r);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.err.println("Error Reading Database.....");
            System.err.println(e);
        }
        return list;
   }
    
    // Mengubah Data Resep
    public void updateDataResep(Resep r, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE resep SET id_pasien = '" +r.getPasien().getId_pasien()+ "',"
                + "id_dokter = '" +r.getDokter().getId_dokter()+ "',"
                + "id_obat = '" +r.getObat().getId_obat()+ "',"
                + "tanggal = '" +r.getTanggal()+ "',"
                + "keterangan = '" +r.getKeterangan()+ "'"
                + "WHERE id_resep = '" + id + "'";
        
        System.out.println("Editing Resep.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited Resep " +result+ " Resep");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Editing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Mencari Data Resep berdasarkan ID
    public Resep searchDataResep(int id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM resep WHERE id_resep = '" + id + "'";
        System.out.println("Searching Resep.....");

        Resep r = null;
        Pasien p = null;
        Dokter d = null;
        Obat o = null;

        PasienDAO pDAO = null;
        DokterDAO dDAO = null;
        ObatDAO oDAO = null;

        try {
            pDAO = new PasienDAO();
            dDAO = new DokterDAO();
            oDAO = new ObatDAO();

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    r = new Resep(
                            p = pDAO.searchDataPasien(Integer.parseInt(rs.getString("id_pasien"))),
                            d = dDAO.searchDataDokter(rs.getString("id_dokter")),
                            o = oDAO.searchDataObat(Integer.parseInt(rs.getString("id_obat"))),
                            rs.getString("tanggal"), rs.getString("keterangan"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Searching Resep.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return r;
    }

    //Menghapus Data Resep berdasarkan ID;
    public void deleteDataResep(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM resep "
                    + "WHERE (id_resep LIKE '%" +id+ "%')";
        
        System.out.println("Deleting Resep.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " +result+ " Resep");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Deleting Resep.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
}

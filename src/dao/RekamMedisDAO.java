/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Dokter;
import model.Pasien;
import model.RekamMedis;


public class RekamMedisDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Memasukkan Data RekamMedis
    public void insertDataRekamMedis(RekamMedis rm){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO rekam_medis (id_pasien, id_dokter, diagnosa, tanggal, total_biaya)"
               +"VALUES ('"+rm.getPasien().getId_pasien()+"', '"+rm.getDokter().getId_dokter()+"', '"+rm.getDiagnosa()+"', '"+rm.getTanggal()+"', '"+rm.getTotalBiaya()+"')";
        
        System.out.println("Adding Rekam Medis.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Rekam Medis");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Adding Rekam Medis.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan Data RekamMedis
    public List<RekamMedis> showDataRekamMedis(String query){
       con = dbCon.makeConnection();
        
       String sql = "SELECT rm.*, p.*, d.* FROM pasien as p JOIN rekam_medis rm ON p.id_pasien = rm.id_pasien JOIN "
            + "dokter d on rm.id_dokter = d.id_dokter WHERE (rm.id_rekam_medis LIKE '%" +query+ "%'"
            + "OR p.nama LIKE '%" +query+ "%'"
            + "OR d.nama LIKE '%" +query+ "%'"
            + "OR rm.diagnosa LIKE '%" +query+ "%'"
            + "OR rm.tanggal LIKE '%" +query+ "%'"
            + "OR rm.total_biaya LIKE '%" +query+ "%')";
              
        System.out.println("Mengambil data Rekam Medis...");
        
        List<RekamMedis> list = new ArrayList<>();
        
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
                    
                    RekamMedis rm = new RekamMedis(
                            Integer.parseInt(rs.getString("rm.id_rekam_medis")),
                            p, d,
                            rs.getString("rm.diagnosa"),
                            rs.getString("rm.tanggal"),
                            Double.parseDouble(rs.getString("rm.total_biaya")));
                    
                    list.add(rm);
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
    
    // Mengubah Data RekamMedis
    public void updateDataRekamMedis(RekamMedis rm, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE rekam_medis SET id_pasien = '" +rm.getPasien().getId_pasien()+ "',"
                + "id_dokter = '"+rm.getDokter().getId_dokter()+ "',"
                + "diagnosa = '"+rm.getDiagnosa()+ "',"
                + "tanggal = '"+rm.getTanggal()+ "',"
                + "total_biaya = '"+rm.getTotalBiaya()+ "'"
                + "WHERE id_rekam_medis = '" + id + "'";
        
        System.out.println("Editing Rekam Medis.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited Rekam Medis " +result+ " Rekam Medis");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Editing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Mencari Data RekamMedis berdasarkan ID
    public RekamMedis searchDataRekamMedis(int id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM rekam_medis WHERE id_rekam_medis = '" + id + "'";
        System.out.println("Searching Rekam Medis.....");

        RekamMedis rm = null;
        Pasien p = null;
        Dokter d = null;

        PasienDAO pDAO = null;
        DokterDAO dDAO = null;

        try {
            pDAO = new PasienDAO();
            dDAO = new DokterDAO();

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    rm = new RekamMedis(
                            p = pDAO.searchDataPasien(Integer.parseInt(rs.getString("id_pasien"))),
                            d = dDAO.searchDataDokter(rs.getString("id_dokter")),
                            rs.getString("diagnosa"), 
                            rs.getString("tanggal"),
                            Double.parseDouble(rs.getString("total_biaya")));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Searching Rekam Medis.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return rm;
    }

    //Menghapus Data RekamMedis berdasarkan ID;
    public void deleteDataRekamMedis(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM rekam_medis "
                    + "WHERE (id_rekam_medis LIKE '%" +id+ "%')";
        
        System.out.println("Deleting Rekam Medis.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " +result+ " Rekam Medis");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Deleting Rekam Medis.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
}

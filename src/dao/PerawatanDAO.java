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
import model.Obat;
import model.Pasien;
import model.Perawatan;


public class PerawatanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Memasukkan Data Perawatan
    public void insertDataPerawatan(Perawatan pw){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO perawatan (id_pasien, id_obat, jenis_perawatan, durasi, status)"
               +"VALUES ('"+pw.getPasien().getId_pasien()+"', '"+pw.getObat().getId_obat()+"', '"+pw.getJenisPerawatan()+"', '"+pw.getDurasi()+"', '"+pw.getStatus()+"')";
        
        System.out.println("Adding Perawatan.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Perawatan");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Adding Perawatan.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan Data Perawatan
    public List<Perawatan> showDataPerawatan(String query){
       con = dbCon.makeConnection();
        
       String sql = "SELECT pw.*, p.*, o.* FROM pasien as p JOIN perawatan pw ON p.id_pasien = pw.id_pasien JOIN "
            + "obat o on pw.id_obat = o.id_obat WHERE (pw.id_perawatan LIKE '%" +query+ "%'"
            + "OR p.nama LIKE '%" +query+ "%'"
            + "OR o.nama LIKE '%" +query+ "%'"
            + "OR o.dosis LIKE '%" +query+ "%'"
            + "OR pw.jenis_perawatan LIKE '%" +query+ "%'"
            + "OR pw.durasi LIKE '%" +query+ "%'"
            + "OR pw.status LIKE '%" +query+ "%')";


        
        System.out.println("Mengambil data Perawatan...");
        
        List<Perawatan> list = new ArrayList<>();
        
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
                    
                    Obat o = new Obat (
                        Integer.parseInt(rs.getString("o.id_obat")),
                        rs.getString("o.nama"),
                        rs.getString("o.dosis"),
                        rs.getString("o.keterangan"),
                        Double.parseDouble(rs.getString("o.harga")));
                    
                    Perawatan pw = new Perawatan(
                            Integer.parseInt(rs.getString("pw.id_perawatan")),
                            p, o,
                            rs.getString("pw.jenis_perawatan"),
                            rs.getInt("pw.durasi"),
                            rs.getString("pw.status"));
                    list.add(pw);
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
    
    // Mengubah Data Perawatan
    public void updateDataPerawatan(Perawatan pw, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE perawatan SET id_pasien = '" +pw.getPasien().getId_pasien()+ "',"
                + "id_obat = '"+pw.getObat().getId_obat()+ "',"
                + "jenis_perawatan = '"+pw.getJenisPerawatan()+ "',"
                + "durasi = '"+pw.getDurasi()+ "',"
                + "status = '"+pw.getStatus()+ "'"
                + "WHERE id_perawatan = '" + id + "'";
        
        System.out.println("Editing Perawatan.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited Perawatan " +result+ " Perawatan");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Editing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Mencari Data Perawatan berdasarkan ID
    public Perawatan searchDataPerawatan(int id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM perawatan WHERE id_perawatan = '" + id + "'";
        System.out.println("Searching Perawatan.....");

        Perawatan pw = null;
        Pasien p = null;
        Obat o = null;

        PasienDAO pDAO = null;
        ObatDAO oDAO = null;

        try {
            pDAO = new PasienDAO();
            oDAO = new ObatDAO();

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    pw = new Perawatan(
                            p = pDAO.searchDataPasien(Integer.parseInt(rs.getString("id_pasien"))),
                            o = oDAO.searchDataObat(Integer.parseInt(rs.getString("id_obat"))),
                            rs.getString("jenis_perawatan"), 
                            (Integer.parseInt(rs.getString("durasi"))),
                            rs.getString("status"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Error Searching Perawatan.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return pw;
    }

    //Menghapus Data Perawatan berdasarkan ID;
    public void deleteDataPerawatan(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM perawatan "
                    + "WHERE (id_perawatan LIKE '%" +id+ "%')";
        
        System.out.println("Deleting Perawatan.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " +result+ " Perawatan");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Deleting Perawatan.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
}

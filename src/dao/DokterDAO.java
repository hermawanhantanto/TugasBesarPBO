/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Dokter;
import connection.DbConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DokterDAO {
    
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Memasukkan Data Dokter
    public void insertDataDokter(Dokter d){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO dokter (id_dokter, nama, spesialisasi, npaidi, telepon)"
               +"VALUES ('"+d.getId_dokter()+"', '"+d.getNama()+"', '"+d.getSpesialisasi()+"', '"+d.getNpaidi()+"', '"+d.getTelepon()+"')";
        
        System.out.println("Adding Dokter.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Dokter");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Adding Dokter.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan Data Dokter
    public List<Dokter> showDataDokter(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT d.id_dokter, d.nama, d.spesialisasi, d.npaidi, d.telepon FROM dokter d WHERE d.id_dokter LIKE '%" + query + "%' "
                + "OR d.nama LIKE '%" + query + "%'"
                + "OR d.spesialisasi LIKE '%" + query + "%'"
                + "OR d.npaidi LIKE '%" + query + "%'"
                + "OR d.telepon LIKE '%" + query + "%'";
        
        System.out.println("Showing Data Dokter.....");
        
        List<Dokter> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    Dokter d = new Dokter (
                                rs.getString("d.id_dokter"),
                                rs.getString("d.nama"),
                                rs.getString("d.spesialisasi"),
                                rs.getString("d.npaidi"),
                                rs.getString("d.telepon"));
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.err.println("Error Showing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    // Mengubah Data Dokter
    public void updateDataDokter(Dokter d, String id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE dokter SET nama = '" + d.getNama()+ "',"
                + "spesialisasi = '" +d.getSpesialisasi()+ "',"
                + "npaidi = '" + d.getNpaidi()+ "',"
                + "telepon = '" + d.getTelepon()+ "'"
                + "WHERE id_dokter = '" + id + "'";
        
        System.out.println("Editing Dokter.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited Dokter " +result+ " Dokter");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Editing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Mencari Data Dokter berdasarkan ID
    public Dokter searchDataDokter(String id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM dokter WHERE id_dokter = '" + id + "'";
        System.out.println("Searching Dokter.....");
        
        Dokter d = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    d = new Dokter (
                        rs.getString("id_dokter"),
                        rs.getString("nama"),
                        rs.getString("spesialisasi"),
                        rs.getString("npaidi"),
                        rs.getString("telepon"));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.err.println("Error Searching Dokter.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return d;
    }
    
    //Menghapus Data Pasien berdasarkan ID;
    public void deleteDataDokter(String id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM dokter WHERE id_dokter = '" +id+ "'";
        System.out.println("Deleting Dokter.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " +result+ " Dokter");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Deleting Dokter.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan semua data dokter
    public List<Dokter> showAllDataDokter(){
        con = dbCon.makeConnection();
        String sql = "SELECT * from dokter";
        System.out.println("Mengambil data Dokter...");
        
        List<Dokter> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Dokter d = new Dokter (
                                rs.getString("id_dokter"),
                                rs.getString("nama"),
                                rs.getString("spesialisasi"),
                                rs.getString("npaidi"),
                                rs.getString("telepon"));
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.err.println("Error Reading Database...");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
}

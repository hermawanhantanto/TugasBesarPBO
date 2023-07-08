/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Pasien;
import connection.DbConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PasienDAO {
    
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Memasukkan Data Pasien
    public void insertDataPasien(Pasien p){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO pasien (nama, jenis_kelamin, usia, no_telepon)"
               +"VALUES ('"+p.getNama()+"', '"+p.getJenis_kelamin()+"', "+p.getUsia()+", '"+p.getNo_telepon()+"')";
        
        System.out.println("Adding Pasien.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Pasien");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Adding Pasien.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan Data Pasien
    public List<Pasien> showDataPasien(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT p.id_pasien, p.nama, p.jenis_kelamin,p.usia,p.no_telepon FROM pasien p WHERE p.id_pasien LIKE '%" + query + "%' "
                + "OR p.nama LIKE '%" + query + "%'"
                + "OR p.jenis_kelamin LIKE '%" + query + "%'"
                + "OR p.usia LIKE '%" + query + "%'"
                + "OR p.no_telepon LIKE '%" + query + "%'";
        
        System.out.println("Showing Data Pasien.....");
        
        List<Pasien> list = new ArrayList<>();
        
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
                    list.add(p);
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
    
    // Mengubah Data Pasien
    public void updateDataPasien(Pasien p, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE pasien SET nama = '" + p.getNama()+ "',"
                + "jenis_kelamin = '" +p.getJenis_kelamin()+ "',"
                + "usia = '" + p.getUsia()+ "',"
                + "no_telepon = '" + p.getNo_telepon()+ "'"
                + "WHERE id_pasien = '" + id + "'";
        
        System.out.println("Editing Pasien.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited Pasien " +result+ " Pasien");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Editing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Mencari Data Pasien berdasarkan ID
    public Pasien searchDataPasien(int id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pasien WHERE id_pasien = '" + id + "'";
        System.out.println("Searching Pasien.....");
        
        Pasien p = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    p = new Pasien (
                        Integer.parseInt(rs.getString("id_pasien")),
                        rs.getString("nama"),
                        rs.getString("jenis_kelamin"),
                        Integer.parseInt(rs.getString("usia")),
                        rs.getString("no_telepon"));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.err.println("Error Searching Pasien.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return p;
    }
    
    //Menghapus Data Pasien berdasarkan ID;
    public void deleteDataPasien(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM pasien WHERE id_pasien = '" +id+ "'";
        System.out.println("Deleting Pasien.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " +result+ " Pasien");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Deleting Pasien.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Menampilkan semua data pasien
    public List<Pasien> showAllDataPasien(){
        con = dbCon.makeConnection();
        String sql = "SELECT * from pasien";
        System.out.println("Mengambil data Pasien...");
        
        List<Pasien> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    
                    Pasien p = new Pasien (
                                rs.getInt("id_pasien"),
                                rs.getString("nama"),
                                rs.getString("jenis_kelamin"),
                                rs.getInt("usia"),
                                rs.getString("no_telepon"));
                    list.add(p);
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

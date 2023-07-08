/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Obat;
import connection.DbConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ObatDAO {
    
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    // Memasukkan Data Obat
    public void insertDataObat(Obat o){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO obat (nama, dosis, keterangan, harga)"
               +"VALUES ('"+o.getNama()+"', '"+o.getDosis()+"', '"+o.getKeterangan()+"', '"+o.getHarga()+"')";
        
        System.out.println("Adding Obat.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Obat");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Adding Obat.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    // Menampilkan Data Obat
    public List<Obat> showDataObat(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT o.id_obat, o.nama, o.dosis ,o.keterangan, o.harga FROM obat o WHERE o.id_obat LIKE '%" + query + "%' "
                + "OR o.nama LIKE '%" + query + "%'"
                + "OR o.dosis LIKE '%" + query + "%'"
                + "OR o.keterangan LIKE '%" + query + "%'"
                + "OR o.harga LIKE '%" + query + "%'";
        
        System.out.println("Showing Data Obat.....");
        
        List<Obat> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    Obat o = new Obat (
                                rs.getInt("o.id_obat"),
                                rs.getString("o.nama"),
                                rs.getString("o.dosis"),
                                rs.getString("o.keterangan"),
                                rs.getDouble("o.harga"));
                    list.add(o);
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
    
    // Mengubah Data Obat
    public void updateDataObat(Obat o, int id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE obat SET nama = '" + o.getNama()+ "',"
                + "dosis = '" +o.getDosis()+ "',"
                + "keterangan = '" + o.getKeterangan()+ "',"
                + "harga = '" + o.getHarga()+ "'"
                + "WHERE id_obat = '" + id + "'";
        
        System.out.println("Editing Obat.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited Obat " +result+ " Obat");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Editing Database.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Mencari Data Obat berdasarkan ID
    public Obat searchDataObat(int id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Obat WHERE id_obat = '" + id + "'";
        System.out.println("Searching Obat.....");
        
        Obat o = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    o = new Obat (
                        Integer.parseInt(rs.getString("id_obat")),
                        rs.getString("nama"),
                        rs.getString("dosis"),
                        rs.getString("keterangan"),
                        Double.parseDouble(rs.getString("harga")));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.err.println("Error Searching Obat.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
        return o;
    }
    
    //Menghapus Data Obat berdasarkan ID;
    public void deleteDataObat(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM obat WHERE id_obat = '" +id+ "'";
        System.out.println("Deleting Obat.....");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " +result+ " Obat");
            statement.close();
        }catch(Exception e){
            System.err.println("Error Deleting Obat.....");
            System.err.println(e);
        }
        dbCon.closeConnection();
    }
    
    //Menampilkan semua data obat
    public List<Obat> showAllDataObat(){
        con = dbCon.makeConnection();
        String sql = "SELECT * from obat";
        System.out.println("Mengambil data Obat...");
        
        List<Obat> list = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Obat o = new Obat (
                                rs.getInt("id_obat"),
                                rs.getString("nama"),
                                rs.getString("dosis"),
                                rs.getString("keterangan"),
                                rs.getDouble("harga"));
                    list.add(o); 
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

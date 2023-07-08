/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import java.util.List;
import dao.PasienDAO;
import model.Pasien;
import table.PasienTable;

public class PasienControl {
    private PasienDAO pDAO = new PasienDAO();
    
    public void insertPasien(Pasien p){
        pDAO.insertDataPasien(p);
    }
    
    public PasienTable showPasien(String query){
        List<Pasien> listPasien = pDAO.showDataPasien(query);
        PasienTable pasienTable = new PasienTable(listPasien);
        return pasienTable;
    }
    
    public void deletePasien(int id){
        pDAO.deleteDataPasien(id);
    }
    
    public Pasien searchPasien(int id){
        Pasien p = null;
        p = pDAO.searchDataPasien(id);
        return p;
    }
    
    public void updatePasien(Pasien p, int id){
        pDAO.updateDataPasien(p, id);
    }
    
    public List<Pasien> showAllPasien(){
        List<Pasien> p = pDAO.showAllDataPasien();
        return p;
    }
}

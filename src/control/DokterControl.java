/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import java.util.List;
import dao.DokterDAO;
import model.Dokter;
import table.DokterTable;

public class DokterControl {
    private DokterDAO dDAO = new DokterDAO();
    
    public void insertDokter(Dokter d){
        dDAO.insertDataDokter(d);
    }
    
    public DokterTable showDokter(String query){
        List<Dokter> listDokter = dDAO.showDataDokter(query);
        DokterTable dokterTable = new DokterTable(listDokter);
        return dokterTable;
    }
    
    public void deleteDokter(String id){
        dDAO.deleteDataDokter(id);
    }
    
    public Dokter searchDokter(String id){
        Dokter d = null;
        d = dDAO.searchDataDokter(id);
        return d;
    }
    
    public void updateDokter(Dokter d, String id){
        dDAO.updateDataDokter(d, id);
    }
    
    public List<Dokter> showAllDokter(){
        List<Dokter> d = dDAO.showAllDataDokter();
        return d;
    }
}

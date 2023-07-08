/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import java.util.List;
import dao.ObatDAO;
import model.Obat;
import table.ObatTable;

public class ObatControl {
    private ObatDAO oDAO = new ObatDAO();
    
    public void insertObat(Obat o){
        oDAO.insertDataObat(o);
    }
    
    public ObatTable showObat(String query){
        List<Obat> listObat = oDAO.showDataObat(query);
        ObatTable obatTable = new ObatTable(listObat);
        return obatTable;
    }
    
    public void deleteObat(int id){
        oDAO.deleteDataObat(id);
    }
    
    public Obat searchObat(int id){
        Obat o = null;
        o = oDAO.searchDataObat(id);
        return o;
    }
    
    public void updateObat(Obat o, int id){
        oDAO.updateDataObat(o, id);
    }
    
    public List<Obat> showAllObat(){
        List<Obat> o = oDAO.showAllDataObat();
        return o;
    }
}

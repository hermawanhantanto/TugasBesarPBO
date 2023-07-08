/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import java.util.List;
import dao.ResepDAO;
import model.Resep;
import table.ResepTable;

public class ResepControl {
    private ResepDAO rDAO = new ResepDAO();
    
    public void insertResep(Resep r){
        rDAO.insertDataResep(r);
    }
    
    public ResepTable showResep(String query){
        List<Resep> listResep = rDAO.showDataResep(query);
        ResepTable resepTable = new ResepTable(listResep);
        return resepTable;
    }
    
    public void deleteResep(int id){
        rDAO.deleteDataResep(id);
    }
    
    public Resep searchResep(int id){
        Resep r = null;
        r = rDAO.searchDataResep(id);
        return r;
    }
    
    public void updateResep(Resep r, int id){
        rDAO.updateDataResep(r, id);
    }
}
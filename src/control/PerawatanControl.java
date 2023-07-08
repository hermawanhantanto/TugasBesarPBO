/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.PerawatanDAO;
import java.util.List;
import model.Perawatan;
import table.PerawatanTable;

public class PerawatanControl {
    private PerawatanDAO pwDAO = new PerawatanDAO();
    
    public void insertPerawatan(Perawatan pw){
        pwDAO.insertDataPerawatan(pw);
    }
    
    public PerawatanTable showPerawatan(String query){
        List<Perawatan> listPerawatan = pwDAO.showDataPerawatan(query);
        PerawatanTable perawatanTable = new PerawatanTable(listPerawatan);
        return perawatanTable;
    }
    
    public void deletePerawatan(int id){
        pwDAO.deleteDataPerawatan(id);
    }
    
    public Perawatan searchPerawatan(int id){
        Perawatan pw = null;
        pw = pwDAO.searchDataPerawatan(id);
        return pw;
    }
    
    public void updatePerawatan(Perawatan pw, int id){
        pwDAO.updateDataPerawatan(pw, id);
    }
}

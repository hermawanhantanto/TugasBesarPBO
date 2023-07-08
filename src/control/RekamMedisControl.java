/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;


import java.util.List;
import dao.RekamMedisDAO;
import model.RekamMedis;
import table.RekamMedisTable;

public class RekamMedisControl {
    private RekamMedisDAO rmDAO = new RekamMedisDAO();
    
    public void insertRekamMedis(RekamMedis rm){
        rmDAO.insertDataRekamMedis(rm);
    }
    
    public RekamMedisTable showRekamMedis(String query){
        List<RekamMedis> listRekamMedis = rmDAO.showDataRekamMedis(query);
        RekamMedisTable rekamMedisTable = new RekamMedisTable(listRekamMedis);
        return rekamMedisTable;
    }
    
    public void deleteRekamMedis(int id){
        rmDAO.deleteDataRekamMedis(id);
    }
    
    public RekamMedis searchRekamMedis(int id){
        RekamMedis rm = null;
        rm = rmDAO.searchDataRekamMedis(id);
        return rm;
    }
    
    public void updateRekamMedis(RekamMedis rm, int id){
        rmDAO.updateDataRekamMedis(rm, id);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Dokter;

public class DokterTable extends AbstractTableModel{
    
    private List<Dokter> listDokter;

    public DokterTable(List<Dokter> listDokter) {
        this.listDokter = listDokter;
    }
    
    @Override
    public int getRowCount(){
        return listDokter.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listDokter.get(rowIndex).getId_dokter();
            case 1:
                return listDokter.get(rowIndex).getNama();
            case 2:
                return listDokter.get(rowIndex).getSpesialisasi();
            case 3:
                return listDokter.get(rowIndex).getNpaidi();
            case 4 :
                return listDokter.get(rowIndex).getTelepon();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Dokter";
            case 1:
                return "Nama Dokter";
            case 2:
                return "Spesialisasi";
            case 3:
                return "Npaidi";
            case 4 :
                return "No Telepon";    
            default:
                return null;
        }
    }   
}

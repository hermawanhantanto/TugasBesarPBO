/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Obat;

public class ObatTable extends AbstractTableModel{
    
    private List<Obat> listObat;

    public ObatTable(List<Obat> listObat) {
        this.listObat = listObat;
    }
    
    @Override
    public int getRowCount(){
        return listObat.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listObat.get(rowIndex).getId_obat();
            case 1:
                return listObat.get(rowIndex).getNama();
            case 2:
                return listObat.get(rowIndex).getDosis();
            case 3:
                return listObat.get(rowIndex).getKeterangan();
            case 4 :
                return listObat.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Obat";
            case 1:
                return "Nama Obat";
            case 2:
                return "Dosis";
            case 3:
                return "Keterangan";
            case 4 :
                return "Harga";    
            default:
                return null;
        }
    }   
}

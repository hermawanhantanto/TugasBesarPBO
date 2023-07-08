/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pasien;

public class PasienTable extends AbstractTableModel{
    
    private List<Pasien> listPasien;

    public PasienTable(List<Pasien> listPasien) {
        this.listPasien = listPasien;
    }
    
    @Override
    public int getRowCount(){
        return listPasien.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listPasien.get(rowIndex).getId_pasien();
            case 1:
                return listPasien.get(rowIndex).getNama();
            case 2:
                return listPasien.get(rowIndex).getJenis_kelamin();
            case 3:
                return listPasien.get(rowIndex).getUsia();
            case 4 :
                return listPasien.get(rowIndex).getNo_telepon();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Pasien";
            case 1:
                return "Nama Pasien";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Usia Pasien";
            case 4 :
                return "Nomor Telepon";    
            default:
                return null;
        }
    }   
}

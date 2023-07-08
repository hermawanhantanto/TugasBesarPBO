/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.RekamMedis;


public class RekamMedisTable extends AbstractTableModel {
    
    private List<RekamMedis> listRekamMedis;

    public RekamMedisTable(List<RekamMedis> listRekamMedis) {
        this.listRekamMedis = listRekamMedis;
    }

    @Override
    public int getRowCount() {
        return listRekamMedis.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listRekamMedis.get(rowIndex).getId();
            case 1:
                return listRekamMedis.get(rowIndex).getPasien().getNama();
            case 2:
                return listRekamMedis.get(rowIndex).getDokter().getNama();
            case 3:
                return listRekamMedis.get(rowIndex).getDiagnosa();
            case 4:
                return listRekamMedis.get(rowIndex).getTanggal();
            case 5:
                return listRekamMedis.get(rowIndex).getTotalBiaya();
            case 6:
                return listRekamMedis.get(rowIndex).getPasien().getId_pasien();
            case 7:
                return listRekamMedis.get(rowIndex).getDokter().getId_dokter();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID RekamMedis";
            case 1:
                return "Nama Pasien";
            case 2:
                return "Nama Dokter";
            case 3:
                return "Diagnosa";
            case 4:
                return "Tanggal";
            case 5:
                return "Total Biaya";
            default:
                return null;
        }
    }
}

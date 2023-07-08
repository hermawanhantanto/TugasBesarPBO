/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Resep;

public class ResepTable extends AbstractTableModel{
    
    private List<Resep> listResep;

    public ResepTable(List<Resep> listResep) {
        this.listResep = listResep;
    }

    @Override
    public int getRowCount() {
        return listResep.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listResep.get(rowIndex).getId_resep();
            case 1:
                return listResep.get(rowIndex).getPasien().getNama();
            case 2:
                return listResep.get(rowIndex).getDokter().getNama();
            case 3:
                return listResep.get(rowIndex).getObat().getNama();
            case 4:
                return listResep.get(rowIndex).getObat().getDosis();
            case 5:
                return listResep.get(rowIndex).getTanggal();
            case 6:
                return listResep.get(rowIndex).getKeterangan();
            case 7:
                return listResep.get(rowIndex).getPasien().getId_pasien();
            case 8:
                return listResep.get(rowIndex).getDokter().getId_dokter();
            case 9:
                return listResep.get(rowIndex).getObat().getId_obat();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Resep";
            case 1:
                return "Nama Pasien";
            case 2:
                return "Nama Dokter";
            case 3:
                return "Nama Obat";
            case 4:
                return "Dosis";
            case 5:
                return "Tanggal";
            case 6:
                return "Keterangan";
            default:
                return null;
        }
    }
}

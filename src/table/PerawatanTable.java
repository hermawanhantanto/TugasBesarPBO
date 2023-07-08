/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Perawatan;

public class PerawatanTable extends AbstractTableModel{
    private List<Perawatan> listPerawatan;

    public PerawatanTable(List<Perawatan> listPerawatan) {
        this.listPerawatan = listPerawatan;
    }

    @Override
    public int getRowCount() {
        return listPerawatan.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listPerawatan.get(rowIndex).getId_perawatan();
            case 1:
                return listPerawatan.get(rowIndex).getPasien().getNama();
            case 2:
                return listPerawatan.get(rowIndex).getObat().getNama();
            case 3:
                return listPerawatan.get(rowIndex).getObat().getDosis();
            case 4:
                return listPerawatan.get(rowIndex).getJenisPerawatan();
            case 5:
                return listPerawatan.get(rowIndex).getDurasi();
            case 6:
                return listPerawatan.get(rowIndex).getStatus();
            case 7:
                return listPerawatan.get(rowIndex).getPasien().getId_pasien();
            case 8:
                return listPerawatan.get(rowIndex).getObat().getId_obat();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Perawatan";
            case 1:
                return "Nama Pasien";
            case 2:
                return "Nama Obat";
            case 3:
                return "Dosis";
            case 4:
                return "Jenis Perawatan";
            case 5:
                return "Durasi Hari";
            case 6:
                return "Status";
            default:
                return null;
        }
    }
}

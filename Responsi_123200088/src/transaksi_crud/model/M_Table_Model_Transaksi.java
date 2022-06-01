package transaksi_crud.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 */

public class M_Table_Model_Transaksi  extends AbstractTableModel{
    
    List<Model_transaksi> list_transaksi;

    public M_Table_Model_Transaksi(List<Model_transaksi> list_transaksi) {
        this.list_transaksi = list_transaksi;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }


    public int getRowCount() {
        return list_transaksi.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID/KODE";
            case 1:
                return "NAMA";
            case 2:
                return "NAMA KASIR";
            case 3:
                return "QUANTITY";
            case 4:
                return "PRICE PER QUANTITY";
            case 5:
                return "DISCOUNT";
            case 6:
                return "TOTAL PRICE";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_transaksi.get(row).getId();
            case 1:
                return list_transaksi.get(row).getNama_barang();
            case 2:
                return list_transaksi.get(row).getNama_kasir();
            case 3:
                return list_transaksi.get(row).getQty();
            case 4:
                return list_transaksi.get(row).getPrice_per_qty();
            case 5:
                return list_transaksi.get(row).getDiscount();
            case 6:
                return list_transaksi.get(row).getPrice_total();
            default:
                return null;
        }
    }
}

package transaksi_crud.controller;

import transaksi_crud.DAO.DAO_Transaksi;
import transaksi_crud.model.Model_transaksi;
import transaksi_crud.model.M_Table_Model_Transaksi;
import Transaksi.Transaksi;
import java.util.List;
import javax.swing.JOptionPane;
import transaksi_crud.DAOImplement.Implement_Transaksi;

/**
 */
public class Cont_Transaksi {
    
    Transaksi frame_transaksi;
    Implement_Transaksi implement_transaksi;
    List<Model_transaksi> list_transaksi;
    
    public Cont_Transaksi(Transaksi frame_transaksi) {
        this.frame_transaksi = frame_transaksi;
        implement_transaksi = new DAO_Transaksi();
        list_transaksi = implement_transaksi.getALL();
    }
    
    //Reset Kosongkan Field
    public void reset() {
        frame_transaksi.getTxtID().setText("");
        frame_transaksi.getTxtNamaBarang().setText("");
        frame_transaksi.getTxtNamaKasir().setText("");
        frame_transaksi.getTxtQty().setText("");
        frame_transaksi.getTxtPrice_per_qty().setText("");
        frame_transaksi.getTxtDiscount().setText("");
        frame_transaksi.getTxtPrice_total().setText("");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable() {
        list_transaksi = implement_transaksi.getALL();
        M_Table_Model_Transaksi tmb = new M_Table_Model_Transaksi(list_transaksi);
        frame_transaksi.getTabelDataTransaksi().setModel(tmb);
    }
    
    //Menampilkan Data Yang Di Pilih Dari Tabel
    public void isiField(int row) {
        frame_transaksi.getTxtID().setText(list_transaksi.get(row).getId().toString());
        frame_transaksi.getTxtNamaBarang().setText(list_transaksi.get(row).getNama_barang());
        frame_transaksi.getTxtNamaKasir().setText(list_transaksi.get(row).getNama_kasir());
        frame_transaksi.getTxtQty().setText(list_transaksi.get(row).getQty().toString());
        frame_transaksi.getTxtPrice_per_qty().setText(list_transaksi.get(row).getPrice_per_qty().toString());
        frame_transaksi.getTxtDiscount().setText(list_transaksi.get(row).getDiscount().toString());
        frame_transaksi.getTxtPrice_total().setText(list_transaksi.get(row).getPrice_total().toString());
    }
    
    //Insert Data Dari Frame Ke Database
    public void insert() {
        
        if (!frame_transaksi.getTxtNamaBarang().getText().trim().isEmpty()& !frame_transaksi.getTxtNamaKasir().getText().trim().isEmpty()& !frame_transaksi.getTxtNamaKasir().getText().trim().isEmpty()) {
          
        Model_transaksi b = new Model_transaksi();
        b.setId(frame_transaksi.getTxtID().getText());
        b.setNama_barang(frame_transaksi.getTxtNamaBarang().getText());
        b.setNama_kasir(frame_transaksi.getTxtNamaKasir().getText());
        b.setQty(frame_transaksi.getTxtQty().getText().toString());
        b.setPrice_per_qty(frame_transaksi.getTxtPrice_per_qty().getText().toString());
        b.setDiscount(frame_transaksi.getTxtDiscount().getText().toString());
        b.setPrice_total(frame_transaksi.getTxtPrice_total().getText().toString());

        implement_transaksi.insert(b);
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        
        } else {
            JOptionPane.showMessageDialog(frame_transaksi, "Data Tidak Boleh Ada Yang Kosong !");
        }
    }
    
    //Update Data Ketika Data Di Ubah Pada Frame Di Ubah Ke Database
    public void update() {
      
        if (!frame_transaksi.getTxtID().getText().trim().isEmpty()) {
             
        Model_transaksi b = new Model_transaksi();
        b.setId(frame_transaksi.getTxtID().getText());
        b.setNama_barang(frame_transaksi.getTxtNamaBarang().getText());
        b.setNama_kasir(frame_transaksi.getTxtNamaKasir().getText());
        b.setQty(frame_transaksi.getTxtQty().getText().toString());
        b.setPrice_per_qty(frame_transaksi.getTxtPrice_per_qty().getText().toString());
        b.setDiscount(frame_transaksi.getTxtDiscount().getText().toString());
        b.setPrice_total(frame_transaksi.getTxtPrice_total().getText().toString());
        implement_transaksi.update(b);
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_transaksi, "Silahkan Pilih Data Yang Akan Di Ubah !");
        }
    }
    
    //Hapus / Delete Data Pada Database
    public void delete() {
        if (!frame_transaksi.getTxtID().getText().trim().isEmpty()) {
            String id = (frame_transaksi.getTxtID().getText());
            implement_transaksi.delete(id);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_transaksi, "Silahkan Pilih Data Yang Akan Di Hapus !");
        }
    }
    
    public void isiTableCariNama() {
        list_transaksi = implement_transaksi.getCariNama(frame_transaksi.getTxtCariNamaPelanggan().getText());
        M_Table_Model_Transaksi tmb = new M_Table_Model_Transaksi(list_transaksi);
        frame_transaksi.getTabelDataTransaksi().setModel(tmb);
    }
    
    //public void CekHarga(){
//        int pc = 0;
//        int pcc = 0;
//        int pccc = 0;
//        int ab = 0;
//        //M_Pelanggan b = new Model_transaksi();
//        String p = frame_transaksi.getTxtQty().toString();
//        pc = Integer.parseInt(frame_transaksi.getTxtQty().getText());
//        //String pp = txtPrice_per_qty.toString();
//         pcc = Integer.parseInt(frame_transaksi.getTxtPrice_per_qty().getText());
//        String ppp = frame_transaksi.getTxtDiscount().toString();
//        pccc = Integer.parseInt( frame_transaksi.getTxtDiscount().getText());
//        ab = ((pc*pcc) - (pc*pcc*pccc/100));
//        //String ac = ab.toString();
//        b.setPrice_Total(frame_transaksi.getTxtPrice_total().setText(""+ab));
    //}
    
    public void carinama() {
        if (!frame_transaksi.getTxtCariNamaPelanggan().getText().trim().isEmpty()) {
            implement_transaksi.getCariNama(frame_transaksi.getTxtCariNamaPelanggan().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_transaksi, "SILAHKAN PILIH DATA !");
        }
    }
}

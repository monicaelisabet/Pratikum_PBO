package transaksi_crud.DAO;

import transaksi_crud.koneksi.Koneksi;
import transaksi_crud.model.Model_transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transaksi_crud.DAOImplement.Implement_Transaksi;

/**
 */
public class DAO_Transaksi implements Implement_Transaksi {

    Connection connection;
    final String insert = "INSERT INTO transactions (id_trans,nama_barang, nama_kasir, qty, price_per_qty, discount, price_total) VALUES (?,?,?,?,?,?,?);";
    final String update = "UPDATE transactions set nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? WHERE id_trans=? ;";
    final String delete = "DELETE FROM transactions where id_trans=? ;";
    final String select = "SELECT * FROM transactions;";
    final String carinama = "SELECT * FROM transactions where nama_barang like ?";
    
    public DAO_Transaksi() {
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert(Model_transaksi b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getId());
            statement.setString(2, b.getNama_barang());
            statement.setString(3, b.getNama_kasir());
            statement.setString(4, b.getQty());
            statement.setString(5, b.getPrice_per_qty());
            statement.setString(6, b.getDiscount());
            statement.setString(7, b.getPrice_total());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Model_transaksi b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama_barang());
            statement.setString(2, b.getNama_kasir());
            statement.setString(3, b.getQty());
            statement.setString(4, b.getPrice_per_qty());
            statement.setString(5, b.getDiscount());
            statement.setString(6, b.getPrice_total());
            statement.setString(7, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Model_transaksi> getALL() {
        List<Model_transaksi> lb = null;
        try {
            lb = new ArrayList<Model_transaksi>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Model_transaksi b = new Model_transaksi();
                b.setId(rs.getString("id_trans"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setNama_kasir(rs.getString("nama_kasir"));
                b.setQty(rs.getString("qty"));
                b.setPrice_per_qty(rs.getString("price_per_qty"));
                b.setDiscount(rs.getString("discount"));
                b.setPrice_total(rs.getString("price_total"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }

    @Override
    public List<Model_transaksi> getCariNama(String nama) {
        List<Model_transaksi> lb = null;
        try {
            lb = new ArrayList<Model_transaksi>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_transaksi b = new Model_transaksi();
                b.setId(rs.getString("id_trans"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setNama_kasir(rs.getString("nama_kasir"));
                b.setQty(rs.getString("qty"));
                b.setPrice_per_qty(rs.getString("price_per_qty"));
                b.setDiscount(rs.getString("discount"));
                b.setPrice_total(rs.getString("price_total"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
}

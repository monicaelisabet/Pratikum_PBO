package transaksi_crud.DAOImplement;

import transaksi_crud.model.Model_transaksi;
import java.util.List;

/**
 */

public interface Implement_Transaksi {
    public void insert(Model_transaksi b);

    public void update(Model_transaksi b);

    public void delete(String id);
    
    //public void CekHarga(Model_transaksi b);

    public List<Model_transaksi> getALL();

    public List<Model_transaksi> getCariNama(String nama);
}

package pelanggan_hostinginaja_crud.DAOImplement;

import pelanggan_hostinginaja_crud.model.M_Pelanggan;
import java.util.List;

/**
 */

public interface Implement_Pelanggan {
    public void insert(M_Pelanggan b);

    public void update(M_Pelanggan b);

    public void delete(int id);

    public List<M_Pelanggan> getALL();

    public List<M_Pelanggan> getCariNama(String nama);
}

package dao;

import com.infosys.jdbc.Medicine;
import java.util.List;

public interface MedicineDAO {
    void create(Medicine medicine);
    Medicine read(int id);
    void update(Medicine medicine);
    void delete(int id);
    List<Medicine> getAllMedicines();
    String getMedicineNameById(int id);
}

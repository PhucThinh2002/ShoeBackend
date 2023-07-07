package vn.edu.stu.luanvantotnghiep.repository;
import org.springframework.data.repository.CrudRepository;
import vn.edu.stu.luanvantotnghiep.model.*;

public interface SanPhamCRUDRepository extends CrudRepository<SanPham, Integer>{
    // List<SanPham> search(String keyword);
}

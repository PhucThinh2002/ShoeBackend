package vn.edu.vlu.khoaluan.repository;
import org.springframework.data.repository.CrudRepository;

import vn.edu.vlu.khoaluan.model.*;

public interface SanPhamCRUDRepository extends CrudRepository<SanPham, Integer>{
    // List<SanPham> search(String keyword);
}

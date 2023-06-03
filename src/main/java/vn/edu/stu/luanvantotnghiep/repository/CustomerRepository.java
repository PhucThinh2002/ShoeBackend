package vn.edu.stu.luanvantotnghiep.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.edu.stu.luanvantotnghiep.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query(value = "SELECT * FROM users WHERE username = :username and active = 1", nativeQuery = true)
    Customer findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE active = 1", nativeQuery = true)
    List<Customer> findCustomerActivated();

    @Query(value = "SELECT * FROM users WHERE id = :id and active = 1", nativeQuery = true)
    Optional<Customer> findCustomerByIdAndActivated(@Param("id") int id);

}

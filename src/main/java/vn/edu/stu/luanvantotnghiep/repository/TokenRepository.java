package vn.edu.stu.luanvantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.Token;


public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);
}

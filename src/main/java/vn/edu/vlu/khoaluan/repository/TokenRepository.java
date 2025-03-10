package vn.edu.vlu.khoaluan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.Token;


public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);
}

package vn.edu.stu.luanvantotnghiep.service;

import vn.edu.stu.luanvantotnghiep.model.Token;

public interface TokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}

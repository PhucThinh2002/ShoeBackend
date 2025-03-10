package vn.edu.vlu.khoaluan.service;

import vn.edu.vlu.khoaluan.model.Token;

public interface TokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}

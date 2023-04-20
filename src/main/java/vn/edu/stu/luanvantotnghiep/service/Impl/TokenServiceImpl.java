package vn.edu.stu.luanvantotnghiep.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.Token;
import vn.edu.stu.luanvantotnghiep.repository.TokenRepository;
import vn.edu.stu.luanvantotnghiep.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}

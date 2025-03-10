package vn.edu.vlu.khoaluan.service;
import vn.edu.vlu.khoaluan.security.UserPrincipal;
public interface CustomerLogin {
    UserPrincipal findByUsername(String username);
    
}

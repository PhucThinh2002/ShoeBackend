package vn.edu.stu.luanvantotnghiep.service;
import vn.edu.stu.luanvantotnghiep.security.UserPrincipal;
public interface CustomerLogin {
    UserPrincipal findByUsername(String username);
    
}

package vn.edu.stu.luanvantotnghiep.service.Impl;
import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.stu.luanvantotnghiep.service.CustomerLogin;
import vn.edu.stu.luanvantotnghiep.repository.CustomerRepository;
import vn.edu.stu.luanvantotnghiep.security.UserPrincipal;
import vn.edu.stu.luanvantotnghiep.model.Customer;

@Service
public class CustomerLoginImpl implements CustomerLogin{
    @Autowired
    private CustomerRepository gCustomerRepository;

    @Override
    public UserPrincipal findByUsername(String username) {
        Customer customer = gCustomerRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != customer) {
            Set<String> authorities = new HashSet<>();
            if (null != customer.getRole()) {
                authorities.add(customer.getRole().getRoleKey());
                customer.getRole().getPermissions().forEach(p -> authorities.add(p.getPermissionKey()));
            }

            userPrincipal.setUserId(customer.getId());
            userPrincipal.setUsername(customer.getUsername());
            userPrincipal.setPassword(customer.getPassword());
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }
}

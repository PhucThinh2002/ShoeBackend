package vn.edu.vlu.khoaluan.service.Impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.Customer;
import vn.edu.vlu.khoaluan.repository.CustomerRepository;
import vn.edu.vlu.khoaluan.security.UserPrincipal;
import vn.edu.vlu.khoaluan.service.CustomerLogin;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerLoginImpl implements CustomerLogin{
    @Autowired
    private CustomerRepository gCustomerRepository;

    @Override
    public UserPrincipal findByUsername(String username) {
        Customer customer = gCustomerRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != customer) {
            List<String> authorities = new ArrayList<>();
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

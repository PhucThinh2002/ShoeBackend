package vn.edu.vlu.khoaluan.service;

import java.util.List;

import vn.edu.vlu.khoaluan.model.Customer;

public interface ICustomerService {
    public List<Customer> findAllCustmer();
    public Customer findCustomerByUsername(String username);
    public Customer findCustomerById(int id);
    public Customer createCusomer(Customer customer);
    public Customer createAdmin(Customer customer);
    public Customer updateCusomer(Customer customer, int id);
    public Customer deleteCustomer(int id);
    public Integer countCus();
    public Customer findByUsernameAndEmail(String username, String email);
    public Customer updatePassword(Customer customer);
}

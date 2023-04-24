package vn.edu.stu.luanvantotnghiep.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.edu.stu.luanvantotnghiep.model.Customer;
import vn.edu.stu.luanvantotnghiep.model.District;
import vn.edu.stu.luanvantotnghiep.model.Province;
import vn.edu.stu.luanvantotnghiep.model.Role;
import vn.edu.stu.luanvantotnghiep.model.Ward;
import vn.edu.stu.luanvantotnghiep.repository.CustomerRepository;
import vn.edu.stu.luanvantotnghiep.repository.DistrictRepository;
import vn.edu.stu.luanvantotnghiep.repository.ProvinceRepository;
import vn.edu.stu.luanvantotnghiep.repository.RoleRepository;
import vn.edu.stu.luanvantotnghiep.repository.WardRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository gCustomerRepository;
    @Autowired
    private RoleRepository gRoleRepository;
    @Autowired
    private ProvinceRepository gProvinceRepository;
    @Autowired
    private DistrictRepository gDistrictRepository;
    @Autowired
    private WardRepository gWardRepository;

    public List<Customer> findAllCustmer() {
        List<Customer> lstCustomer = new ArrayList<Customer>();
        gCustomerRepository.findCustomerActivated().forEach(lstCustomer::add);
        if (lstCustomer.size() != 0)
            return lstCustomer;
        return null;
    }

    public Customer findCustomerByUsername(String username) {
        Customer cus = gCustomerRepository.findByUsername(username);
        if (cus != null)
            return cus;
        return null;
    }

    public Customer findCustomerById(int id) {
        Optional<Customer> customer = gCustomerRepository.findCustomerByIdAndActivated(id);
        if (customer.isPresent())
            return customer.get();
        return null;
    }

    public Customer createCusomer(Customer customer) {
        Role roleCustomer = new Role();
        roleCustomer = gRoleRepository.findByRoleKey("ROLE_ADMIN");
        Customer newCus = new Customer();
        Optional<Province> province = gProvinceRepository.findById(customer.getProvince().getId());
        Optional<District> district = gDistrictRepository.findById(customer.getDistrict().getId());
        Optional<Ward> ward = gWardRepository.findById(customer.getWard().getId());
        newCus.setHoTenLot(customer.getHoTenLot());
        newCus.setTen(customer.getTen());
        newCus.setNgaySinh(customer.getNgaySinh());
        newCus.setSoDienThoai(customer.getSoDienThoai());
        newCus.setEmail(customer.getEmail());
        newCus.setDiaChi(customer.getDiaChi());
        newCus.setUsername(customer.getUsername());
        newCus.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
        newCus.setProvince(province.get());
        newCus.setDistrict(district.get());
        newCus.setWard(ward.get());
        newCus.setRole(roleCustomer);
        newCus.setCreatedAt(new Date());
        newCus.setActive(1);
        Customer resultCus = gCustomerRepository.findByUsername(customer.getUsername());
        if (resultCus != null) {
            return null;
        } else {
            return gCustomerRepository.save(newCus);
        }
    }

    public Customer updateCusomer(Customer customer, int id) {
        Optional<Customer> resultCus = gCustomerRepository.findById(id);
        if (resultCus.isPresent()) {
            Customer newCus = resultCus.get();
            newCus.setHoTenLot(customer.getHoTenLot());
            newCus.setTen(customer.getTen());
            newCus.setNgaySinh(customer.getNgaySinh());
            newCus.setSoDienThoai(customer.getSoDienThoai());
            newCus.setEmail(customer.getEmail());
            newCus.setDiaChi(customer.getDiaChi());
            newCus.setUsername(customer.getUsername());
            newCus.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
            newCus.setProvince(customer.getProvince());
            newCus.setDistrict(customer.getDistrict());
            newCus.setWard(customer.getWard());
            newCus.setCreatedAt(new Date());
            newCus.setActive(1);
            return gCustomerRepository.save(newCus);
        }else{
            return null;
        }

    }
    public Customer deleteCustomer(int id){
        Optional<Customer> resultCustomers = gCustomerRepository.findById(id);
        if(resultCustomers.isPresent()){
             resultCustomers.get().setActive(0);
             return gCustomerRepository.save(resultCustomers.get());
             
        }else{
            return null;
        }
    }
}

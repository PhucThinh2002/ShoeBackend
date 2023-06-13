package vn.edu.stu.luanvantotnghiep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.edu.stu.luanvantotnghiep.model.Customer;
import vn.edu.stu.luanvantotnghiep.model.District;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.ModelUser;
import vn.edu.stu.luanvantotnghiep.model.Province;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.edu.stu.luanvantotnghiep.service.CustomerService;
import vn.edu.stu.luanvantotnghiep.service.CustomerLogin;
import vn.edu.stu.luanvantotnghiep.service.TokenService;
import vn.edu.stu.luanvantotnghiep.security.UserPrincipal;
import vn.edu.stu.luanvantotnghiep.model.Token;
import vn.edu.stu.luanvantotnghiep.model.Ward;
import vn.edu.stu.luanvantotnghiep.repository.DistrictRepository;
import vn.edu.stu.luanvantotnghiep.repository.ProvinceRepository;
import vn.edu.stu.luanvantotnghiep.repository.WardRepository;
import vn.edu.stu.luanvantotnghiep.security.JwtUtil;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/")
public class CustomerController {
    @Autowired
    private CustomerService gCustomerService;
    @Autowired
    private CustomerLogin gCustomerLogin;
    @Autowired
    private TokenService gTokenService;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;

    @GetMapping("/customer")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> lstCus = gCustomerService.findAllCustmer();
        if(lstCus != null) return new ResponseEntity<>(lstCus, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        Customer cus = gCustomerService.findCustomerById(id);
        if(cus != null) return new ResponseEntity<>(cus, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PostMapping("/customer/register")
    public ResponseEntity<?> createCustomer( @RequestBody ModelUser customer){
        try {
            Province thanhPho = provinceRepository.findById(customer.getProvince()).get();
            District huyen = districtRepository.findById(customer.getDistrict()).get();
            Ward xa = wardRepository.findById(customer.getWard()).get();
            Customer data = new Customer();
            data.setHoTenLot(customer.getHoTenLot());
            data.setEmail(customer.getEmail());
            data.setTen(customer.getTen());
            data.setUsername(customer.getUsername());
            data.setPassword(customer.getPassword());
            data.setDiaChi(customer.getDiaChi() + "," + xa.getName() + "," + huyen.getName() + "," + thanhPho.getName());
            data.setNgaySinh(customer.getNgaySinh());
            data.setSoDienThoai(customer.getSoDienThoai());
            data.setProvince(thanhPho);
            Customer saveCus = gCustomerService.createCusomer(data);
            if(saveCus == null) return new ResponseEntity<>("Username của bạn đã tồn tại!", HttpStatus.PARTIAL_CONTENT);
            return new ResponseEntity<>(saveCus, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Customer: " + e.getCause().getCause().getMessage());
        }
    }
    @GetMapping("/getdatatotoken")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public FormatApi getUserByToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            FormatApi result = new FormatApi();
            result.setMessage("No Authentication user not found!");
            result.setStatus(HttpStatus.NOT_FOUND);
            return result;
        }
        Customer cusResult = gCustomerService.findCustomerByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(cusResult !=null){
            FormatApi result = new FormatApi();
            result.setData(cusResult);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(cusResult);
            result.setMessage("Không có dữ liệu user!");
            result.setStatus(HttpStatus.NOT_FOUND);
            return result;
        }
        
    }
    @PostMapping("/admin/register")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> createAdmin( @RequestBody Customer customer){
        try {
            Customer saveCus = gCustomerService.createAdmin(customer);
            if(saveCus == null) return new ResponseEntity<>("Username của bạn đã tồn tại!", HttpStatus.PARTIAL_CONTENT);
            return new ResponseEntity<>(saveCus, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Admin: " + e.getCause().getCause().getMessage());
        }
    }

    @PostMapping("/customer/login")
    public ResponseEntity<?> login(@RequestBody UserPrincipal user) {
        Customer customer = gCustomerService.findCustomerByUsername(user.getUsername());
        if(customer != null && customer.getActive() == 1){
            UserPrincipal userPrincipal = gCustomerLogin.findByUsername(user.getUsername());
            if (new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword()) == false) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
            }
            Token token = new Token();
            token.setToken(JwtUtil.generateToken(userPrincipal));
            token.setTokenExpDate(JwtUtil.generateExpirationDate());
            token.setCreatedBy(userPrincipal.getUserId());
            gTokenService.createToken(token);
            return ResponseEntity.ok(token.getToken());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản của bạn không tồn tại");
        }
       
    }
    @PutMapping("/customer/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id){
        try {
            Customer resultCus = gCustomerService.updateCusomer(customer, id);
            if(resultCus != null) return new ResponseEntity<>(resultCus, HttpStatus.OK);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Update specified Customer: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping("customer/{id}/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id){
        try {
            Customer saveCustomer = gCustomerService.deleteCustomer(id);
            if(saveCustomer != null) return new ResponseEntity<>(saveCustomer, HttpStatus.ACCEPTED);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Delete specified Employee: " + e.getCause().getCause().getMessage());
        }
    }
}

package vn.edu.vlu.khoaluan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vlu.khoaluan.model.District;
import vn.edu.vlu.khoaluan.model.Province;
import vn.edu.vlu.khoaluan.model.Ward;
import vn.edu.vlu.khoaluan.service.IDistrictService;
import vn.edu.vlu.khoaluan.service.IProvinceService;
import vn.edu.vlu.khoaluan.service.IWardService;

@RestController
@CrossOrigin(maxAge = 3600)
public class ProvinceController {
    @Autowired IProvinceService provinceService;
    @Autowired IDistrictService districtService;
    @Autowired IWardService wardService;
    @GetMapping("/province")
    public List<Province> getAllProvince(){
        List<Province> lstProvince = new ArrayList<Province>();
        provinceService.findAll().forEach(lstProvince::add);
        return lstProvince;
    }
    @GetMapping("/district/{provinceid}")
    public List<District> getDistrictByProvince(@PathVariable("provinceid") Long province){
        List<District> lstDistrict = new ArrayList<District>();
        districtService.findByProvinceID(province).forEach(lstDistrict::add);
        return lstDistrict;
    }

    @GetMapping("/ward/{district}")
    public List<Ward> getWardByDistrict(@PathVariable("district") Long district){
        List<Ward> lstWard = new ArrayList<Ward>();
        wardService.findByDistrictID(district).forEach(lstWard::add);
        return lstWard;
    }
}

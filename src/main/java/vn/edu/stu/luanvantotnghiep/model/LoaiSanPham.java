package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_loai_san_pham")
    private String tenLoaiSanPham;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SanPham> sanPhams;
}

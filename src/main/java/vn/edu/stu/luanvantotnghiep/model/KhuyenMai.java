package vn.edu.stu.luanvantotnghiep.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "khuyen_mai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_khuyen_mai", length = 100)
    private String name;
    @Column(name = "phan_tram_khuyen_mai", length = 3)
    private Integer percentDiscount;
    @Column(name = "mo_ta")
    private String description;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "khuyenmai_sanpham", joinColumns = {@JoinColumn(name = "khuyen_mai_id")}, inverseJoinColumns = {@JoinColumn(name = "san_pham_id")})
    private Set<SanPham> sanPham;
    public KhuyenMai() {
    }
    public KhuyenMai(Integer id, String name, Integer percentDiscount, String description) {
        this.id = id;
        this.name = name;
        this.percentDiscount = percentDiscount;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPercentDiscount() {
        return percentDiscount;
    }
    public void setPercentDiscount(Integer percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}

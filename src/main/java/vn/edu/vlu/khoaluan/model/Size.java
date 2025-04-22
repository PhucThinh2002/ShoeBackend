package vn.edu.vlu.khoaluan.model;

import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "size_sanpham", joinColumns = {@JoinColumn(name = "size_id")}, inverseJoinColumns = {@JoinColumn(name = "san_pham_id")})
    @JsonIgnore
    private List<SanPham> sanPham;
    public Size() {
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
    public List<SanPham> getSanPham() {
        return sanPham;
    }
    public void setSanPham(List<SanPham> sanPham) {
        this.sanPham = sanPham;
    }
    
    
}

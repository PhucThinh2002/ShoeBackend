package vn.edu.stu.luanvantotnghiep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tra_gop")
public class TraGop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "hoa_don", referencedColumnName = "id")
    @ManyToOne
    private HoaDon hoaDon;
    @Column(name = "so_tien_hang_thang")
    private Double soTienHangThang;
    @Column(name = "da_bank")
    private Boolean daBank;
}

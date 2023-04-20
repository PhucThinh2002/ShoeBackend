package vn.edu.stu.luanvantotnghiep.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ward")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PREFIX")
    private String prefix;

    //@Column(name = "PROVINCE_ID")
    @ManyToOne
    @JoinColumn(name="province", nullable=false, insertable = false, updatable = false)
    private Province province;

    //@Column(name = "DISTRICT_ID")
    @ManyToOne
    @JoinColumn(name="district", nullable=false, insertable = false, updatable = false)
    private District district;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Customer> customers;

    public Ward() {
    }

    public Ward(Long id, String name, String prefix, Province province, District district) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.province = province;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    
}

package vn.edu.stu.luanvantotnghiep.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "PREFIX", length = 50)
    private String prefix;

    //@Column(name = "PROVINCE_ID")
    @ManyToOne
    @JoinColumn(name="province", nullable=false, insertable = false, updatable = false)
    private Province province;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Ward> wards;

    
    public District() {
    }

    public District(Long id, String name, String prefix, Province province) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
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

    
}

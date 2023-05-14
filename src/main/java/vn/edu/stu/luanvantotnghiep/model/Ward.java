package vn.edu.stu.luanvantotnghiep.model;

import javax.persistence.*;

@Entity
@Table(name = "ward")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "PREFIX", length = 50)
    private String prefix;

    //@Column(name = "DISTRICT_ID")
    @ManyToOne
    @JoinColumn(name="district", nullable=false, insertable = false, updatable = false)
    private District district;

    public Ward() {
    }

    public Ward(Long id, String name, String prefix, Province province, District district) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    
}

package vn.edu.stu.luanvantotnghiep.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name ="province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Ward> wards;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<District> districts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Customer> customers;
    public Long getId() {
        return id;
    }

    public Province() {
    }

    public Province(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}

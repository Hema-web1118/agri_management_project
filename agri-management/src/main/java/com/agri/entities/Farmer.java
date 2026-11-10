package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="farmers")
public class Farmer {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120) private String name;
    @Column(nullable=false, unique=true, length=10) private String phone;
    @Column(length=150) private String email;
    @Column(length=255) private String address;
    @JsonIgnore
    @OneToMany(mappedBy="farmer") private List<Farm> farms = new ArrayList<>();

    public Farmer() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public List<Farm> getFarms() { return farms; }
    public void setFarms(List<Farm> farms) { this.farms = farms; }
}

package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.agri.enums.AreaUnit;
import com.agri.enums.OwnershipType;

@Entity
@Table(name="farms")
public class Farm {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="farm_name", nullable=false, length=120) private String farmName;
    @Column(nullable=false, length=255) private String location;
    @Column(nullable=false, precision=12, scale=2) private BigDecimal area;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private AreaUnit areaUnit;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private OwnershipType ownershipType;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;
    @JsonIgnore
    @OneToMany(mappedBy="farm") private List<Field> fields = new ArrayList<>();

    public Farm() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFarmName() { return farmName; }
    public void setFarmName(String farmName) { this.farmName = farmName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public BigDecimal getArea() { return area; }
    public void setArea(BigDecimal area) { this.area = area; }
    public AreaUnit getAreaUnit() { return areaUnit; }
    public void setAreaUnit(AreaUnit areaUnit) { this.areaUnit = areaUnit; }
    public OwnershipType getOwnershipType() { return ownershipType; }
    public void setOwnershipType(OwnershipType ownershipType) { this.ownershipType = ownershipType; }
    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
    public List<Field> getFields() { return fields; }
    public void setFields(List<Field> fields) { this.fields = fields; }
}

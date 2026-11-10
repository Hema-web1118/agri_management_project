package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.agri.enums.SoilType;

@Entity
@Table(name="fields")
public class Field {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100) private String fieldName;
    @Column(nullable=false, precision=12, scale=2) private BigDecimal area;
    @Enumerated(EnumType.STRING) private SoilType soilType;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;
    @JsonIgnore
    @OneToMany(mappedBy="field") private List<CropPlan> cropPlans = new ArrayList<>();

    public Field() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    public BigDecimal getArea() { return area; }
    public void setArea(BigDecimal area) { this.area = area; }
    public SoilType getSoilType() { return soilType; }
    public void setSoilType(SoilType soilType) { this.soilType = soilType; }
    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }
    public List<CropPlan> getCropPlans() { return cropPlans; }
    public void setCropPlans(List<CropPlan> cropPlans) { this.cropPlans = cropPlans; }
}

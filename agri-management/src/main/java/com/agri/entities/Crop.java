package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="crops")
public class Crop {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=100) private String cropName;
    @Column(length=100) private String variety;
    @Column(length=255) private String description;
    private Integer expectedDurationDays;
    @JsonIgnore
    @OneToMany(mappedBy="crop") private List<CropPlan> cropPlans = new ArrayList<>();

    public Crop() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }
    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getExpectedDurationDays() { return expectedDurationDays; }
    public void setExpectedDurationDays(Integer expectedDurationDays) { this.expectedDurationDays = expectedDurationDays; }
    public List<CropPlan> getCropPlans() { return cropPlans; }
    public void setCropPlans(List<CropPlan> cropPlans) { this.cropPlans = cropPlans; }
}

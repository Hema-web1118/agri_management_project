package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.agri.enums.ActivityType;

@Entity
@Table(name="activitys")
public class Activity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "crop_plan_id", nullable = false)
    private CropPlan cropPlan;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private ActivityType activityType;
    @Column(nullable=false) private LocalDate activityDate;
    @Column(length=1000) private String description;
    @Column(precision=12, scale=2) private BigDecimal quantity;
    @Column(length=30) private String quantityUnit;
    @Column(precision=12, scale=2) private BigDecimal cost;

    public Activity() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CropPlan getCropPlan() { return cropPlan; }
    public void setCropPlan(CropPlan cropPlan) { this.cropPlan = cropPlan; }
    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    public String getQuantityUnit() { return quantityUnit; }
    public void setQuantityUnit(String quantityUnit) { this.quantityUnit = quantityUnit; }
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
}

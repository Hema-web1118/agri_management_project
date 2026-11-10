package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.agri.enums.HarvestQuality;

@Entity
@Table(name="harvests")
public class Harvest {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "crop_plan_id", nullable = false)
    private CropPlan cropPlan;
    @Column(nullable=false) private LocalDate harvestDate;
    @Column(nullable=false, precision=12, scale=2) private BigDecimal quantity;
    @Column(nullable=false, length=30) private String quantityUnit;
    @Enumerated(EnumType.STRING) private HarvestQuality quality;
    @Column(precision=12, scale=2) private BigDecimal sellingPricePerUnit;
    @Column(precision=14, scale=2) private BigDecimal totalRevenue;

    public Harvest() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CropPlan getCropPlan() { return cropPlan; }
    public void setCropPlan(CropPlan cropPlan) { this.cropPlan = cropPlan; }
    public LocalDate getHarvestDate() { return harvestDate; }
    public void setHarvestDate(LocalDate harvestDate) { this.harvestDate = harvestDate; }
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    public String getQuantityUnit() { return quantityUnit; }
    public void setQuantityUnit(String quantityUnit) { this.quantityUnit = quantityUnit; }
    public HarvestQuality getQuality() { return quality; }
    public void setQuality(HarvestQuality quality) { this.quality = quality; }
    public BigDecimal getSellingPricePerUnit() { return sellingPricePerUnit; }
    public void setSellingPricePerUnit(BigDecimal sellingPricePerUnit) { this.sellingPricePerUnit = sellingPricePerUnit; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
}

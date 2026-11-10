package com.agri.dtos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.agri.enums.HarvestQuality;

public class HarvestRequest {
    @NotNull private Long cropPlanId;
    @NotNull private LocalDate harvestDate;
    @NotNull @DecimalMin("0.01") private BigDecimal quantity;
    @NotBlank private String quantityUnit;
    private HarvestQuality quality;
    private BigDecimal sellingPricePerUnit;

    public HarvestRequest() {}
    public Long getCropPlanId() { return cropPlanId; }
    public void setCropPlanId(Long cropPlanId) { this.cropPlanId = cropPlanId; }
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
}

package com.agri.dtos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.agri.enums.ActivityType;

public class ActivityRequest {
    @NotNull private Long cropPlanId;
    @NotNull private ActivityType activityType;
    @NotNull private LocalDate activityDate;
    private String description;
    private BigDecimal quantity;
    private String quantityUnit;
    private BigDecimal cost;

    public ActivityRequest() {}
    public Long getCropPlanId() { return cropPlanId; }
    public void setCropPlanId(Long cropPlanId) { this.cropPlanId = cropPlanId; }
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

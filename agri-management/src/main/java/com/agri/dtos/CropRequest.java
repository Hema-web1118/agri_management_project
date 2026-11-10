package com.agri.dtos;

import jakarta.validation.constraints.*;

public class CropRequest {
    @NotBlank private String cropName;
    private String variety;
    private String description;
    private Integer expectedDurationDays;

    public CropRequest() {}
    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }
    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getExpectedDurationDays() { return expectedDurationDays; }
    public void setExpectedDurationDays(Integer expectedDurationDays) { this.expectedDurationDays = expectedDurationDays; }
}

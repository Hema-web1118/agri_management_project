package com.agri.dtos;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import com.agri.enums.CropStatus;

public class CropPlanRequest {
    @NotNull private Long fieldId;
    @NotNull private Long cropId;
    @NotBlank private String season;
    private LocalDate sowingDate;
    private LocalDate expectedHarvestDate;
    private CropStatus status;

    public CropPlanRequest() {}
    public Long getFieldId() { return fieldId; }
    public void setFieldId(Long fieldId) { this.fieldId = fieldId; }
    public Long getCropId() { return cropId; }
    public void setCropId(Long cropId) { this.cropId = cropId; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public LocalDate getSowingDate() { return sowingDate; }
    public void setSowingDate(LocalDate sowingDate) { this.sowingDate = sowingDate; }
    public LocalDate getExpectedHarvestDate() { return expectedHarvestDate; }
    public void setExpectedHarvestDate(LocalDate expectedHarvestDate) { this.expectedHarvestDate = expectedHarvestDate; }
    public CropStatus getStatus() { return status; }
    public void setStatus(CropStatus status) { this.status = status; }
}

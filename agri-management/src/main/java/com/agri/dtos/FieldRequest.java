package com.agri.dtos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import com.agri.enums.SoilType;

public class FieldRequest {
    @NotBlank private String fieldName;
    @NotNull @DecimalMin("0.01") private BigDecimal area;
    private SoilType soilType;
    @NotNull private Long farmId;

    public FieldRequest() {}
    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    public BigDecimal getArea() { return area; }
    public void setArea(BigDecimal area) { this.area = area; }
    public SoilType getSoilType() { return soilType; }
    public void setSoilType(SoilType soilType) { this.soilType = soilType; }
    public Long getFarmId() { return farmId; }
    public void setFarmId(Long farmId) { this.farmId = farmId; }
}

package com.agri.dtos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import com.agri.enums.*;

public class FarmRequest {
    @NotBlank private String farmName;
    @NotBlank private String location;
    @NotNull @DecimalMin("0.01") private BigDecimal area;
    @NotNull private AreaUnit areaUnit;
    @NotNull private OwnershipType ownershipType;
    @NotNull private Long farmerId;

    public FarmRequest() {}
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
    public Long getFarmerId() { return farmerId; }
    public void setFarmerId(Long farmerId) { this.farmerId = farmerId; }
}

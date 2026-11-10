package com.agri.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.agri.enums.CropStatus;

@Entity
@Table(name="crop_plans")
public class CropPlan {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;
    @Column(nullable=false, length=60) private String season;
    private LocalDate sowingDate;
    private LocalDate expectedHarvestDate;
    @Enumerated(EnumType.STRING) private CropStatus status = CropStatus.PLANNED;
    @JsonIgnore
    @OneToMany(mappedBy="cropPlan") private List<Activity> activities = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy="cropPlan") private List<Harvest> harvests = new ArrayList<>();

    public CropPlan() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Field getField() { return field; }
    public void setField(Field field) { this.field = field; }
    public Crop getCrop() { return crop; }
    public void setCrop(Crop crop) { this.crop = crop; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public LocalDate getSowingDate() { return sowingDate; }
    public void setSowingDate(LocalDate sowingDate) { this.sowingDate = sowingDate; }
    public LocalDate getExpectedHarvestDate() { return expectedHarvestDate; }
    public void setExpectedHarvestDate(LocalDate expectedHarvestDate) { this.expectedHarvestDate = expectedHarvestDate; }
    public CropStatus getStatus() { return status; }
    public void setStatus(CropStatus status) { this.status = status; }
    public List<Activity> getActivities() { return activities; }
    public void setActivities(List<Activity> activities) { this.activities = activities; }
    public List<Harvest> getHarvests() { return harvests; }
    public void setHarvests(List<Harvest> harvests) { this.harvests = harvests; }
}

package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.CropPlan;
import java.util.List;

public interface CropPlanRepository extends JpaRepository<CropPlan, Long> {
    List<CropPlan> findByFieldId(Long fieldId);
}

package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Harvest;
import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    List<Harvest> findByCropPlanId(Long cropPlanId);
}

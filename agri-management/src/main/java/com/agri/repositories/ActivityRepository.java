package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Activity;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByCropPlanId(Long cropPlanId);
}

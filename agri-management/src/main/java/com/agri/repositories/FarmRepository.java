package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Farm;
import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findByFarmerId(Long farmerId);
}

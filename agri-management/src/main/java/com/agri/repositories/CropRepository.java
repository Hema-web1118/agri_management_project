package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Crop;

public interface CropRepository extends JpaRepository<Crop, Long> {
}

package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
}

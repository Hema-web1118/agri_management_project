package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Field;
import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByFarmId(Long farmId);
}

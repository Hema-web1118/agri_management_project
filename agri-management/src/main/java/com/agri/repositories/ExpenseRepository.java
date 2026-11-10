package com.agri.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agri.entities.Expense;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByFarmIdAndExpenseDateBetween(Long farmId, java.time.LocalDate from, java.time.LocalDate to);
}

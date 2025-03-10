package com.practice.ExpenseTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice.ExpenseTracker.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByCategory(String category);
}

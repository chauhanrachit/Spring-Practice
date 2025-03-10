package com.practice.ExpenseTracker.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practice.ExpenseTracker.models.Expense;
import com.practice.ExpenseTracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	@Cacheable(value = "expenses")
	public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
	
	@CacheEvict(value = "expenses", allEntries = true)  // Clears cache when data changes
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    
	// using key="#category" so that data with category 1 does not get send for category2
    @Cacheable(value = "expenses", key = "#category")
	public List<Expense> getByCategory(String category) {
		return expenseRepository.findByCategory(category);
	}
    
}

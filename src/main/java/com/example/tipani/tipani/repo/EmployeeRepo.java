package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
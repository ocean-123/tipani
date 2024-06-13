package com.example.tipani.tipani.repo;

import com.example.tipani.tipani.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}

package com.employeemanagement.springrestdemoproject.repository;

import com.employeemanagement.springrestdemoproject.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmployeeName(String name);
    @Transactional
    void deleteByEmployeeName(String name);

    boolean existsByEmployeeName(String name);
}
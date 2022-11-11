package com.example.examspringjpa.repository;


import com.example.examspringjpa.model.Employee;
import com.example.examspringjpa.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

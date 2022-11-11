package com.example.examspringjpa.controller;


import com.example.examspringjpa.model.Company;
import com.example.examspringjpa.model.Employee;
import com.example.examspringjpa.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CompanyController {

    private CompanyRepository companyRepository;

    void companyRepository(CompanyRepository repository) {
        this.companyRepository = repository;
    }
    @GetMapping("/employees")
    List<Employee> all() {
        return CompanyRepository.findAll();
    }

    @PostMapping("/company")
    Company newCompany(@RequestBody Company newCompany) {
        return CompanyRepository.save(newCompany);
    }
    @GetMapping("/Company/{id}")
    Optional<Employee> one(@PathVariable Long id) {

        return CompanyRepository.findById(id);
    }
    @PutMapping("/Company/{id}")
    Employee replaceCompany(@RequestBody Company newCompany, @PathVariable Long id) {

        return CompanyRepository.findById(id)
                .map(company -> {
                    company.setTitle(newCompany.getTitle());
                    company.setEmail(newCompany.getEmail());
                    return CompanyRepository.save(company);
                })
                .orElseGet(() -> {
                    newCompany.setId(id);
                    return CompanyRepository.save(newCompany);
                });
    }

    @DeleteMapping("/company/{id}")
    void deleteEmployee(@PathVariable Long id) {
        CompanyRepository.deleteById(id);
    }
}

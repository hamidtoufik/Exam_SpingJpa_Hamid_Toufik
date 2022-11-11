package com.example.examspringjpa.Services;

import com.example.examspringjpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
}

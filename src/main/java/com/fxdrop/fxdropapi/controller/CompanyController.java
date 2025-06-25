package com.fxdrop.fxdropapi.controller;

import com.fxdrop.fxdropapi.dto.userDto.CreateUserDto;
import com.fxdrop.fxdropapi.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<?> createCompany(@Valid @RequestBody CreateCompanyDto company) {
        companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa criada com sucesso!");
    }
}

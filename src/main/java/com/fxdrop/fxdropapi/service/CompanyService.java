package com.fxdrop.fxdropapi.service;

import com.fxdrop.fxdropapi.dto.companyDto.CreateCompanyDto;
import com.fxdrop.fxdropapi.enums.company.TypeCompany;
import com.fxdrop.fxdropapi.exception.CompanyException;
import com.fxdrop.fxdropapi.model.Company;
import com.fxdrop.fxdropapi.repository.CompanyRepository;
import com.fxdrop.fxdropapi.utils.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void createCompany(CreateCompanyDto companyDto){
        String cnpj = Functions.cleanString(companyDto.cnpj());
        boolean validateCnpj = Functions.isValidCnpj(cnpj);

        if (validateCnpj){
            Company searchCompany = companyRepository.findFirstByCnpjOrDomain(cnpj, companyDto.domain());

            if(searchCompany != null){
                if(searchCompany.getCnpj().equals(cnpj)){
                    throw new CompanyException("Cnpj já cadastrado.");
                }

                if(searchCompany.getDomain().equals(companyDto.domain())){
                    throw new CompanyException("Dominio já cadastrado.");
                }
            }

            Company newCompany = new Company();
            newCompany.setCorporateReason(companyDto.corporateReason());
            newCompany.setFantasyName(companyDto.fantasyName());
            newCompany.setCnpj(cnpj);
            newCompany.setIe(companyDto.ie());
            newCompany.setCellphone(companyDto.cellphone());
            newCompany.setTelephone(companyDto.telephone());
            newCompany.setAdress(companyDto.adress());
            newCompany.setNumber(companyDto.number());
            newCompany.setComplement(companyDto.complement());
            newCompany.setNeighborhood(companyDto.neighborhood());
            newCompany.setZipCode(companyDto.zipCode());
            newCompany.setCity(companyDto.city());
            newCompany.setState(companyDto.state());
            newCompany.setDomain(companyDto.domain());
            newCompany.setLogActive("S");
            newCompany.setTypeCompany(companyDto.typeCompany());

            newCompany.setIdCreate(companyDto.id());
            newCompany.setDateCreate(LocalDateTime.now());

        }

    }
}

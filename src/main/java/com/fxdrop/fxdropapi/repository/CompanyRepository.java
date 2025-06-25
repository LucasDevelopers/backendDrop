package com.fxdrop.fxdropapi.repository;

import com.fxdrop.fxdropapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
        Company findFirstByCnpjOrDomain(String cnpj, String domain);
}

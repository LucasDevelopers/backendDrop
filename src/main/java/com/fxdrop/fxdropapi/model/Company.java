package com.fxdrop.fxdropapi.model;

import com.fxdrop.fxdropapi.enums.company.TypeCompany;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String corporateReason;

    @Column(nullable = false)
    private String fantasyName;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = true)
    private String ie;

    @Column(nullable = false)
    private String cellphone;

    @Column(nullable = true)
    private String telephone;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String number;

    @Column(nullable = true)
    private String complement;

    @Column(nullable = true)
    private String neighborhood;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = true)
    private String domain;

    @Column(nullable = false)
    private String logActive;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeCompany typeCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorporateReason() {
        return corporateReason;
    }

    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLogActive() {
        return logActive;
    }

    public void setLogActive(String logActive) {
        this.logActive = logActive;
    }

    public TypeCompany getTypeCompany() {
        return typeCompany;
    }

    public void setTypeCompany(TypeCompany typeCompany) {
        this.typeCompany = typeCompany;
    }

    public Long getIdCreate() {
        return idCreate;
    }

    public void setIdCreate(Long idCreate) {
        this.idCreate = idCreate;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Long getIdUpdate() {
        return idUpdate;
    }

    public void setIdUpdate(Long idUpdate) {
        this.idUpdate = idUpdate;
    }

    public LocalDateTime getDateDeletion() {
        return dateDeletion;
    }

    public void setDateDeletion(LocalDateTime dateDeletion) {
        this.dateDeletion = dateDeletion;
    }

    public Long getIdDeletion() {
        return idDeletion;
    }

    public void setIdDeletion(Long idDeletion) {
        this.idDeletion = idDeletion;
    }

    @Column(nullable = false)
    private Long idCreate;

    @Column(nullable = false)
    private LocalDateTime dateCreate;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    @Column(nullable = true)
    private Long idUpdate;

    @Column(nullable = true)
    private LocalDateTime dateDeletion;

    @Column(nullable = true)
    private Long idDeletion;

}

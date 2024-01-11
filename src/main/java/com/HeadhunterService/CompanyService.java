package com.HeadhunterService;

import com.HeadhunterModel.Company;

import java.util.List;

public interface CompanyService {
    void createCompany(Company company);
    Company getCompanyById(int companyId);
    List<Company> getCompanyList();
    void updateCompany(Company company);
    void deleteCompanyById(int companyId);
}

package com.HeadhunterService;

import com.HeadhunterDao.CompanyDao;
import com.HeadhunterModel.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService{

    @Autowired
    CompanyDao companyDao;

    @Override
    public void createCompany(Company company) {
        companyDao.createCompany(company);
    }

    @Override
    public Company getCompanyById(int companyId) {
        return companyDao.getCompanyById(companyId);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyDao.getCompanyList();
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }

    @Override
    public void deleteCompanyById(int companyId) {
        companyDao.deleteCompanyById(companyId);
    }
}

package com.HeadhunterDao;

import com.HeadhunterMapper.CompanyMapper;
import com.HeadhunterModel.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyDaoImp implements CompanyDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createCompany(Company company) {
        jdbcTemplate.update("INSERT INTO company(company_name, company_tel, company_email, city_id, description) VALUES(?,?,?,?,?);",new Object[]{company.getCompanyName(),company.getCompanyTel(),company.getCompanyEmail(),company.getCityId(),company.getDescription()});
    }

    @Override
    public Company getCompanyById(int companyId) {
        return jdbcTemplate.queryForObject("SELECT company_id,company_name,company_tel,company_email,c.city_id,c2.city_name,c3.country_name,description FROM company c LEFT JOIN city c2 on c.city_id = c2.city_id LEFT JOIN country c3 on c2.country_id = c3.country_id WHERE c.company_id=?;",new Object[]{companyId},new CompanyMapper());
    }

    @Override
    public List<Company> getCompanyList() {
        return jdbcTemplate.query("SELECT company_id,company_name,company_tel,company_email,c.city_id,c2.city_name,c3.country_name,description FROM company c LEFT JOIN city c2 on c.city_id = c2.city_id LEFT JOIN country c3 on c2.country_id = c3.country_id;",new CompanyMapper());
    }

    @Override
    public void updateCompany(Company company) {
        jdbcTemplate.update("UPDATE company SET company_name=?,company_tel=?,company_email=?,city_id=?,description=? WHERE company_id=?;",new Object[]{company.getCompanyName(),company.getCompanyTel(),company.getCompanyEmail(),company.getCityId(),company.getDescription(),company.getCompanyId()});
    }

    @Override
    public void deleteCompanyById(int companyId) {
        jdbcTemplate.update("DELETE FROM company WHERE company_id=?;",new Object[]{companyId});
    }
}

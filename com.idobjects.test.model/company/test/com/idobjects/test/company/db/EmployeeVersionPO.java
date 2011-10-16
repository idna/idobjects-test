package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.idobjects.persistence.api.ObjectVersionPO;

@Entity
@Table(name = "employee_version")
public class EmployeeVersionPO extends ObjectVersionPO{

    @ManyToOne
    @JoinColumn(name = "company_version_id")
    public CompanyVersionPO getCompanyVersion(){
        return ( CompanyVersionPO )getVersion();
    }

    public void setCompanyVersion( CompanyVersionPO companyVersion ){
        setVersion( companyVersion );
    }

    @ManyToOne
    @JoinColumn(name = "employee_id")
    public EmployeePO getEmployee(){
        return ( EmployeePO )getPersistenceObject();
    }

    public void setEmployee( EmployeePO employee ){
        setPersistenceObject( employee );
    }

}

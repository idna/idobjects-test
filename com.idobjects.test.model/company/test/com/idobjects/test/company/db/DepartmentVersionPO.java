package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.idobjects.persistence.api.ObjectVersionPO;

@Entity
@Table(name = "department_version")
public class DepartmentVersionPO extends ObjectVersionPO{

    @ManyToOne
    @JoinColumn(name = "company_version_id")
    public CompanyVersionPO getCompanyVersion(){
        return ( CompanyVersionPO )getVersion();
    }

    public void setCompanyVersion( CompanyVersionPO companyVersion ){
        setVersion( companyVersion );
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    public DepartmentPO getDepartment(){
        return ( DepartmentPO )getPersistenceObject();
    }

    public void setDepartment( DepartmentPO department ){
        setPersistenceObject( department );
    }

}

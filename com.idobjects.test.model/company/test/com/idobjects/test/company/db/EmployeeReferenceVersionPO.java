package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.idobjects.persistence.api.ReferenceVersionPO;

@Entity
@Table(name = "employee_ref_version")
public class EmployeeReferenceVersionPO extends ReferenceVersionPO{

    @ManyToOne
    @JoinColumn(name = "company_version_id")
    public CompanyVersionPO getCompanyVersion(){
        return ( CompanyVersionPO )getVersion();
    }

    public void setCompanyVersion( CompanyVersionPO companyVersion ){
        setVersion( companyVersion );
    }

    @ManyToOne
    @JoinColumn(name = "employee_ref_id")
    public EmployeeReferencePO getEmployeeReference(){
        return ( EmployeeReferencePO )getReference();
    }

    public void setEmployeeReference( EmployeeReferencePO employeeRef ){
        setReference( employeeRef );
    }

}

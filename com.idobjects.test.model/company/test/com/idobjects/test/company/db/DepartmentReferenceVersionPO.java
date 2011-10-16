package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.idobjects.persistence.api.ReferenceVersionPO;

@Entity
@Table(name = "department_ref_version")
public class DepartmentReferenceVersionPO extends ReferenceVersionPO{

    @ManyToOne
    @JoinColumn(name = "company_version_id")
    public CompanyVersionPO getCompanyVersion(){
        return ( CompanyVersionPO )getVersion();
    }

    public void setCompanyVersion( CompanyVersionPO companyVersion ){
        setVersion( companyVersion );
    }

    @ManyToOne
    @JoinColumn(name = "department_ref_id")
    public DepartmentReferencePO getDepartmentReference(){
        return ( DepartmentReferencePO )getReference();
    }

    public void setDepartmentReference( DepartmentReferencePO departmentRef ){
        setReference( departmentRef );
    }

}

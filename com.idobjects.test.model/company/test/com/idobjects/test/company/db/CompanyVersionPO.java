package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.idobjects.persistence.api.ModelScopeVersionPO;

@Entity
@Table(name = "company_key_version")
public class CompanyVersionPO extends ModelScopeVersionPO{

    @ManyToOne
    @JoinColumn(name = "company_key_id")
    public CompanyKeyPO getCompanyKey(){
        return ( CompanyKeyPO )getModelScopeKey();
    }

    public void setCompanyKey( CompanyKeyPO companyKey ){
        setModelScopeKey( companyKey );
    }

}

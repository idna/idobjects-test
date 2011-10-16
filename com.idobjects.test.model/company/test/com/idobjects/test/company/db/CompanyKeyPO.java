package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.idobjects.persistence.api.ModelScopeKeyPO;

@Entity
@Table(name = "company_key")
public class CompanyKeyPO extends ModelScopeKeyPO{

}

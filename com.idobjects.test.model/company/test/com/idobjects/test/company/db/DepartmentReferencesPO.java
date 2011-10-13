package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.idobjects.persistence.api.ReferencePO;

@Entity
@Table(name = "department_refs")
public class DepartmentReferencesPO extends ReferencePO{

}

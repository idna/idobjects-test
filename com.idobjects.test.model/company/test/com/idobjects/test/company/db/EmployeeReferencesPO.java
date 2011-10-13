package com.idobjects.test.company.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.idobjects.persistence.api.ReferencePO;

@Entity
@Table(name = "employee_refs")
public class EmployeeReferencesPO extends ReferencePO{

}

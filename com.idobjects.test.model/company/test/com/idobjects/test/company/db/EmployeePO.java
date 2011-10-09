package com.idobjects.test.company.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.idobjects.persistence.api.AbstractPO;

@Entity(name = "Employee")
@Table(name = "employee")
public class EmployeePO extends AbstractPO{

    @Column(name = "first_name")
    public String getFirstName(){
        return ( String )getPropertyValue( EmployeePOMD.FIRST_NAME );
    }
    
    public void setFirstName(String firstName){
        setPropertyValue( EmployeePOMD.FIRST_NAME, firstName );
    }

}

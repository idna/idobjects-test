package com.idobjects.test.company.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.idobjects.test.company.db.md.EmployeePOMD;

@Entity(name = "Employee")
@Table(name = "employee")
public class EmployeePO extends AbstractCompanyModelPO{

    @Column(name = "first_name")
    public String getFirstName(){
        return ( String )getPropertyValue( EmployeePOMD.FIRST_NAME );
    }

    public void setFirstName( String firstName ){
        setPropertyValue( EmployeePOMD.FIRST_NAME, firstName );
    }

    @Column(name = "last_name")
    public String getLastName(){
        return ( String )getPropertyValue( EmployeePOMD.LAST_NAME );
    }

    public void setLastName( String lastName ){
        setPropertyValue( EmployeePOMD.LAST_NAME, lastName );
    }

    @Column(name = "age")
    public int getAge(){
        return ( Integer )getPropertyValue( EmployeePOMD.AGE );
    }

    public void setAge( int age ){
        setPropertyValue( EmployeePOMD.AGE, age );
    }

}

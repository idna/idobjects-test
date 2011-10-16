package com.idobjects.test.company.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.idobjects.test.company.db.md.DepartmentPOMD;

@Entity
@Table(name = "department")
public class DepartmentPO extends AbstractCompanyModelPO{

    public void setName( String name ){
        setPropertyValue( DepartmentPOMD.NAME, name );
    }

    @Column(name = "name")
    public String getName(){
        return ( String )getPropertyValue( DepartmentPOMD.NAME );
    }

    public void setSize( int size ){
        setPropertyValue( DepartmentPOMD.SIZE, size );
    }

    @Column(name = "size")
    public int getSize(){
        return ( Integer )getPropertyValue( DepartmentPOMD.SIZE );
    }

}

package com.idobjects.test.company.db;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.idobjects.persistence.api.AbstractPO;

@Entity
public class DepartmentPO extends AbstractPO{

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

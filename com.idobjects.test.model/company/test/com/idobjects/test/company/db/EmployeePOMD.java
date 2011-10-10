package com.idobjects.test.company.db;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceObjectMD;
import com.idobjects.persistence.api.PersistencePropertyMD;
import com.idobjects.test.company.Employee;
import com.idobjects.test.company.EmployeeMD;

public class EmployeePOMD extends PersistenceObjectMD{

    public static final PersistencePropertyMD FIRST_NAME = new PersistencePropertyMD( EmployeeMD.FIRST_NAME,String.class );
    public static final PersistencePropertyMD LAST_NAME = new PersistencePropertyMD( EmployeeMD.LAST_NAME,String.class );
    public static final PersistencePropertyMD AGE = new PersistencePropertyMD( EmployeeMD.AGE,int.class );

    private static final EmployeePOMD instance;

    static{
        List<PersistencePropertyMD> properties = new ArrayList<PersistencePropertyMD>();
        properties.add( FIRST_NAME );
        properties.add( LAST_NAME );
        properties.add( AGE );
        instance = new EmployeePOMD( Employee.class, EmployeePO.class, properties );
    }

    private EmployeePOMD( Class idObjectClass, Class persistenceObjectClass, List<PersistencePropertyMD> propertiesMD ){
        super( idObjectClass, persistenceObjectClass, propertiesMD );
    }

    public static EmployeePOMD instance(){
        return instance;
    }
}

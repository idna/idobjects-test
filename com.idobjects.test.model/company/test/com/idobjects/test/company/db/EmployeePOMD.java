package com.idobjects.test.company.db;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceObjectMD;
import com.idobjects.persistence.api.PersistencePropertyMD;
import com.idobjects.persistence.api.PersistenceReferenceMD;
import com.idobjects.test.company.Employee;
import com.idobjects.test.company.EmployeeMD;

public class EmployeePOMD extends PersistenceObjectMD{

    public static final PersistencePropertyMD FIRST_NAME = new PersistencePropertyMD( EmployeeMD.FIRST_NAME, String.class );
    public static final PersistencePropertyMD LAST_NAME = new PersistencePropertyMD( EmployeeMD.LAST_NAME, String.class );
    public static final PersistencePropertyMD AGE = new PersistencePropertyMD( EmployeeMD.AGE, int.class );

    public static final PersistenceReferenceMD DEPARTMENT = new PersistenceReferenceMD( EmployeeMD.DEPARTMENT );

    private static final EmployeePOMD instance;

    static{
        List<PersistencePropertyMD> properties = new ArrayList<PersistencePropertyMD>();
        properties.add( FIRST_NAME );
        properties.add( LAST_NAME );
        properties.add( AGE );

        List<PersistenceReferenceMD> references = new ArrayList<PersistenceReferenceMD>();
        references.add( DEPARTMENT );

        instance = new EmployeePOMD( Employee.class, EmployeePO.class, EmployeeReferencesPO.class, properties, references );
    }

    private EmployeePOMD( Class idObjectClass, Class persistenceObjectClass, Class persistenceReferencesClass, List<PersistencePropertyMD> propertiesMD,
            List<PersistenceReferenceMD> references ){
        super( idObjectClass, persistenceObjectClass, persistenceReferencesClass, propertiesMD, references );
    }

    public static EmployeePOMD instance(){
        return instance;
    }
}

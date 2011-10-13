package com.idobjects.test.company.db;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceObjectMD;
import com.idobjects.persistence.api.PersistencePropertyMD;
import com.idobjects.persistence.api.PersistenceReferenceMD;
import com.idobjects.test.company.Department;
import com.idobjects.test.company.DepartmentMD;

public class DepartmentPOMD extends PersistenceObjectMD{

    public static final PersistencePropertyMD NAME = new PersistencePropertyMD( DepartmentMD.NAME, String.class );

    public static final PersistencePropertyMD SIZE = new PersistencePropertyMD( DepartmentMD.SIZE, int.class );

    public static final PersistenceReferenceMD MEMBERS = new PersistenceReferenceMD( DepartmentMD.MEMBERS );

    public static final PersistenceReferenceMD BOSS = new PersistenceReferenceMD( DepartmentMD.BOSS );

    private static final DepartmentPOMD instance;

    static{
        List<PersistencePropertyMD> properties = new ArrayList<PersistencePropertyMD>();
        properties.add( NAME );
        properties.add( SIZE );

        List<PersistenceReferenceMD> references = new ArrayList<PersistenceReferenceMD>();
        references.add( MEMBERS );
        references.add( BOSS );

        instance = new DepartmentPOMD( Department.class, DepartmentPO.class, DepartmentReferencesPO.class, properties, references );
    }

    private DepartmentPOMD( Class idObjectClass, Class persistenceObjectClass, Class persistenceReferencesClass, List<PersistencePropertyMD> propertiesMD,
            List<PersistenceReferenceMD> references ){
        super( idObjectClass, persistenceObjectClass, persistenceReferencesClass, propertiesMD, references );
    }

    public static DepartmentPOMD instance(){
        return instance;
    }
}

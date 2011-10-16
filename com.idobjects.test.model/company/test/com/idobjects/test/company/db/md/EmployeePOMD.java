package com.idobjects.test.company.db.md;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceObjectMD;
import com.idobjects.persistence.api.PersistencePropertyMD;
import com.idobjects.persistence.api.PersistenceReferenceMD;
import com.idobjects.test.company.EmployeeMD;
import com.idobjects.test.company.db.EmployeePO;
import com.idobjects.test.company.db.EmployeeReferencePO;
import com.idobjects.test.company.db.EmployeeReferenceVersionPO;
import com.idobjects.test.company.db.EmployeeVersionPO;

public class EmployeePOMD extends PersistenceObjectMD{

    public static final PersistencePropertyMD FIRST_NAME = new PersistencePropertyMD( EmployeeMD.FIRST_NAME, String.class );
    public static final PersistencePropertyMD LAST_NAME = new PersistencePropertyMD( EmployeeMD.LAST_NAME, String.class );
    public static final PersistencePropertyMD AGE = new PersistencePropertyMD( EmployeeMD.AGE, int.class );

    public static final PersistenceReferenceMD DEPARTMENT = new PersistenceReferenceMD( EmployeeMD.DEPARTMENT );

    private static final EmployeePOMD instance;

    static{
        InitData initData = new InitData();
        List<PersistencePropertyMD> properties = new ArrayList<PersistencePropertyMD>();
        properties.add( FIRST_NAME );
        properties.add( LAST_NAME );
        properties.add( AGE );
        initData.propertiesMD = properties;

        List<PersistenceReferenceMD> references = new ArrayList<PersistenceReferenceMD>();
        references.add( DEPARTMENT );
        initData.referencesMD = references;

        initData.idObjectMD = EmployeeMD.instance();
        initData.persistenceObjectClass = EmployeePO.class;
        initData.persistenceReferencesClass = EmployeeReferencePO.class;
        initData.objectVersionClass = EmployeeVersionPO.class;
        initData.referenceVersionClass = EmployeeReferenceVersionPO.class;

        initData.entityField = "employee";
        initData.entityReferenceField = "employeeReference";
        initData.modelVersionField = "companyVersion";

        instance = new EmployeePOMD( initData );

    }

    private EmployeePOMD( InitData initData ){
        super( initData );
    }

    public static EmployeePOMD instance(){
        return instance;
    }
}

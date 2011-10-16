package com.idobjects.test.company.db.md;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceObjectMD;
import com.idobjects.persistence.api.PersistencePropertyMD;
import com.idobjects.persistence.api.PersistenceReferenceMD;
import com.idobjects.test.company.DepartmentMD;
import com.idobjects.test.company.db.DepartmentPO;
import com.idobjects.test.company.db.DepartmentReferencePO;
import com.idobjects.test.company.db.DepartmentReferenceVersionPO;
import com.idobjects.test.company.db.DepartmentVersionPO;

public class DepartmentPOMD extends PersistenceObjectMD{

    public static final PersistencePropertyMD NAME = new PersistencePropertyMD( DepartmentMD.NAME, String.class );

    public static final PersistencePropertyMD SIZE = new PersistencePropertyMD( DepartmentMD.SIZE, int.class );

    public static final PersistenceReferenceMD MEMBERS = new PersistenceReferenceMD( DepartmentMD.MEMBERS );

    public static final PersistenceReferenceMD BOSS = new PersistenceReferenceMD( DepartmentMD.BOSS );

    private static final DepartmentPOMD instance;

    static{
        InitData initData = new InitData();
        List<PersistencePropertyMD> properties = new ArrayList<PersistencePropertyMD>();
        properties.add( NAME );
        properties.add( SIZE );
        initData.propertiesMD = properties;

        List<PersistenceReferenceMD> references = new ArrayList<PersistenceReferenceMD>();
        references.add( MEMBERS );
        references.add( BOSS );
        initData.referencesMD = references;

        initData.idObjectMD = DepartmentMD.instance();
        initData.persistenceObjectClass = DepartmentPO.class;
        initData.persistenceReferencesClass = DepartmentReferencePO.class;
        initData.objectVersionClass = DepartmentVersionPO.class;
        initData.referenceVersionClass = DepartmentReferenceVersionPO.class;

        initData.entityField = "department";
        initData.entityReferenceField = "departmentReference";
        initData.modelVersionField = "companyVersion";

        instance = new DepartmentPOMD( initData );

    }

    private DepartmentPOMD( InitData initData ){
        super( initData );
    }

    public static DepartmentPOMD instance(){
        return instance;
    }
}

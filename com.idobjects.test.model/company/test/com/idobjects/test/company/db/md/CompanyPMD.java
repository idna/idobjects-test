package com.idobjects.test.company.db.md;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceModelMD;
import com.idobjects.persistence.api.PersistenceObjectMD;
import com.idobjects.test.company.CompanyModelMD;
import com.idobjects.test.company.db.CompanyKeyPO;
import com.idobjects.test.company.db.CompanyVersionPO;

public final class CompanyPMD extends PersistenceModelMD{

    private static final CompanyPMD instance;

    static{
        List<PersistenceObjectMD> pomdObjects = new ArrayList<PersistenceObjectMD>();
        pomdObjects.add( EmployeePOMD.instance() );
        pomdObjects.add( DepartmentPOMD.instance() );
        instance = new CompanyPMD( pomdObjects );
    }

    private CompanyPMD( List<PersistenceObjectMD> objects ){
        super( CompanyModelMD.instance(), CompanyKeyPO.class, CompanyVersionPO.class, "companyKey", objects );
    }

    public static CompanyPMD instance(){
        return instance;
    }

}

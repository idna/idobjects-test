package com.idobjects.test.company.db;

import java.util.ArrayList;
import java.util.List;

import com.idobjects.persistence.api.PersistenceMD;
import com.idobjects.persistence.api.PersistenceObjectMD;

public final class CompanyMD extends PersistenceMD{

    private static final CompanyMD instance;

    static{
        List<PersistenceObjectMD> objects = new ArrayList<PersistenceObjectMD>();
        instance = new CompanyMD( objects );
    }

    private CompanyMD( List<PersistenceObjectMD> objects ){
        super(null, objects );
    }

    public static CompanyMD getInstance(){
        return instance;
    }

}

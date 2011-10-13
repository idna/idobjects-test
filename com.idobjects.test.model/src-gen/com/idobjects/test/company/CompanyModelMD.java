
package com.idobjects.test.company;
	
import com.idobjects.api.md.ModelMetadata;
import java.util.List;
import java.util.ArrayList;
import com.idobjects.api.md.IdObjectMD;
	
public class CompanyModelMD extends ModelMetadata{
		
	private static final CompanyModelMD instance;

	static{
	     List<IdObjectMD> objects = new ArrayList<IdObjectMD>();
	        
	        
        objects.add( EmployeeMD.instance());
        objects.add( FreelancerMD.instance());
        objects.add( DepartmentMD.instance());
        
        instance = new  CompanyModelMD( objects );
    }

    private CompanyModelMD( List<IdObjectMD> objects ){
        super( objects );
    }

    public static CompanyModelMD instance(){
        return instance;
    }
	
	
}


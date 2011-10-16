
			
		package com.idobjects.test.company;
		
		
			import java.util.Collections;
		
			import java.util.List;
		
			import java.util.ArrayList;
		
			import com.idobjects.api.ModelScope;
		
			import com.idobjects.api.ObjectIdentifier;
		
			import com.idobjects.api.md.IdObjectMD;
		
			import com.idobjects.api.md.IdObjectPropertyMD;
		
			import com.idobjects.api.md.IdObjectReferenceMD;
		
			import com.idobjects.api.md.ReferenceType;
		
			import org.joda.time.Instant;
		
			import org.joda.time.DateTime;
		

		
		public final class DepartmentMD extends IdObjectMD{

			

    public static final IdObjectPropertyMD NAME = new IdObjectPropertyMD("name", String.class);



    public static final IdObjectPropertyMD SIZE = new IdObjectPropertyMD("size", int.class);


		
			
	  public static final IdObjectReferenceMD MEMBERS = new IdObjectReferenceMD( DepartmentMD.class, EmployeeMD.class, "members", "department",true , ReferenceType.LIST,
            null );


	  public static final IdObjectReferenceMD BOSS = new IdObjectReferenceMD( DepartmentMD.class, EmployeeMD.class, "boss", "null",false , ReferenceType.SINGLE,
            null );


		
			public static final List<IdObjectPropertyMD> PROPERTIES;
	    	public static final List<IdObjectReferenceMD> REFERENCES;
	
	    	static{
		        List<IdObjectPropertyMD> properties = new ArrayList<IdObjectPropertyMD>();
		        
		        
		        properties.add( NAME );
		        
		        properties.add( SIZE );
		         
		        
		        PROPERTIES = Collections.unmodifiableList( properties );
		
		        List<IdObjectReferenceMD> references = new ArrayList<IdObjectReferenceMD>();
		        
		        
		        references.add( MEMBERS );
		        
		        references.add( BOSS );
		         
		        
		        REFERENCES = Collections.unmodifiableList( references );
	    	}
	    	
	    	
	   	    private static final DepartmentMD instance = new DepartmentMD();

		    public static final DepartmentMD instance(){
		        return instance;
		    }
		
		    private DepartmentMD(){
		        super( Department.class, PROPERTIES, REFERENCES );
		    }
		    
		    
		    public  Department createNewIdObject( ModelScope modelScope, ObjectIdentifier objectId){
		    	return new Department(modelScope,objectId);
		    }
		
		}  
	
	
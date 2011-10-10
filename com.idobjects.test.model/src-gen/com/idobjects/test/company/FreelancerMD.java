
			
		package com.idobjects.test.company;
		
		
			import java.util.Collections;
		
			import java.util.List;
		
			import java.util.ArrayList;
		
			import com.idobjects.api.md.IdObjectMD;
		
			import com.idobjects.api.md.IdObjectPropertyMD;
		
			import com.idobjects.api.md.IdObjectReferenceMD;
		
			import com.idobjects.api.md.ReferenceType;
		
			import org.joda.time.Instant;
		
			import org.joda.time.DateTime;
		

		
		public final class FreelancerMD extends IdObjectMD{

			

    public static final IdObjectPropertyMD START_OF_WORK = new IdObjectPropertyMD("startOfWork", DateTime.class);



    public static final IdObjectPropertyMD END_OF_WORK = new IdObjectPropertyMD("endOfWork", DateTime.class);


		
			
		
			public static final List<IdObjectPropertyMD> PROPERTIES;
	    	public static final List<IdObjectReferenceMD> REFERENCES;
	
	    	static{
		        List<IdObjectPropertyMD> properties = new ArrayList<IdObjectPropertyMD>();
		        
		        
		        properties.add( START_OF_WORK );
		        
		        properties.add( END_OF_WORK );
		         
		        
		        PROPERTIES = Collections.unmodifiableList( properties );
		
		        List<IdObjectReferenceMD> references = new ArrayList<IdObjectReferenceMD>();
		        
		         
		        
		        REFERENCES = Collections.unmodifiableList( references );
	    	}
	    	
	    	
	   	    private static final FreelancerMD instance = new FreelancerMD();

		    public static final FreelancerMD instance(){
		        return instance;
		    }
		
		    private FreelancerMD(){
		        super( Freelancer.class, PROPERTIES, REFERENCES );
		    }
		
		}  
	
	
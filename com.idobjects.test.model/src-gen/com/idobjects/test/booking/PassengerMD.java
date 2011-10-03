
			
		package com.idobjects.test.booking;
		
		
			import java.util.Collections;
		
			import java.util.List;
		
			import java.util.ArrayList;
		
			import com.idobjects.api.md.IdObjectMD;
		
			import com.idobjects.api.md.IdObjectPropertyMD;
		
			import com.idobjects.api.md.IdObjectReferenceMD;
		
			import com.idobjects.api.md.ReferenceType;
		
			import org.joda.time.Instant;
		
			import org.joda.time.DateTime;
		

		
		public final class PassengerMD extends IdObjectMD{

			

    public static final IdObjectPropertyMD FIRST_NAME = new IdObjectPropertyMD("firstName", String.class);



    public static final IdObjectPropertyMD LAST_NAME = new IdObjectPropertyMD("lastName", String.class);


		
			
	  public static final IdObjectReferenceMD FLIGHTS = new IdObjectReferenceMD( PassengerMD.class, FlightMD.class, "flights", "passengers",true , ReferenceType.LIST,
            null );


		
			public static final List<IdObjectPropertyMD> PROPERTIES;
	    	public static final List<IdObjectReferenceMD> REFERENCES;
	
	    	static{
		        List<IdObjectPropertyMD> properties = new ArrayList<IdObjectPropertyMD>();
		        
		        
		        properties.add( FIRST_NAME );
		        
		        properties.add( LAST_NAME );
		         
		        
		        PROPERTIES = Collections.unmodifiableList( properties );
		
		        List<IdObjectReferenceMD> references = new ArrayList<IdObjectReferenceMD>();
		        
		        
		        references.add( FLIGHTS );
		         
		        
		        REFERENCES = Collections.unmodifiableList( references );
	    	}
	    	
	    	
	   	    private static final PassengerMD instance = new PassengerMD();

		    public static final PassengerMD instance(){
		        return instance;
		    }
		
		    private PassengerMD(){
		        super( Passenger.class.getName(), PROPERTIES, REFERENCES );
		    }
		
		}  
	
	
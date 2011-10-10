
			
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
		

		
		public final class FlightMD extends IdObjectMD{

			

    public static final IdObjectPropertyMD ORIGIN = new IdObjectPropertyMD("origin", String.class);



    public static final IdObjectPropertyMD DEPARTURE = new IdObjectPropertyMD("departure", String.class);


		
			
	  public static final IdObjectReferenceMD PASSENGERS = new IdObjectReferenceMD( FlightMD.class, PassengerMD.class, "passengers", "flights",true , ReferenceType.LIST,
            null );


		
			public static final List<IdObjectPropertyMD> PROPERTIES;
	    	public static final List<IdObjectReferenceMD> REFERENCES;
	
	    	static{
		        List<IdObjectPropertyMD> properties = new ArrayList<IdObjectPropertyMD>();
		        
		        
		        properties.add( ORIGIN );
		        
		        properties.add( DEPARTURE );
		         
		        
		        PROPERTIES = Collections.unmodifiableList( properties );
		
		        List<IdObjectReferenceMD> references = new ArrayList<IdObjectReferenceMD>();
		        
		        
		        references.add( PASSENGERS );
		         
		        
		        REFERENCES = Collections.unmodifiableList( references );
	    	}
	    	
	    	
	   	    private static final FlightMD instance = new FlightMD();

		    public static final FlightMD instance(){
		        return instance;
		    }
		
		    private FlightMD(){
		        super( Flight.class, PROPERTIES, REFERENCES );
		    }
		
		}  
	
	

			
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
		

		
		public final class BookingMD extends IdObjectMD{

			

    public static final IdObjectPropertyMD BOOKING_NUMBER = new IdObjectPropertyMD("bookingNumber", String.class);


		
			
	  public static final IdObjectReferenceMD PASSENGERS = new IdObjectReferenceMD( BookingMD.class, PassengerMD.class, "passengers", "null",false , ReferenceType.LIST,
            null );


	  public static final IdObjectReferenceMD FLIGHTS = new IdObjectReferenceMD( BookingMD.class, FlightMD.class, "flights", "null",false , ReferenceType.LIST,
            null );


		
			public static final List<IdObjectPropertyMD> PROPERTIES;
	    	public static final List<IdObjectReferenceMD> REFERENCES;
	
	    	static{
		        List<IdObjectPropertyMD> properties = new ArrayList<IdObjectPropertyMD>();
		        
		        
		        properties.add( BOOKING_NUMBER );
		         
		        
		        PROPERTIES = Collections.unmodifiableList( properties );
		
		        List<IdObjectReferenceMD> references = new ArrayList<IdObjectReferenceMD>();
		        
		        
		        references.add( PASSENGERS );
		        
		        references.add( FLIGHTS );
		         
		        
		        REFERENCES = Collections.unmodifiableList( references );
	    	}
	    	
	    	
	   	    private static final BookingMD instance = new BookingMD();

		    public static final BookingMD instance(){
		        return instance;
		    }
		
		    private BookingMD(){
		        super( Booking.class.getName(), PROPERTIES, REFERENCES );
		    }
		
		}  
	
	
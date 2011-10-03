
			
		package com.idobjects.test.booking;
		
		
			import java.util.Collection;
		
			import java.util.List;
		
			import com.idobjects.api.AbstractIdObject;
		
			import com.idobjects.api.ModelScope;
		
			import com.idobjects.api.ObjectIdentifier;
		
			import org.joda.time.Instant;
		
			import org.joda.time.DateTime;
		
		
		
		public class Flight extends AbstractIdObject {
	
		public Flight(ModelScope modelScope, ObjectIdentifier objectId) {
			super(modelScope, objectId);
		}
		
		
		
	
	public void setOrigin(String origin) {
		 setPropertyValue( FlightMD.ORIGIN, origin );
	}
	
	public String getOrigin() {
		return (String) getPropertyValue( FlightMD.ORIGIN );	
	}




	
	public void setDeparture(String departure) {
		 setPropertyValue( FlightMD.DEPARTURE, departure );
	}
	
	public String getDeparture() {
		return (String) getPropertyValue( FlightMD.DEPARTURE );	
	}





		

	
	
		public void addPassenger( Passenger toAdd)  {
			addReference( FlightMD.PASSENGERS ,toAdd);
		}
		
		public void addPassengers (Collection<? extends Passenger > toAdd) {
			addReferences( FlightMD.PASSENGERS ,toAdd);
		}
		
		public void removePassenger ( Passenger toRemove){
			removeReference(  FlightMD.PASSENGERS, toRemove);
		}
		
		public void removePassengers ( Collection< ? extends Passenger> toRemove){
			removeReferences(  FlightMD.PASSENGERS, toRemove);
		}
		
		public List< Passenger > getPassengers (){
		  return getCastedReferences( FlightMD.PASSENGERS, Passenger.class );
		}

	
	


		
		}  
	
	
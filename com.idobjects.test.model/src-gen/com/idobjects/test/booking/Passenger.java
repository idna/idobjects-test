
			
		package com.idobjects.test.booking;
		
		import java.util.Collection;
		import java.util.List;
		
		import com.idobjects.api.AbstractIdObject;
		import com.idobjects.api.ModelScope;
		import com.idobjects.api.ObjectIdentifier;
		
		
		public class Passenger extends AbstractIdObject {
	
		public Passenger(ModelScope modelScope, ObjectIdentifier objectId) {
			super(modelScope, objectId);
		}
		
		
		
	
	public void setFirstName(String firstName) {
		 setPropertyValue( PassengerMD.FIRST_NAME, firstName );
	}
	
	public String getFirstName() {
		return (String) getPropertyValue( PassengerMD.FIRST_NAME );	
	}




	
	public void setLastName(String lastName) {
		 setPropertyValue( PassengerMD.LAST_NAME, lastName );
	}
	
	public String getLastName() {
		return (String) getPropertyValue( PassengerMD.LAST_NAME );	
	}





		

	
	
		public void addFlight( Flight toAdd)  {
			addReference( PassengerMD.FLIGHTS ,toAdd);
		}
		
		public void addFlights (Collection<? extends Flight > toAdd) {
			addReferences( PassengerMD.FLIGHTS ,toAdd);
		}
		
		public void removeFlight ( Flight toRemove){
			removeReference(  PassengerMD.FLIGHTS, toRemove);
		}
		
		public void removeFlights ( Collection< ? extends Flight> toRemove){
			removeReferences(  PassengerMD.FLIGHTS, toRemove);
		}
		
		public List< Flight > getFlights (){
		  return getCastedReferences( PassengerMD.FLIGHTS, Flight.class );
		}

	
	


		
		}  
	
	
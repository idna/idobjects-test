
			
		package com.idobjects.test.company;
		
		
			import java.util.Collection;
		
			import java.util.List;
		
			import com.idobjects.api.AbstractIdObject;
		
			import com.idobjects.api.ModelScope;
		
			import com.idobjects.api.ObjectIdentifier;
		
			import org.joda.time.Instant;
		
			import org.joda.time.DateTime;
		
		
		
		public class Freelancer extends AbstractIdObject {
	
		public Freelancer(ModelScope modelScope, ObjectIdentifier objectId) {
			super(modelScope, objectId);
		}
		
		
		
	
	public void setStartOfWork(DateTime startOfWork) {
		 setPropertyValue( FreelancerMD.START_OF_WORK, startOfWork );
	}
	
	public DateTime getStartOfWork() {
		return (DateTime) getPropertyValue( FreelancerMD.START_OF_WORK );	
	}




	
	public void setEndOfWork(DateTime endOfWork) {
		 setPropertyValue( FreelancerMD.END_OF_WORK, endOfWork );
	}
	
	public DateTime getEndOfWork() {
		return (DateTime) getPropertyValue( FreelancerMD.END_OF_WORK );	
	}





		
		
		}  
	
	

			
		package com.idobjects.test.company;
		
		
			import java.util.Collection;
		
			import java.util.List;
		
			import com.idobjects.api.AbstractIdObject;
		
			import com.idobjects.api.ModelScope;
		
			import com.idobjects.api.ObjectIdentifier;
		
			import org.joda.time.Instant;
		
			import org.joda.time.DateTime;
		
		
		
		public class Employee extends AbstractIdObject {
	
		public Employee(ModelScope modelScope, ObjectIdentifier objectId) {
			super(modelScope, objectId);
		}
		
		
		
	
	public void setFirstName(String firstName) {
		 setPropertyValue( EmployeeMD.FIRST_NAME, firstName );
	}
	
	public String getFirstName() {
		return (String) getPropertyValue( EmployeeMD.FIRST_NAME );	
	}




	
	public void setLastName(String lastName) {
		 setPropertyValue( EmployeeMD.LAST_NAME, lastName );
	}
	
	public String getLastName() {
		return (String) getPropertyValue( EmployeeMD.LAST_NAME );	
	}




	
	public void setAge(int age) {
		 setPropertyValue( EmployeeMD.AGE, age );
	}
	
	public int getAge() {
		return (Integer) getPropertyValue( EmployeeMD.AGE );	
	}





		

	
		public void setDepartment ( Department department ) {
			addReference( EmployeeMD.DEPARTMENT ,department);
		}
		
		public void  removeDepartment () {
			removeReference(  EmployeeMD.DEPARTMENT);
		}
		
		public Department  getDepartment (){
		 return (  Department )getSingleReference(  EmployeeMD.DEPARTMENT );
		}
		
		 
	
	


		
		}  
	
	
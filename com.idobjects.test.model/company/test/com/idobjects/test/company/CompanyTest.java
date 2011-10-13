package com.idobjects.test.company;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Test;

import com.idobjects.api.GuidObjectIdentifier;
import com.idobjects.api.IdObject;
import com.idobjects.api.IdObjectReference;
import com.idobjects.api.ModelScope;
import com.idobjects.api.ModelScopeListener;
import com.idobjects.api.StringModelScopeIdentifier;

// Test Comment Numemr 2
public class CompanyTest{

    private final Mockery context = new Mockery();

    @Test
    public void testCreation(){
        ModelScope companyModelScope = createCompanyModelScope();
        Assert.assertEquals( 0, companyModelScope.size() );
    }

    private ModelScope createCompanyModelScope(){
        ModelScope companyModelScope = new ModelScope( new StringModelScopeIdentifier( "CompanyModelScope" ) );
        return companyModelScope;
    }

    @Test
    public void testAddingIdObject(){
        ModelScope companyModelScope = createCompanyModelScope();
        Employee employee = new Employee( companyModelScope, new GuidObjectIdentifier() );
        Assert.assertTrue( companyModelScope.containsObject( employee.getId() ) );
        Assert.assertEquals( 1, companyModelScope.size() );

        Department department = new Department( companyModelScope, new GuidObjectIdentifier() );
        Assert.assertTrue( companyModelScope.containsObject( department.getId() ) );
        Assert.assertEquals( 2, companyModelScope.size() );
    }

    @Test
    public void testProperties(){
        ModelScope companyModelScope = createCompanyModelScope();
        Employee employee = new Employee( companyModelScope, new GuidObjectIdentifier() );
        employee.setFirstName( "firstName" );
        Assert.assertEquals( "firstName", employee.getFirstName() );
        employee.setLastName( "lastName" );
        Assert.assertEquals( "firstName", employee.getLastName(), "lastName" );
    }

    @Test
    public void testReferences(){
        ModelScope companyModelScope = createCompanyModelScope();
        Employee employee = new Employee( companyModelScope, new GuidObjectIdentifier() );
        Department department = new Department( companyModelScope, new GuidObjectIdentifier() );

        // From Employee -> Department
        employee.setDepartment( department );

        Assert.assertEquals( department, employee.getDepartment() );
        Assert.assertEquals( 1, department.getMembers().size() );
        Assert.assertEquals( employee, department.getMembers().get( 0 ) );

        employee.removeDepartment();
        Assert.assertNull( employee.getDepartment() );
        Assert.assertEquals( 0, department.getMembers().size() );

        // From Department -> Employee
        department.addMember( employee );
        Assert.assertTrue( department.getMembers().contains( employee ) );
        Assert.assertTrue( employee.getDepartment().equals( department ) );

        department.removeMember( employee );
        Assert.assertEquals( 0, department.getMembers().size() );
        Assert.assertNull( employee.getDepartment() );

    }

    @Test
    public void testPartialModelScope(){
        ModelScope companyModelScope = createCompanyModelScope();
        Employee employee = new Employee( companyModelScope, new GuidObjectIdentifier() );
        Department department = new Department( companyModelScope, new GuidObjectIdentifier() );

        ModelScope modelScope2 = new ModelScope( new StringModelScopeIdentifier( "CompanyModelScope2" ) );
        Employee employee2 = new Employee( modelScope2, new GuidObjectIdentifier() );

        department.addReference( DepartmentMD.MEMBERS, employee2.getId() );
        Assert.assertNull( department.getMembers().get( 0 ) );
        Assert.assertNull( department.getReferences().get( DepartmentMD.MEMBERS ).get( 0 ).getDestinationObject() );
        Assert.assertEquals( employee2.getId(), department.getReferences().get( DepartmentMD.MEMBERS ).get( 0 ).getDestinationObjectId() );

    }

    @Test
    public void testCopyModelScope(){
        ModelScope companyModelScope = createCompanyModelScope();
        Employee employee = new Employee( companyModelScope, new GuidObjectIdentifier() );
        Department department = new Department( companyModelScope, new GuidObjectIdentifier() );

        ModelScope copy = companyModelScope.copy( new StringModelScopeIdentifier( "ModelScop3" ) );
        Assert.assertEquals( companyModelScope.size(), copy.size() );
    }

    @Test
    public void testModelScopeListener(){
        ModelScope companyModelScope = createCompanyModelScope();
        final ModelScopeListener listener = context.mock( ModelScopeListener.class );
        context.checking( new Expectations(){

            {
                exactly( 2 ).of( listener ).objectAdded( with( any( IdObject.class ) ) );

            }
        } );

        companyModelScope.addModelScopeListener( listener );

        final Employee employee1 = new Employee( companyModelScope, new GuidObjectIdentifier() );
        final Department department = new Department( companyModelScope, new GuidObjectIdentifier() );

        context.checking( new Expectations(){

            {
                oneOf( listener ).objectChanged( employee1 );
                exactly( 2 ).of( listener ).referenceAdded( with( any( IdObjectReference.class ) ) );
                exactly( 2 ).of( listener ).referenceRemoved( with( any( IdObjectReference.class ) ) );
                one( listener ).objectRemoved( employee1 );
            }
        } );

        employee1.setFirstName( "FirstName" );
        employee1.setDepartment( department );

        // removes also the two References from and to employee
        companyModelScope.removeIdObject( employee1 );

        context.assertIsSatisfied();

    }
}

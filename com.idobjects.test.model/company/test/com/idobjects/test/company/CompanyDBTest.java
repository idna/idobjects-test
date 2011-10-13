package com.idobjects.test.company;

import java.sql.DriverManager;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.junit.Before;
import org.junit.Test;

import com.idobjects.api.GuidObjectIdentifier;
import com.idobjects.api.ModelScope;
import com.idobjects.api.StringModelScopeIdentifier;
import com.idobjects.persistence.api.PersistenceManagerImpl;
import com.idobjects.test.company.db.CompanyPMD;
import com.mysql.jdbc.Driver;

public class CompanyDBTest{

    @Before
    public void setup(){
        try{
            Driver.class.newInstance();
            com.mysql.jdbc.JDBC4Connection connection = ( com.mysql.jdbc.JDBC4Connection )DriverManager.getConnection( "jdbc:mysql://localhost/mysql?user=root&password=" );
            System.out.println( connection );
            Statement createStatement = connection.createStatement();

            createStatement.execute( "drop database idobjects_test" );
            createStatement.execute( "create database idobjects_test" );

            createStatement.execute( "DROP USER idobjects" );
            createStatement.execute( "CREATE USER idobjects IDENTIFIED BY 'idobjects'" );

            createStatement.execute( "GRANT ALL PRIVILEGES ON idobjects_test.* to 'idobjects'@'localhost' IDENTIFIED BY 'idobjects'" );

            createStatement.close();
            connection.close();
        }
        catch( Exception e ){
            e.printStackTrace();
        }

    }

    @Test
    public void testBD(){

        Configuration configuration = new Configuration();
        for( Class annotatedClass : CompanyPMD.instance().getPersistenceClasses() ){
            configuration.addAnnotatedClass( annotatedClass );
        }

        String userName = "idobjects";
        String password = "idobjects";
        Class dbDriverClass = Driver.class;

        String jdbcUrl = "jdbc:mysql://localhost/idobjects_test?user=idobjects&password=idobjects";
        String dialect = MySQL5Dialect.class.getName();

        configuration.setProperty( "hibernate.connection.username", userName );
        configuration.setProperty( "hibernate.connection.password", password );
        configuration.setProperty( "hibernate.connection.driver_class", dbDriverClass.getClass().getName() );
        configuration.setProperty( "hibernate.current_session_context_class", "thread" );

        configuration.setProperty( "hibernate.connection.url", jdbcUrl );
        configuration.setProperty( "hibernate.dialect", dialect );

        SchemaUpdate schemaUpdate = new SchemaUpdate( configuration );
        schemaUpdate.execute( false, true );

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl( sessionFactory, CompanyPMD.instance() );
        ModelScope modelScope = new ModelScope( new StringModelScopeIdentifier( "MS1" ) );
        Employee employee = new Employee( modelScope, new GuidObjectIdentifier() );
        employee.setAge( 25 );
        employee.setFirstName( "firstname" );
        employee.setLastName( "lastname" );

        Employee boss = new Employee( modelScope, new GuidObjectIdentifier() );
        boss.setAge( 50 );
        boss.setFirstName( "BossFirstName" );
        boss.setLastName( "BossLastName" );

        Department department = new Department( modelScope, new GuidObjectIdentifier() );
        department.setBoss( boss );
        department.addMember( employee );
        department.setSize( 1 );
        department.setName( "Department1" );

        persistenceManagerImpl.saveModelScope( modelScope );

    }
}

package com.idobjects.test.company;

import org.joda.time.DateTime;

import com.idobjects.api.ModelScope;
import com.idobjects.api.ObjectIdentifier;

public class Freelancer extends Employee{

    public Freelancer( ModelScope modelScope, ObjectIdentifier objectId ){
        super( modelScope, objectId );
    }

    public void setStartOfWork( DateTime startOfWork ){
        setPropertyValue( FreelancerMD.START_OF_WORK, startOfWork );
    }

    public DateTime getStartOfWork(){
        return ( DateTime )getPropertyValue( FreelancerMD.START_OF_WORK );
    }

    public void setEndOfWork( DateTime endOfWork ){
        setPropertyValue( FreelancerMD.END_OF_WORK, endOfWork );
    }

    public DateTime getEndOfWork(){
        return ( DateTime )getPropertyValue( FreelancerMD.END_OF_WORK );
    }

}

package com.idobjects.test.booking;

import java.util.Collection;
import java.util.List;

import com.idobjects.api.AbstractIdObject;
import com.idobjects.api.ModelScope;
import com.idobjects.api.ObjectIdentifier;

public class Booking extends AbstractIdObject{

    public Booking( ModelScope modelScope, ObjectIdentifier objectId ){
        super( modelScope, objectId );
    }

    public void setBookingNumber( String bookingNumber ){
        setPropertyValue( BookingMD.BOOKING_NUMBER, bookingNumber );
    }

    public String getBookingNumber(){
        return ( String )getPropertyValue( BookingMD.BOOKING_NUMBER );
    }

    public void addPassenger( Passenger toAdd ){
        addReference( BookingMD.PASSENGERS, toAdd );
    }

    public void addPassengers( Collection< ? extends Passenger> toAdd ){
        addReferences( BookingMD.PASSENGERS, toAdd );
    }

    public void removePassenger( Passenger toRemove ){
        removeReference( BookingMD.PASSENGERS, toRemove );
    }

    public void removePassengers( Collection< ? extends Passenger> toRemove ){
        removeReferences( BookingMD.PASSENGERS, toRemove );
    }

    public List<Passenger> getPassengers(){
        return getCastedReferences( BookingMD.PASSENGERS, Passenger.class );
    }

    public void addFlight( Flight toAdd ){
        addReference( BookingMD.FLIGHTS, toAdd );
    }

    public void addFlights( Collection< ? extends Flight> toAdd ){
        addReferences( BookingMD.FLIGHTS, toAdd );
    }

    public void removeFlight( Flight toRemove ){
        removeReference( BookingMD.FLIGHTS, toRemove );
    }

    public void removeFlights( Collection< ? extends Flight> toRemove ){
        removeReferences( BookingMD.FLIGHTS, toRemove );
    }

    public List<Flight> getFlights(){
        return getCastedReferences( BookingMD.FLIGHTS, Flight.class );
    }

}

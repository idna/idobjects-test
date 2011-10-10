
package com.idobjects.test.booking;
	
import com.idobjects.api.md.ModelMetadata;
import java.util.List;
import java.util.ArrayList;
import com.idobjects.api.md.IdObjectMD;
	
public class BookingModelMD extends ModelMetadata{
		
	private static final BookingModelMD instance;

	static{
	     List<IdObjectMD> objects = new ArrayList<IdObjectMD>();
	        
	        
        objects.add( BookingMD.instance());
        objects.add( PassengerMD.instance());
        objects.add( FlightMD.instance());
        
        instance = new  BookingModelMD( objects );
    }

    private BookingModelMD( List<IdObjectMD> objects ){
        super( objects );
    }

    public static BookingModelMD instance(){
        return instance;
    }
	
	
}
	
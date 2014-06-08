package tiluws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tilufwlow.webservices.hotelservice.HotelDetailsRequest;
import tilufwlow.webservices.hotelservice.HotelDetailsResponse;
import tiluws.service.HotelService;

@Endpoint
public class HotelServiceEndpoint {
	 private static final String TARGET_NAMESPACE = "http://webservices.tilufwlow/hotelservice";  
	 
	 private HotelService hotelService;
	 @Autowired
	 public HotelServiceEndpoint(final HotelService hotelService){
		 this.hotelService=hotelService;
		 
	 }
	 @PayloadRoot(localPart = "HotelDetailsRequest", namespace = TARGET_NAMESPACE)  
	 public @ResponsePayload HotelDetailsResponse getListHotelsDetails(@RequestPayload HotelDetailsRequest request){
		 HotelDetailsResponse response= new  HotelDetailsResponse();
		 response.getHotelList().addAll(hotelService.getListHotels(request.getHotelId()));
		 return response;
	 }
	 
}

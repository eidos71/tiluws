package tiluws.service;

import hotel.tilufwlow.webservices.Address;
import hotel.tilufwlow.webservices.EnumHotelStatus;
import hotel.tilufwlow.webservices.Hotel;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value="mockedHotel")
public class MockedHotelServiceImpl implements HotelService {

	@Override
	public Collection<Hotel> getListHotels(String hotelId) {
		Collection<Hotel> collection = new LinkedList<Hotel>();
		Hotel hotel = new Hotel();
		hotel.setCity("Sitges");
		hotel.setHotelStatus(EnumHotelStatus.FULLSEASON_01);
		hotel.setId("31");
		hotel.setName("Sitges Park");
		hotel.setPrice(BigInteger.valueOf(313));
		hotel.setState("Barcelona");

		Address address = new Address();
		address.setLine1("line1");
		address.setLine2("line2");
		address.setLine3("line3");
		hotel.setAddress(address);
		collection.add(hotel);
		hotel = new Hotel();
		hotel.setCity("Barcelona");
		hotel.setHotelStatus(EnumHotelStatus.SUMMER_02);
		hotel.setId("234");
		hotel.setName("Barcelona Park");
		hotel.setPrice(BigInteger.valueOf(400));
		hotel.setState("Barcelona");
		address = new Address();
		address.setLine1("address-line1");
		address.setLine2("addressline2");
		address.setLine3("addressline3");
		hotel.setAddress(address);
		collection.add(hotel);

		return collection;
	}

}

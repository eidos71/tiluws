package tiluws;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.client.MockWebServiceServer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class TestAccountWS {
	   // MyWebServiceClient extends WebServiceGatewaySupport, and is configured in applicationContext.xml


	   private MockWebServiceServer mockServer;
}

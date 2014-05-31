package tiluws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import tilufwlow.webservices.Account;
import tilufwlow.webservices.accountservice.AccountDetailsRequest;
import tilufwlow.webservices.accountservice.AccountDetailsResponse;
import tiluws.service.AccountService;

@Endpoint
public class AccountServiceEndpoint {
	 private static final String TARGET_NAMESPACE = "http://webservices.tilufwlow/accountservice";  
	  
	 private AccountService accountService;
	 @Autowired
	 public AccountServiceEndpoint(final AccountService accountService){
		 this.accountService=accountService;
	 }

	 @PayloadRoot(localPart = "AccountDetailsRequest", namespace = TARGET_NAMESPACE)  
	public @ResponsePayload AccountDetailsResponse getAccountDetails(
			@RequestPayload AccountDetailsRequest request) {
		AccountDetailsResponse response = new AccountDetailsResponse();
		/* call Spring injected service implementation to retrieve account data */
		Account account = accountService.getAccountDetails(request
				.getAccountNumber());
		response.setAccountDetails(account);
		return response;
	}
}

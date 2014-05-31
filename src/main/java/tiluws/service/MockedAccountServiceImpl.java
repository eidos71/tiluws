package tiluws.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tilufwlow.webservices.Account;
import tilufwlow.webservices.EnumAccountStatus;

@Service
@Qualifier(value="mockedAccount")
public class MockedAccountServiceImpl implements AccountService {

	@Override
	public Account getAccountDetails(String accountNumber) {
	           /* hard coded account data - in reality this data would be retrieved  
	            * from a database or back end system of some sort */  
	           Account account = new Account();  
	           account.setAccountNumber("12345");  
	           account.setAccountStatus(EnumAccountStatus.ACTIVE);  
	           account.setAccountName("Joe Bloggs");  
	           account.setAccountBalance(3400);  
	           return account;  
	   
	}

}

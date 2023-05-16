package com.bank.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.bank.data.Account;
import com.bank.data.Client;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceTest {

	private AccountService accountService;

	
	private Client client;
	private Account account;
	
	
	@BeforeAll
	 public void setUpBeforeClass() {
		accountService = new AccountService();
		
		
		this.client = new Client();
		this.client.setId(1001);
		this.client.setFirstName("test-Client-First-Name");
		this.client.setLastName("test-Client-Last-Name");
		this.client.setBirthDate(LocalDate.of(2000,	 1, 1));
		
		this.account = new Account();
		this.account.setId(10001);
		this.account.setOwner(client);
		this.account.setBalance(BigDecimal.ZERO);
	}

	@BeforeEach
	void setUp() throws Exception {
		this.account.getOperations().clear();
		this.account.setBalance(BigDecimal.ZERO);

	}

	@Test
	void testDeposit() {
		BigDecimal amount20 = new BigDecimal(20);
		accountService.depositOrWithdrawal(account, amount20);
		assertTrue( amount20.compareTo(account.getBalance()) == 0 , "account balance should be equal to amount of 20" );
		assertEquals( 1, accountService.getOperations(account).size() , "account operations should be equal to 1" );

	}
	
	@Test
	void testWithdrawal() {
		BigDecimal amount20 = new BigDecimal(-20);
		accountService.depositOrWithdrawal(account, amount20);
		assertTrue( amount20.compareTo(account.getBalance()) == 0 , "account balance should be equal to amount of -20" );
		assertEquals( 1, accountService.getOperations(account).size() , "account operations should be equal to 1" );
	}
	
	@Test
	void testDepositOrWithdrawal() {
		BigDecimal depositAmount50 = new BigDecimal(50);
		BigDecimal withdrawalAmount20 = new BigDecimal(-20);

		accountService.depositOrWithdrawal(account, depositAmount50);
		accountService.depositOrWithdrawal(account, withdrawalAmount20);

		assertTrue( new BigDecimal(30).compareTo(account.getBalance()) == 0 , "account balance should be equal to amount of -20" );
		assertEquals( 2, accountService.getOperations(account).size() , "account operations should be equal to 1" );
	}

}

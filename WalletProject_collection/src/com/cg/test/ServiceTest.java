package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bean.Account;
import com.cg.service.AccountService;

class ServiceTest {
	static AccountService as=null;
	 static Account acc1=null;
	 static Account acc2=null;
	@BeforeAll
	static void createAccountService1(){
		as=new AccountService();
	}
	@BeforeAll
	static void initialiseAccount() {
		acc1=new Account();
		acc1.setAid(116);
		acc1.setAccountholder("Subhanshu");
		acc1.setBalance(15000);
		acc1.setMobile(8743015487L);
		acc2=new Account();
		acc2.setAid(118);
		acc2.setAccountholder("Raja");
		acc2.setBalance(25000);
		acc2.setMobile(8743015486L);
	}
	@Test
	void checkAddAccount() {
		assertTrue(as.addAccount(acc1));
		assertTrue(as.addAccount(acc2));
		
	}
	@Test
	void checkDeposit() {
		assertTrue(as.deposit(acc1,5000.00));		
	}

	@Test
	static void checkwithdraw() {
		assertTrue(as.withdraw(acc1,5000.00)<acc1.getBalance());
		
	}

	@Test
	void checkDeleteAccount() {
		assertTrue(as.deleteAccount(acc1));
		
	}
	@Test
	void checkprintAllAccounts() {
		assertNotNull(as.getAllAccounts());
	}
	@Test
	void findAccount() {
		as.addAccount(acc1);
		assertNotNull(as.findAccount(8743015487L));
	}
	@Test
	void checkTransfer() {
		as.addAccount(acc1);
		as.addAccount(acc2);
		assertTrue(as.transfer(acc1,acc2,5000.00));
	}


}

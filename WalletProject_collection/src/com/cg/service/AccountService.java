package com.cg.service;

import java.util.Map;
import com.cg.dao.*;
import com.cg.bean.Account;

public class AccountService implements Gst,Transaction{
	AccountDAO dao=new AccountDAOImpl();
	@Override
	public boolean addAccount(Account ob) {
		dao.addAccount(ob);
		return true;
	}

	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		dao.deleteAccount(ob);
		return true;
	}

	@Override
	public Account findAccount(Long mobileno) {
		return dao.findAccount(mobileno);
	}

	@Override
	public Map<Long, Account> printAllAccounts() {
		return dao.printAllAccounts();
	}
	public Map<Long, Account> getAllAccounts(){
		return dao.getAllAccounts();
	}

	@Override
	public double withdraw(Account ob, double amount) {
		return dao.withdraw(ob, amount);
	}

	@Override
	public boolean deposit(Account ob, double amount) {
		return dao.deposit(ob, amount);
	}

	@Override
	public boolean transfer(Account from, Account to, double amount) {
		return dao.transferMoney(from, to, amount);
	}

	@Override
	public double calculateTax(double PCT, double amount) {
		return 0;
	}
}
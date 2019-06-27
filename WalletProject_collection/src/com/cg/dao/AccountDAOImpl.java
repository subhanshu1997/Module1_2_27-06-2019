package com.cg.dao;

import java.util.*;

import com.cg.bean.Account;

public class AccountDAOImpl implements AccountDAO{
static Map<Long,Account> accmap=new HashMap<Long,Account>();
	@Override
	public boolean addAccount(Account ob) {
		accmap.put(ob.getMobile(),ob);
		return true;
	}

	@Override
	public boolean updateAccount(Account ob) {
		accmap.put(ob.getMobile(),ob);
		return true;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		accmap.remove(ob.getMobile());
		return true;
	}

	@Override
	public Account findAccount(Long mobileno) {
		return accmap.get(mobileno);
	}

	@Override
	public Map<Long, Account> printAllAccounts() {
		Collection<Account> vc=accmap.values();
		List<Account> acclist=new ArrayList<Account>(vc);
		Collections.sort(acclist);
		for(Account o:acclist)
		{
			System.out.println(o);
			//service.printStatement
		}
		return accmap;
	}
	public Map<Long, Account> getAllAccounts() {
		Collection<Account> vc=accmap.values();
		List<Account> acclist=new ArrayList<Account>(vc);
		Collections.sort(acclist);
		return accmap;
	}

	@Override
	public boolean transferMoney(Account from, Account to,double amount) {
		double new_balance=from.getBalance()-amount;
		if(new_balance<1000.00) {
			new_balance=from.getBalance();
			System.out.println("Insufficient Balance");
			return false;
		}
			from.setBalance(new_balance);
			to.setBalance(to.getBalance()+amount);
			accmap.put(from.getMobile(),from);
			accmap.put(to.getMobile(),to);
			System.out.println("Money Transferred");
		return true;
	}
	@Override
	public double withdraw(Account ob, double amount) {
		// TODO Auto-generated method stub
		double new_balance=ob.getBalance()-amount;
		if(new_balance<1000.00) {
			new_balance=ob.getBalance();
			System.out.println("Insufficient Balance");
		}
		ob.setBalance(new_balance);
		System.out.println("Your new balance is "+new_balance);
		accmap.put(ob.getMobile(),ob);
		return accmap.get(ob.getMobile()).getBalance();
	}
	public boolean deposit(Account ob,double amount) {
		ob.setBalance(ob.getBalance()+amount);
		System.out.println("Your new balance is "+ob.getBalance());
		accmap.put(ob.getMobile(),ob);
		return true;	
	}	

	
}

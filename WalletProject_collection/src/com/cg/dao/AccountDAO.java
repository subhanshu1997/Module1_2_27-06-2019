package com.cg.dao;
import java.util.Map;
import com.cg.bean.*;
public interface AccountDAO {
public boolean addAccount(Account ob);
public boolean updateAccount(Account ob);
public boolean deleteAccount(Account ob);
public Account findAccount(Long mobileno);
public Map<Long,Account> printAllAccounts();
public double withdraw(Account ob, double amount);
public boolean deposit(Account ob,double amount);
public boolean transferMoney(Account from,Account to,double amount);
public Map<Long, Account> getAllAccounts();

}

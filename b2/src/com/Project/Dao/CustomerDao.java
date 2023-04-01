package com.Project.Dao;

import java.util.List;

import com.Project.Exceptions.CustomerException;
import com.Project.Exceptions.TransactionException;
import com.Project.Model.Customer;
import com.Project.Model.Transaction;

public interface CustomerDao {

    //• Login using his/her email and password
    public boolean CustomerLogin(String Username,int password) throws CustomerException;
    
	public String FindName(String Username,int password) throws CustomerException;
	
	public int TranforMoney(String senderUsername,String ReceiverUsername,int Amount) throws CustomerException;
	
	public String ReciverUsername(int id)throws CustomerException;
	
	public int BalanceCheck(String username) throws CustomerException;
	
	public int SubSenderMoney(int Amount,String Username)throws CustomerException;
	
	public int AddReciverAmount(int Amount,String username) throws CustomerException;
	
	public List<Transaction> CheckTransactionHistory(String username)throws TransactionException;
	
	
	
}

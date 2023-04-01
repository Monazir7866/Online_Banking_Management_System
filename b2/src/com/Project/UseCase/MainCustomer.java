package com.Project.UseCase;

import java.util.List;
import java.util.Scanner;

import com.Project.Custom.consolecolor;
import com.Project.Dao.CustomerDao;
import com.Project.Dao.CustomerDaoImpl;
import com.Project.Exceptions.CustomerException;
import com.Project.Exceptions.TransactionException;
import com.Project.Model.Transaction;

public class MainCustomer {
	private String username;
	private int password;
	private String name;

	public String getUsername() {
		return username;
	}

	public int getPassword() {
		return password;
	}

	CustomerDao s = new CustomerDaoImpl();

	public boolean LoginCheckCustomer() throws CustomerException {
		boolean con1 = false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Email" + consolecolor.RESET);
			String Username = sc.next();
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Password" + consolecolor.RESET);
			int Password = sc.nextInt();
			boolean p = s.CustomerLogin(Username, Password);
			if (p == true) {
				this.username = Username;
				this.password = Password;
				this.name = s.FindName(Username, Password);
				System.out.println(consolecolor.PURPLE_BOLD + "Login Sucessfully" + consolecolor.RESET);
				con1 = true;
				break;
			} else {
				System.out.println(consolecolor.RED + "Wrong email or Password" + consolecolor.RESET);
			}
		}

		return con1;
	}

	public int CustomerWorkType() {
		Scanner sc = new Scanner(System.in);
//		System.out.println(consolecolor.BLACK_BACKGROUND);
		System.out.println(
				consolecolor.GREEN_BOLD +consolecolor.BLACK_BACKGROUND+ "+-----------------------------------------------------------+\r\n"
						+ "|                     ENTER YOUR NUMBER                     |\r\n"
						+ "+-----------------------------------------------------------+\r\n"
						+ "|                                               	    |\r\n"
						+ "| 1.Transfer the money                                      |\r\n"
						+ "| 2.Update Your Credential                                  |\r\n"
						+ "| 3.Open saving/loan account                                |\r\n"
						+ "| 4.Deposite Money                                          |\r\n"
						+ "| 5.Transaction history                                     |\r\n"
						+ "| 6.Delete Your Acount                                      |\r\n"
						+ "| 7. Exit  				   	           |\r\n"
						+ "+-----------------------------------------------------------+" + consolecolor.RESET);
		System.out.println(consolecolor.CYAN+"Enter Number according To Your Work" + consolecolor.RESET);
		int accWork = sc.nextInt();
		return accWork;
	}

	public void SenderToMoney() throws CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW_BOLD +"Enter AccountNo"+consolecolor.RESET);
		int id = sc.nextInt();
		String reciverUsername = s.ReciverUsername(id);
		if (reciverUsername == null) {
			System.out.println(consolecolor.RED+"Enter Correcet AccountNo or this person may have any account"+consolecolor.RESET);
			return;
		}
		System.out.println(consolecolor.YELLOW_BOLD +"Enter Amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		int AmountCheck = s.BalanceCheck(this.username);
		if (AmountCheck < Amount) {
			System.out.println(consolecolor.CYAN+"=--==-=-=-=-===-/ Insufficient Balance /-=-=-=-=-=-=-=-="+consolecolor.RESET);
			return;
		}
		int i = s.TranforMoney(this.username, reciverUsername, Amount);
		if (i == 1) {
			System.out
					.println(consolecolor.PURPLE_BOLD+"/=-=-=-=-=-=-=-=-/ Transfer Money Successfully /-=-=-=-=-=-=-=-=-=/"+consolecolor.RESET);
			int st = s.SubSenderMoney(Amount, this.username);
			int rt = s.AddReciverAmount(Amount, reciverUsername);
			if (st == 1 && rt == 1) {
				System.out.println(consolecolor.LIGHT_GREEN+"Process completed......................"+consolecolor.RESET);
			}

		} else {
			System.out.println(consolecolor.CYAN+"No Money Sent"+consolecolor.RESET);
		}

	}
//	public void addCustomer() throws  CustomerException {
//		Scanner sc = new Scanner(System.in);
//		System.out.println(consolecolor.YELLOW+"Enter Customer name"+consolecolor.RESET);
//		String name = sc.nextLine();
//		System.out.println(consolecolor.YELLOW+"Enter Customer username"+consolecolor.RESET);
//		String username = sc.nextLine();
//		System.out.println(consolecolor.YELLOW+"Enter Customer Password"+consolecolor.RESET);
//		int Password = sc.nextInt();
//		System.out.println(consolecolor.YELLOW+"Enter Customer Account No"+consolecolor.RESET);
//		int AccountNo = sc.nextInt();
//		System.out.println(consolecolor.YELLOW+"Enter Customer amount"+consolecolor.RESET);
//		int Amount = sc.nextInt();
//		
//		int p = dao.AddCustomer(name, username, Password, AccountNo, Amount);
//		if (p == 1) {
//			System.out.println(
//					consolecolor.GREEN_BOLD+ "Customer Data Inserted.." + consolecolor.RESET);
//		} else {
//			System.out.println(consolecolor.RED+"Wrong Information"+consolecolor.RESET);
//		}
//	}
	public void transactionhistory () throws TransactionException {
	List<Transaction> list=s.CheckTransactionHistory(this.username);
	list.forEach(s->System.out.println(consolecolor.PURPLE_BOLD+s+consolecolor.RESET));
	}

}

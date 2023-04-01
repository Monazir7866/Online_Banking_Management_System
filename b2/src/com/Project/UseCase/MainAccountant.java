package com.Project.UseCase;



import java.util.List;
import java.util.Scanner;

import com.Project.Custom.consolecolor;
import com.Project.Dao.AccountantDao;
import com.Project.Dao.AccountantDaoImpl;
import com.Project.Exceptions.AccountantException;
import com.Project.Exceptions.CustomerException;
import com.Project.Exceptions.TransactionException;
import com.Project.Model.Customer;
import com.Project.Model.Transaction;

public class MainAccountant {

	AccountantDao dao = new AccountantDaoImpl();
	public int firstPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.BLACK_BACKGROUND);
		System.out.println(consolecolor.YELLOW_BOLD + "+---------------------------+" + "\n"
				   + "| 1. Login As Accountant    |" + "\n"
				   + "| 2. Login As Customer      |" + "\n"
				   + "| 3. Exit                   |" + "\n"
				   + "+---------------------------+" + consolecolor.RESET);
	
		System.out.println("Choose Number According to your position"+consolecolor.RESET);
		int n = sc.nextInt();
		return n;

	}

	public boolean Logincheck() throws AccountantException {
		boolean confirmation = false;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(consolecolor.BLACK_BACKGROUND);
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your email" + consolecolor.RESET);
			String HODEMAIL = sc.next();
			System.out.print(consolecolor.BLACK_BACKGROUND);
			System.out.println(consolecolor.YELLOW_BOLD + "enter Your Password" + consolecolor.RESET);
			int HODPASSWORD = sc.nextInt();
			boolean flag = dao.AccountantLogin(HODEMAIL, HODPASSWORD);
			
			if (flag == true) {
				System.out.println(consolecolor.GREEN_BOLD+ "Login Sucessfully" + consolecolor.RESET);
				confirmation = true;
				break;
			} else {
				System.out.println(consolecolor.RED + "Wrong Email or Password" + consolecolor.RESET);
			}
		}

		return confirmation;
	}

	public int AccoutentWorkType() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(consolecolor.BLACK_BACKGROUND);
		System.out.println(consolecolor.BLUE_BOLD+"+-------------------------------------------------------+\r\n"
				+ "|  ENTER YOUR NUMBER                             	|\r\n"
				+ "+------------------------------------------------------+|\r\n"
				+ "|                                               	|\r\n"
				+ "| 1.Add new account                      		|\r\n"
				+ "| 2.UpdateExistingCustomer account                      |\r\n"
				+ "| 3.Remove the account by using account number          |\r\n"
				+ "| 4.Viewing particular account details account number   |\r\n"
				+ "| 5.Viewing all the account details          		|\r\n"
				+ "| 6.Taking care of deposit and withdrawal operations 	|\r\n"
				+ "| 7.Exit                                                |\r\n"
				+ "+-------------------------------------------------------+" + consolecolor.RESET);
		System.out.println("Enter Number according To Your Work");
		int accWork = sc.nextInt();
		return accWork;
	}

	public void addCustomer() throws  CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW+"Enter Customer name"+consolecolor.RESET);
		String name = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"Enter Customer Email"+consolecolor.RESET);
		String username = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"Enter Customer Password"+consolecolor.RESET);
		int Password = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"Enter Customer Account No"+consolecolor.RESET);
		int AccountNo = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"Enter Customer Amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		
		int p = dao.AddCustomer(name, username, Password, AccountNo, Amount);
		if (p == 1) {
			System.out.println(
					consolecolor.GREEN_BOLD+ "Customer Data Inserted.." + consolecolor.RESET);
		} else {
			System.out.println(consolecolor.RED+"Wrong Information"+consolecolor.RESET);
		}
	}
// scanner problem
	public void UpdateExistingCustomer() throws  CustomerException {
		Scanner sc = new Scanner(System.in);
		System.out.println(consolecolor.YELLOW+"Enter Customer name"+consolecolor.RESET);
		String name = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"Enter Customer email"+consolecolor.RESET);
		String email = sc.nextLine();
		System.out.println(consolecolor.YELLOW+"Enter Customer Password"+consolecolor.RESET);
		int Password = sc.nextInt();
		
		System.out.println(consolecolor.YELLOW+"Enter Customer amount"+consolecolor.RESET);
		int Amount = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"Enter Customer Account No"+consolecolor.RESET);
		int AccountNo = sc.nextInt();
		System.out.println(consolecolor.YELLOW+"Enter Customer id"+consolecolor.RESET);
		int Customerid = sc.nextInt();
		sc.nextLine();
		int p = dao.UpdateExistingCustomer(name, email, Password,AccountNo,Amount,Customerid);
		if (p == 1) {
			System.out.println(
					consolecolor.PURPLE_BOLD + "Update Successfully" + consolecolor.RESET);
		} else {
			System.out.println(consolecolor.RED+"Wrong Information"+consolecolor.RESET);
		}
		
	}
	public void RemoveCustomerAccNo() throws CustomerException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account No");
		int AccountNo = sc.nextInt();
		int i=dao.RemoveCustomer(AccountNo);
		if(i==1) {
			System.out.println(consolecolor.RED+"Account NO=>("+consolecolor.RESET+consolecolor.RED+AccountNo+") is Successfully Deleted"+consolecolor.RESET);
		}
		else {
			System.out.println(consolecolor.RED+"=-=-=-=-=-=-=-=-=-Enter Correct Account No -=--=-=-=-=-=-=-="+consolecolor.RESET);
		}
	}
	public void VeiwParticularDetal() throws CustomerException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account No");
		int AccountNo = sc.nextInt();
		int i=dao.VeiwParticularAccount(AccountNo);
		if(i==1) {
			System.out.println(consolecolor.GREEN_BACKGROUND+consolecolor.PURPLE_BOLD+"=-=-=-=-=-=-Print customer  "+AccountNo+" detail-=-=-=-=-=-=-="+consolecolor.RESET);
		}
		else {
			System.out.println(consolecolor.ROSY_PINK+"Enter Correct Account No"+consolecolor.RESET);
		}
	}
	public void AllCustomerDetail() throws CustomerException {
		List<Customer> detail=dao.AllCustomerDetail();
		detail.forEach(s->System.out.println(consolecolor.GREEN+s+consolecolor.RESET));
		System.out.println(consolecolor.LIGHT_PINK+"=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="+consolecolor.RESET);
	}
	public void AllTransaction() throws TransactionException {
		List<Transaction> tDetail=dao.TransactionList();
		tDetail.forEach(s->System.out.println(consolecolor.BLUE+s+consolecolor.RESET));
	}
}

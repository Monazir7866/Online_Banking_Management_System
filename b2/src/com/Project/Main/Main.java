package com.Project.Main;

import java.util.Scanner;

import com.Project.Exceptions.AccountantException;
import com.Project.Exceptions.CustomerException;
import com.Project.Exceptions.TransactionException;
import com.Project.UseCase.MainAccountant;
import com.Project.UseCase.MainCustomer;

public class Main {

	public static void main(String[] args) throws AccountantException, CustomerException, TransactionException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		MainAccountant dao = new MainAccountant();
		MainCustomer cdao = new MainCustomer();
		while (true) {
			int choose = dao.firstPrint();
			if (choose == 1) {
				boolean flag = dao.Logincheck();
				if (flag == true) {
					while (true) {
						int ac_no = dao.AccoutentWorkType();
						if (ac_no == 1) {
							dao.addCustomer();
						} else if (ac_no == 2) {
							dao.UpdateExistingCustomer();
						} else if (ac_no == 3) {
							dao.RemoveCustomerAccNo();
						} else if (ac_no == 4) {
							dao.VeiwParticularDetal();
						} else if (ac_no == 5) {
							dao.AllCustomerDetail();
						} else if (ac_no == 6) {
							dao.AllTransaction();
						} else {
							break;
						}

					}
				}
			} else if (choose == 2) {
				boolean flag = cdao.LoginCheckCustomer();
				if (flag == true) {
					while (true) {
						int cw = cdao.CustomerWorkType();
						if (cw == 1) {
							cdao.SenderToMoney();
						} else if (cw == 2) {
							dao.UpdateExistingCustomer();
						} else if (cw == 3) {
							dao.addCustomer();
						}else if (cw == 4) {
							cdao.SenderToMoney();
						}else if (cw == 5) {
							cdao.transactionhistory();
						}else if (cw == 6) {
							dao.RemoveCustomerAccNo();
						}
						
						else {
							break;
						}
					}
				}
			} else if (choose == 3) {
				break;
			}
		}

	}

	}




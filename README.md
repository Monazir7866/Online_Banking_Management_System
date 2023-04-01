# eager-porter-575
Online Banking System
This is a simple online banking system that allows customers to perform transactions, manage their accounts, and apply for loans. Administrators can also manage customer accounts and view transaction reports.

Problem Description
The objective of this project is to maintain the accounts like saving accounts, withdrawing, depositing money and applying for loans to the user. Bank provides account numbers to the customer for dealing transactions in the bank. At first, a user registers himself/herself as a customer. After that account can be opened. A customer can open more than one account.

Users of this project
Administrator
Customer
Roles of Accountant:
Login using his/her username and password
View information about all customers
Viewing particular customer details by customer_id
View information about all accounts
Viewing particular account details by account_number
Change the status of account from active to inoperative if no trsnaction for last 24 months and vice versa
view all inoperative accounts
view all closed accounts
Can see the transaction report for a day range for all accounts.
See all high magnitude transaction for a day i.e. only those transaction in which more than 49999 is transferred
Logout his account
Roles of the Customer:
Can register with new account using information customer_id, name, mobile, address, username, password
Login his account
update details like name, mobile, address (but not username)
can change password
Sign in to account
Open account saving/loan account
Deposite & withdraw money to saving/loan account
Transfer the money from his account to another account (using account number only)
Checking the transaction history for a date range
close his saving/loan account
Logout his account
delete the account
Bean Class
Transaction:

private int Transaction_Id;
private String SenderName;
private String RecieverName;
private int Balance;
private String date;
Accountant:

private int Acc_Id;

private String name;

private String email;

private String password;


Customer:

private int Customer_Id;
private String name;
private String email;
private int password;
private int AccountNo;
private int Balance;
create Table Accountant(AccountNo int primary key Auto_increment, Name varchar(30), email varchar(30) unique, password int unique);
create Table Customer(Customer_Id int primary key Auto_increment, name varchar(30) , email varchar(30) unique, password int unique, AccountNo int unique, Balance int unique);
create table transaction(Transaction_Id int primary key Auto_increment, Sender varchar(40), Receiver varchar(40), Balance int , date varchar(60));
Dummy Image
dummy image

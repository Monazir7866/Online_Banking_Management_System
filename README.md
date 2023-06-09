# Online_Banking_Management_System

![logo](https://user-images.githubusercontent.com/25690078/229357682-e00ee5e8-5d8f-45e2-a45f-291395c36813.png)

 

# Online Banking System
**This is a simple online banking system that allows customers to perform transactions, manage their accounts, and apply for loans. Administrators can also manage customer accounts and view transaction reports.**

## Problem Description
**The objective of this project is to maintain the accounts like saving accounts, withdrawing, depositing money and applying for loans to the user. Bank provides account numbers to the customer for dealing transactions in the bank. At first, a user registers himself/herself as a customer. After that account can be opened. A customer can open more than one account.**

## Users of this project
**1.Administrator**
**2.Customer**

## Roles of Accountant:
**1.Login using his/her username and password
2.View information about all accounts
3.Viewing particular account details by account_number
4.Can see the transaction report for a day range for all accounts.
5.Logout his account

## Roles of the Customer:
**Can register with new account using information customer_id, name, mobile, address, username, password
Login his account
update details like name, email,accNo.
Open account saving/loan account
Transfer the money from his account to another account (using account number only)
Checking the transaction history for a date range
close his saving/loan account
Logout his account
delete the account




## SQL DATABASE

*create Table Accountant(
AccountNo int primary key Auto_increment,
Name varchar(30),
email varchar(30) unique, 
password int unique);*

*create Table Customer(
Customer_Id int primary key Auto_increment, 
name varchar(30) ,
email varchar(30) unique,
password int unique,
AccountNo int unique,
Balance int unique);*

*create table transaction(
Transaction_Id int primary key Auto_increment,
Sender varchar(40), 
Receiver varchar(40),
Balance int ,
date varchar(60));*



# ER_DIAGRAM

![ER](https://user-images.githubusercontent.com/25690078/229357672-cdf97575-a768-4ef3-8676-af015c71db97.png)


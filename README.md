Banking Application - Java Spring Boot Mini Project
This is a mini banking application developed using Java Spring Boot that simulates the core functionalities of a real-world banking system.

Features:

Bank Account Opening:
Users can open a new bank account by providing required details including:
Aadhar Number
PAN Number
Email
First and Last Name
Phone Number
The application performs strict validations on the format and correctness of all inputs (Aadhar, PAN, Email).
Upon successful validation, the system generates:
A unique Customer ID
A Temporary Password
Account Number and Debit Card Details
User Authentication & Account Access:
Users can log in using the temporary password (with an option to change it).
Secure access to personal banking dashboard via RESTful APIs.
Transactions:
Deposit and Withdrawal APIs allow users to manage their account balance.
All transactions are securely handled and logged.
Investment Portfolio:
Users can manage and view their investments across:
Public Provident Fund (PPF)
Fixed Deposit (FD)
Recurring Deposit (RD)
Mutual Funds
Tech Stack:

Java 8
Spring Boot
Spring Data JPA
Hibernate
MySQL (or any RDBMS)
REST APIs
Postman (for API testing)
Future Enhancements:

JWT-based authentication
Email/SMS notification on transactions
Admin panel for account approvals
Integration with third-party investment APIs



# BosWebApplication
New Rest Web App
---------------------
Bank Application Working strategies
-----------------------------------
1.FOR OPENING A BANK ACCOUNT: implementing based on rules and regulations
// FName LName 
// PAN Number
// AdharCard Number
// Address 
// Contact Information Email & Phone Numbers
// Customer id - starting from 50001,  bank will provide
// Account Number- minimum 9 digits to 18 digits ,bank will provide based on account type
// Debt Card Number & Credit Card Number 

2.FOR GETTING BANK INFORMATION / LOGIN / TO KNOW BALANCE / TO DEPOSIT / TO UPDATE ANY PERSONAL INFO
// Give Customer id/account number + Banking Password 

3.INVESTMENT PORTIFOLIO : implementing based on rules and regulations
// FD
// RD 
// Mutual Funds
// Demat/Trading
// PPF
// NPS
// other Investments

4.OPERATIONS: only after providing customer id and password
// get blc,get personal info ,get blc,get statement, get cibil score , get credit stmt , get my investments
// add amount ,add documents (forms -required only needed) , add nominee,add sip -everymonth, add amt in investments
// update address , update contact ,update password , sip amt , sip date ,
// any delete operations 
--------------------------------------------------------------------------------------------------------------------------
MODEL classes : 
1.User Registration 
2.UserLogin

Controller Classes : Based on response 
1.POST 	:  user/openAccount + Json Body {req user info}
2.POST  :  user/login
3.GET  	:  user/getBalance
4.GET  	:  user/personalInformation
5.GET  	:  user/getStatement
6.GET  	:  user/ccibil score
7.GET  	:  user/myInvestments

Services
1.BankingUtilService
2.UserRegistrationService

Repositories
1.UserRegistrationRepo


--------------------------------------------------------------------------------------------------------------------------
LogIn
 {
	Customer ID 	: 5210367,
	UserName    	:"Krishna Kumar Nare",
	Account Number  :357193018201,
	Message			:"Login Message"
 }

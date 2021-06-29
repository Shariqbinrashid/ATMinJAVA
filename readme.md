An automated teller machine (ATM) or the automatic banking machine (ABM) is a banking subsystem (subject) that provides bank customers with access to financial transactions in a public space without the need for a cashier, clerk, or bank teller.
There are two roles from which ATM can be used :
-	User/client
-   Technician

Both of actors interaction with ATM is managed with bank manager actor who stores record of both actors, user and technician.
```java
	public List<Accounts> getAccounts(){
		//list of accounts from database
		return Arrays.asList(new Accounts("Shariq","qwerty",10000),
				new Accounts("Yasir","qwerty1",1000),
				new Accounts("Anas","qwerty2",900));
	}
	
	public List<Technician> getTechnicians(){
		//list of technicians from database
		
		return Arrays.asList(new Technician(124431,"qwerty"),
				new Technician(242431,"abc123"),
				new Technician(263118,"qwaszx"));
	}
```
More record can be added as per need. 

In a real world it user operates with ATM card and user personal pin. User enters card and pin to access its account using ATM and perform his or her desired tasks. User can withdraw , deposit funds to his or her account and check balance and transfer funds using ATM. In a real world user use plastic ATM card but I have consider user account name/ID as alternative for user ATM card for a software or console base application. Also in a real world technician interacts with ATM directly but to show similar behavior I have user two options whenever ATM application starts , user and technician login. Technician can add more cash to ATM and also he can repair and do relevant services with ATM. Obviously we can show repair or any other function in a software application, technician can only ass cash to application.	


Class Diagram for only User interaction:

![class diagram](./cd1.jpg)
 
There are three classes, ATM machine class handles ATM functions and is main class of application. It can have zero or many customers which are in Accounts class. User can only be manage by 1 bank actor or manager which keeps record of accounts of clients and validate accounts whenever user interact with ATM machine.
```java
public Accounts selectAccounts(String accountName,String accountPassword){
		for (Accounts account:accounts){
			if(account.isMatching(accountName, accountPassword)){
				System.out.println("Matched, Welcome "+accountName+"Your balance is "+account.balance);
				return account;
			}
		}
		System.out.print("Not Matched");
		return null;
	}
 ```   
Accounts class object is use for interaction of client with ATM. It keeps record of user balance when user interacts with ATM. 


Class diagram with Technician actor:

 ![class diagram](./cd2.jpg)

All classes are same with addition of Technician class. Technician can add more cash to ATM. ATM has pre define amount of cash when application starts, user cant withdraw more cash then available cash in Atm. ATM machine can manage by 1 technician. Bank can have many or more technicains.

Application is built in JAVA with OOP logic and implementation. 
Interaction:
	When program starts there are two options:
*************** ATM *******************
If you are user press 1 , if you are technician press 2

User interaction:
User enter his or her ID and pin to use his or her account.
*************** Welcome to ATM *******************
******  Enter account holder name *******
Shariq
Enter account password
Qwerty
Matched, Welcome Shariq. Your balance is 10000.0
Then menu displays with 6 options.
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

Balance inquiry:
1
Your current balance is : 10000.0

2. Withdraw:
*User cant withdraw cash if cash is not available in bank*


Enter the amount to withdrraw
11000
Sorry !! Your request could not be proceed ... ATM is out of cash

Enter the amount to withdrraw
1000
Successfull withdraw. Your Remaining balance is:  9000.0

*User cannot withdraw cash if amount is not available in his account.*
Enter the amount to withdrraw
4000
You have insufficient balance

3. Deposit:
 Initial balance of Shariq is 10000 
Matched, Welcome Shariq. Your balance is 10000.0
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

3
Enter the amount to deposit
5000
Successfull deposit. Your balance is now:  15000.0



4. Transfer:
*Initial balance of shariq is 10000 and Yasir is 1000, so if Shariq transfer 5000 to Yasir :*
Matched, Welcome Shariq.Your balance is 10000.0
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

4
Enter the name of reciever account
Yasir
Account Found with name,Yasir
Enter the amount to transfer
5000
Successfull Transfer. Your Remaining balance is:  5000.0
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

6
 *************** ATM *******************
If you are user press 1 , if you are technician press 2
1
 *************** Welcome to ATM *******************
******  Enter account holder name *******
Yasir
Enter account password
qwerty1
Matched, Welcome Yasir. Your balance is 6000.0

*Yasir balance becomes 6000 and Shariq becomes 5000.*

Technician interaction:
*Technician can add more cash to atm*
Default available cash in ATM is 10000. User cant withdraw more cash than 9000 , but if technician add more cash he or she can then withdraw more cash.
*Go through of above statement*


*************** ATM *******************
If you are user press 1 , if you are technician press 2
1
 *************** Welcome to ATM *******************
******  Enter account holder name *******
Shariq
Enter account password
qwerty
Matched, Welcome Shariq.Your balance is 10000.0
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

2
Enter the amount to withdrraw
10000
Sorry !! Your request could not be proceed ... ATM is out of cash
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

6
 *************** ATM *******************
If you are user press 1 , if you are technician press 2
2
 *************** ATM Maintanance*******************
******  Enter your ID *******
242431
Enter account password
abc123
Matched, Welcome
 *************** Welcome *******************
 Current ATM cash is 9000.0
 To add cash press 1 , 0 to exit
1
 Enter cash to add to ATM
5000
 Updated ATm cash is 14000.0
 *************** ATM *******************
If you are user press 1 , if you are technician press 2
1
 *************** Welcome to ATM *******************
******  Enter account holder name *******
Shariq
Enter account password
qwerty
Matched, Welcome Shariq.Your balance is 10000.0
Menu :
1.Balance ENquiry
2.Withdrawl
3.Deposit
4.Transfer
5.Exit
6. Use ATM Again with new account

2
Enter the amount to withdrraw
10000
Successfull withdraw. Your Remaining balance is:  0.0

First shariq try to withdraw 10000 which is greater than available cash 9000, so it cant withdraw or withdrawal request was rejected, then technician added more 5000 cash then Shariq withdrawal request was completed.


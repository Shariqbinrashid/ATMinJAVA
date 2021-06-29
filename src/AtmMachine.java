import java.util.Scanner;

class AtmMachine{
	
	
	static Scanner scanner=new Scanner(System.in);
	static String accountHolderName = null;
	static String accountPass=null;
	static int option;
	static double balance=10000;
	
	static BankManager m=new BankManager();
	
	static Technician t=new Technician();
	static int check=0;
	static int check2=0;
	static Accounts customer;
	static Technician tech;
	public static void main(String[] args){

		

		
	
			while(true){
				if (check==0) {
					
					check=1;
					
					System.out.println(" *************** ATM *******************");
					System.out.println("If you are user press 1 , if you are technician press 2");
					Scanner sas=new Scanner(System.in);
					int che=sas.nextInt();	
					
					if(che==2) {
						check=0;
						Scanner sss=new Scanner(System.in);
						System.out.println(" *************** ATM Maintanance*******************");
						
						
						
						System.out.println("******  Enter your ID *******"); // (In physical  Insert Card Option ) 
						Scanner ssss=new Scanner(System.in);
						int ID=ssss.nextInt();
							
						System.out.println("Enter account password");
					
						String Pass=sss.nextLine();
						 tech=m.selectTechnician(ID,Pass);
						 if (tech!=null){
							 System.out.println(" *************** Welcome *******************");
							 System.out.println(" Current ATM cash is "+balance);
							 System.out.println(" To add cash press 1 , 0 to exit");
							 int y=sss.nextInt();
							 
							 if(y==1) {
								 System.out.println(" Enter cash to add to ATM");
								 int by=sss.nextInt();
								 addCash(by);
								 System.out.println(" Updated ATm cash is "+balance);
							 }
							 if(y==0) {
								 check=0;
							 }
						 }
					}
					
					if(che==1) {
						Scanner ss=new Scanner(System.in);
						System.out.println(" *************** Welcome to ATM *******************");
						
						
						
						System.out.println("******  Enter account holder name *******"); // (In physical  Insert Card Option ) 
						
						accountHolderName=new String(ss.nextLine());
							
						System.out.println("Enter account password");
					
						accountPass=new String(ss.nextLine());
						 customer=m.selectAccounts(accountHolderName,accountPass);
					}
					
					 
					 
					 
				}
				
				else {
					if(customer!=null) {
						
						
						System.out.println("Menu :");
						System.out.println("1.Balance ENquiry\n"
								+ "2.Withdrawl\n"
								+ "3.Deposit\n"
								+ "4.Transfer\n"
								+ "5.Exit\n"
								+ "6. Use ATM Again with new account\n");	
						option=scanner.nextInt();
						switch(option){
						case 1:
							System.out.println("Your current balance is : "+customer.checkBalance());
							break;
						case 2:
							System.out.println("Enter the amount to withdrraw");
							double amount=scanner.nextInt();
							if(amount>balance) {
								System.out.println("Sorry !! Your request could not be proceed ... ATM is out of cash");
							}
							else {
								if(amount>customer.getBalance()) {
									System.out.println("You have insufficient balance");
								}
								else {
									double left=customer.withdrawl(amount);
									balance=balance-amount;
									System.out.println("Successfull withdraw. Your Remaining balance is:  "+left);
								}
								
							}
							
							break;
							
						case 3:
							System.out.println("Enter the amount to deposit");
							double amount2=scanner.nextInt();
							
							double n=customer.deposit(amount2);
							balance =balance +amount2;
							System.out.println("Successfull deposit. Your balance is now:  "+n);
							break;
							
						case 4:
							Scanner s=new Scanner(System.in);
							System.out.println("Enter the name of reciever account");
							String name=s.nextLine();
							Accounts customer2=m.selectSingleAccount(name);
							if(m!=null) {
								System.out.println("Enter the amount to transfer");
								double amount22=scanner.nextInt();
								if (amount22>customer.getBalance()) {
										System.out.println("You have insufficient balance");
									}
								else {
									double l=customer2.deposit(amount22);
									double left=customer.withdrawl(amount22);
									System.out.println("Successfull Transfer. Your Remaining balance is:  "+left);
								}
							}
						
							
							
							break;
						case 5:
							System.out.println("Thank you for using our services");
							break;
						case 6:
							check=0;
							break;
						}
						
					}
				}
			}
		}

		
 public static void addCash(int b) {
		balance=balance+b;
	}
}
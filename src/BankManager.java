import java.util.Arrays;
import java.util.List;

class BankManager{
	
	public List<Accounts> accounts=getAccounts();
	
	public List<Technician> Technicians=getTechnicians();
	
	public List<Accounts> getAccounts(){
		//list of accounts from database
		return Arrays.asList(new Accounts("Shariq","qwerty",10000),
				new Accounts("Yasir","qwerty1",1000),
				new Accounts("Anas","qwerty2",900));
	}
	
	public List<Technician> getTechnicians(){
		//list of accounts from database
		
		return Arrays.asList(new Technician(124431,"qwerty"),
				new Technician(242431,"abc123"),
				new Technician(263118,"qwaszx"));
	}
	
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
	
	
	public Accounts selectSingleAccount(String accountName){
		
		for (Accounts account:accounts){
			if(account.isMatching(accountName)){
				System.out.println("Account Found with name,"+accountName);
				return account;
			}
		}
		System.out.println("Not Matched");
		return null;
	}
	
	public Technician selectTechnician(int ID,String accountPassword){
		//System.out.print(accounts);
		for (Technician tech:Technicians){
			if(tech.isMatching(ID, accountPassword)){
				System.out.println("Matched, Welcome");
				return tech;
			}
		}
		System.out.println("Not Matched");
		return null;
	}
	
	
	
}
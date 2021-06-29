import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Accounts {
	String accountName;
	String accountPass;
	double balance;
	public Accounts(String name,String password,double balance){
		this.accountName=Objects.requireNonNull(name);
		this.accountPass=Objects.requireNonNull(password);
		this.balance=balance;
	}
	public boolean isMatching(String name, String encryptedPassword) {
        return Objects.equals(this.accountName, name) 
                    && Objects.equals(this.accountPass, encryptedPassword);
    }
	
	public boolean isMatching(String name) {
        return Objects.equals(this.accountName, name);
    }
	
	public double checkBalance(){
		return this.balance;
	}
	public double withdrawl(double amount){
		this.balance=this.balance-amount;
		return balance;
	}
	
	public double deposit(double amount){
		this.balance=this.balance+amount;
		return balance;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
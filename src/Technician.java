import java.util.Objects;

 class Technician {
	int ID ;
	String accountPass;
	
	public Technician(int iD, String accountPass) {
		
		ID = iD;
		this.accountPass = accountPass;
	}
	
	public Technician() {
		
	}

	public boolean isMatching(int ID ,String Password) {
        return Objects.equals(this.ID, ID) 
                    && Objects.equals(this.accountPass, Password);
    }
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAccountPass() {
		return accountPass;
	}
	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}
	
	
	
	

	
}

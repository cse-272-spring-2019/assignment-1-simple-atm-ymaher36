package package_ATM;
public class History {
	private String Type;
	
	private double Amount;
	
	public void set(String getType, double getAmount) {
		Type = getType;
		Amount = getAmount;
	}

	public StringBuilder get() {
		StringBuilder a = new StringBuilder().append(Type ).append(Amount);
		return a;
	}

}

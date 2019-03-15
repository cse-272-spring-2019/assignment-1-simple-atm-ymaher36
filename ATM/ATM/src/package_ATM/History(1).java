package package_ATM;

public class History {
	private String Type;
	private double Amount;

	public History() {
		
		
	}
	public void set(String getType, double getAmount) {
		Type = getType;
		Amount = getAmount;

	}

	public void get() {
		System.out.println(Type + " " + Amount);
	}

}

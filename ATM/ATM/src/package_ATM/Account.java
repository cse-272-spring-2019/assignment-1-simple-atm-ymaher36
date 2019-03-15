package package_ATM;

public class Account {
	private String Name;
	private int Password;
	private double balance;
	History[] a = new History[5];
	private int i;
	private int j;

	public void setI() {
		i = 0;
		j = 0;

	}

	public Account(double initialBalance) {
		if (initialBalance > 0.0)
			balance = initialBalance;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPassword(int password) {
		Password = password;
	}

	public void deposit(double amount) {
		balance = balance + amount;
		a[i].set("Deposit", amount);
		i++;
		shift();
	}

	public void withdrawal(double amount) {
		if (amount > balance) {
			System.out.println("Invalide amount");
			return;
		} else {
			balance = balance - amount;
			a[i].set("Withdraw", amount);
			i++;
			shift();
		}

	}

	public double getBalance() {
		return balance;
	}

	public void prev() {
		--j;
		a[j].get();

	}
	public void next() {
		++j;
		a[j].get();

	}
	public void shift() {
		for (int j = 0; j < 5; j++) {
			a[j] = a[j + 1];
		}
	}
}

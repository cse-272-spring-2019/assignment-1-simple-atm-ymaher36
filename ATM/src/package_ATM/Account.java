package package_ATM;

public class Account {
	private double balance = 0.0;

	String[] history = new String[5];
	int i = 0;
	int j;

	public boolean withdrawal(double y) {
		if (y > balance || y < 0)
			return false;
		balance -= y;
		if (i > 4) {
			i = 4;
			for (int temp = 4; temp > 0; temp--)
				history[temp - 1] = history[temp];
		}

		history[i++] = "Withdraw " + y;
		j = i;
		return true;

	}

	public void deposit(double num1) {
		balance += num1;
		if (i > 4) {
			i = 4;
			for (int temp = 4; temp > 0; temp--)
				history[temp - 1] = history[temp];
		}
		history[i++] = "Deposit " + num1;
		j = i;
	}

	public double getBalance() {
		return balance;
	}

	public String prev() {
		--j;
		if (j >= 0) {
			return history[j];
		} else {
			j=0;
			return new String("No Previous Transaction ");
		}
	}

	public String next() {
		++j;
		if(j>4)
			j=4;
		if (j <= 4) {
			return history[j];
		} else {
			j=4;
			return new String("No Further Transaction ");
		}
	}

}

package package_ATM;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double amount = 0;
		Account id1 = new Account(amount);
		id1.setName("Youssef ElZawawy");
		id1.setPassword(5892);
		History a[] = new History[5];
		id1.setI();
		for (int i = 0; i < a.length; i++) {
			a[i] = new History();
		}
		char i = 0;

		while (i != 6) {
			System.out.println("choose the method you would like to perform");
			System.out.println("1: account Withdrawal");
			System.out.println("2: account Deposit");
			System.out.println("3: account Balance");

			i = (char) in.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter the amount you want to credit");
				amount = in.nextDouble();
				id1.withdrawal(amount);
				System.out.println("Your Transaction was done succesfully");
				break;
			case 2:
				System.out.println("Enter the amount you want to debit");
				amount = in.nextDouble();
				id1.deposit(amount);
				System.out.println("Your Transaction was done succesfully");
				break;
			case 3:
				System.out.println("your balance is : " + id1.getBalance());
				break;
			case 4:
				id1.prev();
			case 5:
				id1.next();
			}
			i = (char) in.nextInt();
		}
		in.close();
	}
}
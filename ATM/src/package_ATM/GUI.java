package package_ATM;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GUI extends Application {
	private Stage window;
	private Scene login, menu, draw, deposit, balance;
	private Account id1 = new Account();
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("ATM Machine");

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(8);
		layout.setHgap(10);
		Label passLabel = new Label("PIN:");
		GridPane.setConstraints(passLabel, 0, 1);

		PasswordField passInput = new PasswordField();
		GridPane.setConstraints(passInput, 1, 1);

		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);

		layout.getChildren().addAll(passLabel, passInput, loginButton);
		loginButton.setOnAction(e -> {
			if (check(passInput.getText()))
				window.setScene(menu);
			else
				Alert.display("Invalid PIN");

		});

		login = new Scene(layout, 400, 200);

		// ______________________________________________________________________________________________________

		Label label1 = new Label("Please choose the method you would like to perform!");
		Button button1 = new Button("Account Withdrawal");
		Button button2 = new Button("Account Deposit");
		Button button3 = new Button("History of Transactions");
		Button button6 = new Button("Exit");

		VBox layout2 = new VBox(50);
		layout2.getChildren().addAll(button1,  button3);
		layout2.setAlignment(Pos.CENTER_LEFT);

		VBox layout3 = new VBox(50);
		layout3.getChildren().addAll(button2,  button6);
		layout3.setAlignment(Pos.CENTER_RIGHT);

		VBox layout4 = new VBox(50);
		layout4.getChildren().addAll(label1);
		layout4.setAlignment(Pos.CENTER);

		BorderPane main = new BorderPane();
		main.setTop(layout4);
		main.setRight(layout2);
		main.setLeft(layout3);

		button1.setOnAction(e -> window.setScene(draw));
		button2.setOnAction(e -> window.setScene(deposit));
		button3.setOnAction(e -> window.setScene(balance));
		button6.setOnAction(e -> window.close());

		menu = new Scene(main, 500, 600);

		// ______________________________________________________________________________________________

		GridPane withdraw = new GridPane();
		withdraw.setPadding(new Insets(10, 10, 10, 10));
		withdraw.setVgap(8);
		withdraw.setHgap(10);
		Label drawLabel1 = new Label("Enter Amount");
		GridPane.setConstraints(drawLabel1, 0, 1);

		TextField drawInput = new TextField();
		GridPane.setConstraints(drawInput, 2, 1);

		Button drawButton = new Button("Submit");
		GridPane.setConstraints(drawButton, 1, 2);

		Button back1 = new Button("Back To Main Menu");
		GridPane.setConstraints(back1, 2, 2);

		Label drawLabel2 = new Label();
		GridPane.setConstraints(drawLabel2, 2, 4);

		drawButton.setOnAction(e -> {
			// double y = Double.parseDouble(drawInput.getText());
			if (id1.withdrawal(Double.parseDouble(drawInput.getText())) && Double.parseDouble(drawInput.getText()) > 0)
				drawLabel2.setText("Your Transaction was done succesfully");
			else
				drawLabel2.setText("Invalid Amount");

		});

		back1.setOnAction(e ->

		{
			window.setScene(menu);
		});

		withdraw.getChildren().addAll(drawLabel1, drawInput, drawButton, back1, drawLabel2);

		draw = new Scene(withdraw, 500, 200);

		// ______________________________________________________________________________________________

		GridPane depositLayout = new GridPane();
		depositLayout.setPadding(new Insets(10, 10, 10, 10));
		depositLayout.setVgap(8);
		depositLayout.setHgap(10);

		Label depLabel = new Label("Enter Amount");
		GridPane.setConstraints(depLabel, 0, 1);

		TextField depInput = new TextField("");
		GridPane.setConstraints(depInput, 2, 1);

		Button depButton = new Button("Submit");
		GridPane.setConstraints(depButton, 1, 2);

		Button back2 = new Button("Back To Main Menu");
		GridPane.setConstraints(back2, 2, 2);

		Label depLabel2 = new Label();
		GridPane.setConstraints(depLabel2, 2, 4);

		depButton.setOnAction(e -> {

			if (Double.parseDouble(depInput.getText()) > 0) {
				id1.deposit(Double.parseDouble(depInput.getText()));
				depLabel2.setText("Your Transaction was done succesfully");

			} else
				depLabel2.setText("Invalid Amount");

		});
		back2.setOnAction(e ->

		{
			window.setScene(menu);
		});

		depositLayout.getChildren().addAll(depLabel, depInput, depButton, back2, depLabel2);
		deposit = new Scene(depositLayout, 500, 200);

		// ______________________________________________________________________________________________________

		GridPane balanceLayout = new GridPane();
		balanceLayout.setPadding(new Insets(10, 10, 10, 10));
		balanceLayout.setVgap(8);
		balanceLayout.setHgap(10);
		
		Button balanceButton = new Button("Current Balance");
		GridPane.setConstraints(balanceButton, 0, 1);

		Button nextButton = new Button("Next Transaction");
		GridPane.setConstraints(nextButton, 1, 1);

		Button prevButton = new Button("Previous Transaction");
		GridPane.setConstraints(prevButton, 2, 1);

		Label Label1 = new Label();
		GridPane.setConstraints(Label1, 0, 3);
		
		Button back3 = new Button("Back To Main Menu");
		GridPane.setConstraints(back3, 3, 1);
		
		balanceButton.setOnAction(e ->{
			Label1.setText("Your Current Balance is : " + id1.getBalance());
		});

		nextButton.setOnAction(e ->{
			Label1.setText(id1.next());
		});
		prevButton.setOnAction(e ->{
			Label1.setText(id1.prev());
		});
		
		back3.setOnAction(e ->{
			window.setScene(menu);
		});

		
		balanceLayout.getChildren().addAll(balanceButton,nextButton,prevButton,Label1,back3);
		balance = new Scene(balanceLayout, 800, 400);

		
		primaryStage.setScene(login);
		primaryStage.show();
	}

	private boolean check(String a) {

		if (a.equals("5892"))
			return true;
		else
			return false;
	}
}

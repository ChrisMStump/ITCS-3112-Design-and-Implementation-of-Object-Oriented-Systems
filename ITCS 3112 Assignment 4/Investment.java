import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Investment extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	GridPane investPane = new GridPane();
    	
    	//Change color of pane to Papaya Whip
    	investPane.setStyle("-fx-background-color: papayawhip");
    	
    	//Position investPane for center
    	investPane.setAlignment(Pos.CENTER);
    	
    	//Set spaces between controls
    	investPane.setVgap(10);
    	investPane.setHgap(5);
    	
    	//Create, set and adjust text fields
    	TextField tfInvestAmount = new TextField();
    	TextField tfNumberOfYears = new TextField();
    	TextField tfAnnualInterestRate = new TextField();
    	TextField tfFutureValue = new TextField();
    	
    	tfFutureValue.setEditable(false);
    	
    	tfInvestAmount.setAlignment(Pos.BOTTOM_RIGHT);
    	tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
    	tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
    	tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
    	
    	//Change color of text fields to salmon
    	tfInvestAmount.setStyle("-fx-background-color: salmon");
    	tfNumberOfYears.setStyle("-fx-background-color: salmon");
    	tfAnnualInterestRate.setStyle("-fx-background-color: salmon");
    	tfFutureValue.setStyle("-fx-background-color: salmon");
    	
    	//Create the labels for the text fields
    	Label lbInvestAmount = new Label("Invest Amount:");
    	Label lbNumberOfYears = new Label("Number Of Years:");
    	Label lbAnnualInterestRate = new Label("Annual Interest Rate:");
    	Label lbFutureValue = new Label("Future Value:");
    	
    	//Set label font to Papyrus
    	lbInvestAmount.setFont(Font.font("Papyrus", FontWeight.NORMAL, 15));
    	lbNumberOfYears.setFont(Font.font("Papyrus", FontWeight.NORMAL, 15));
    	lbAnnualInterestRate.setFont(Font.font("Papyrus", FontWeight.NORMAL, 15));
    	lbFutureValue.setFont(Font.font("Papyrus", FontWeight.NORMAL, 15));
    	
    	Button btCalc = new Button("Calculate");
    	
    	//Add the labels, textfields and button to investPane;
    	investPane.add(lbInvestAmount, 0, 0);
    	investPane.add(tfInvestAmount, 1, 0);

    	investPane.add(lbNumberOfYears, 0, 1);
    	investPane.add(tfNumberOfYears, 1, 1);

    	investPane.add(lbAnnualInterestRate, 0, 2);
    	investPane.add(tfAnnualInterestRate, 1, 2);

    	investPane.add(lbFutureValue, 0, 3);
    	investPane.add(tfFutureValue, 1, 3);
    	
    	investPane.add(btCalc, 1, 4);
    	
    	btCalc.setOnAction(e -> {
    		double investmentAmount = Double.parseDouble(tfInvestAmount.getText());
            double years = Double.parseDouble(tfNumberOfYears.getText());
            double monthInterestRate = Double.parseDouble(tfAnnualInterestRate.getText()) / 100;

            double futureValue = investmentAmount * Math.pow(1 + monthInterestRate, years * 12);
            tfFutureValue.setText(String.format("$%.2f", futureValue));
    	});
    	
    	Scene investScene = new Scene(investPane, 400, 300);
    	
    	primaryStage.setTitle("Future Value");
    	primaryStage.setScene(investScene);
    	
    	primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
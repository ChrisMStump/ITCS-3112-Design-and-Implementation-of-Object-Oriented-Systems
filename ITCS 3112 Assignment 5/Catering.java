import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Catering extends Application {
	public void start(Stage primaryStage) {
		GridPane mainPane = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setHgap(20);
		mainPane.setVgap(20);
		
		mainPane.setStyle("-fx-background-color: papayawhip");
		
		Font ckFont = Font.font("Arial", FontWeight.BOLD, 16);
		
		//Create the text fields for the user to enter data
		TextField customerName = new TextField();
		TextField tfphoneNum = new TextField();
		TextField tfnumGuest = new TextField();
		
		//Create labels for each of the fields
		Label nameLabel = new Label("Name: ");
		Label phoneLabel = new Label("Phone Number: ");
		Label guestLabel = new Label("Number of Guests: ");
		Label entreeLabel = new Label("Choose Your Entree: ");
		Label sidesLabel = new Label("Choose Up To Two Sides: ");
		Label desertLabel = new Label("Choose Your Desert: ");
		
		//Set fonts for all the labels
		nameLabel.setFont(ckFont);
		phoneLabel.setFont(ckFont);
		guestLabel.setFont(ckFont);
		entreeLabel.setFont(ckFont);
		sidesLabel.setFont(ckFont);
		desertLabel.setFont(ckFont);
		
		//Create the entrees.
		ComboBox <String> cbEntree = new ComboBox<>();
		cbEntree.setEditable(false);
		cbEntree.setPromptText("Choose an Entree");
		cbEntree.getItems().addAll("Large Greek Salad", "Fiesta Salad", "California Salad", "Chicken Caesar Salad");
		cbEntree.setVisibleRowCount(2);
		
		TextField tfEntree = new TextField("Chosen Entree: ");
		tfEntree.setPrefWidth(200);
		tfEntree.setFont(ckFont);
		
		//Create the desert dishes.
		ComboBox <String> cbDesert = new ComboBox<>();
		cbDesert.setEditable(false);
		cbDesert.setPromptText("Choose a Desert");
		cbDesert.getItems().addAll("Mixed Fruit Salad", "Grape Salad", "Apple Salad");
		cbDesert.setVisibleRowCount(2);
		
		TextField tfDesert = new TextField("Chosen Desert: ");
		tfDesert.setPrefWidth(200);
		tfDesert.setFont(ckFont);
		
		//Create the side dishes.
		CheckBox ckPastaSal = new CheckBox("Pasta Salad");
		CheckBox ckGreekSal = new CheckBox("Greek Salad");
		CheckBox ckHouseSal = new CheckBox("House Salad");
		CheckBox ckPotSal = new CheckBox("Potato Salad");
		
		ckPastaSal.setTextFill(Color.RED);
		ckPastaSal.setFont(ckFont);
		ckGreekSal.setTextFill(Color.LIGHTBLUE);
		ckGreekSal.setFont(ckFont);
		ckHouseSal.setTextFill(Color.GREEN);
		ckHouseSal.setFont(ckFont);
		ckPotSal.setTextFill(Color.BROWN);
		ckPotSal.setFont(ckFont);
		
		Label costLabel = new Label("Total Cost: ");
		TextField tfCost = new TextField();
		tfCost.setEditable(false);
		costLabel.setFont(ckFont);
		
		Button completeOrder = new Button("Complete Order");
		completeOrder.setFont(ckFont);
		
		//Add everything to the main pane
		mainPane.add(nameLabel, 0, 0);
		mainPane.add(customerName, 1, 0);
		mainPane.add(phoneLabel, 0, 1);
		mainPane.add(tfphoneNum, 1, 1);
		mainPane.add(guestLabel, 0, 2);
		mainPane.add(tfnumGuest, 1, 2);
		mainPane.add(entreeLabel, 0, 3);
		mainPane.add(cbEntree, 1, 3);
		mainPane.add(sidesLabel, 0, 4);
		mainPane.add(ckPastaSal, 1, 4);
		mainPane.add(ckGreekSal, 2, 4);
		mainPane.add(ckHouseSal, 3, 4);
		mainPane.add(ckPotSal, 4, 4);
		mainPane.add(desertLabel, 0, 5);
		mainPane.add(cbDesert, 1, 5);
		mainPane.add(completeOrder, 0, 6);
		mainPane.add(costLabel, 3, 6);
		mainPane.add(tfCost, 4, 6);
		
		completeOrder.setOnAction(e -> {
			//First check how many sides the user entered
			String ckResult = "Sides: ";
			int sideCount = 0;
			if(ckPastaSal.isSelected()) {
				ckResult = ckResult + "Pasta Salad ";
				sideCount++;
			}
			if(ckGreekSal.isSelected()) {
				ckResult = ckResult + "Greek Salad ";
				sideCount++;
			}
			if(ckHouseSal.isSelected()) {
				ckResult = ckResult + "House Salad ";
				sideCount++;
			}
			if(ckPotSal.isSelected()) {
				ckResult = ckResult + "Potato Salad ";
				sideCount++;
			}
			//If the user selected more than 2 sides then uncheck all of the boxes
			if(sideCount > 2) {
				ckPastaSal.setSelected(false);
				ckGreekSal.setSelected(false);
				ckHouseSal.setSelected(false);
				ckPotSal.setSelected(false);
			}
			//An if statement making sure that everything is filled out
			if(isNumeric(tfnumGuest.getText()) && sideCount <= 2 && sideCount != 0 && !customerName.getText().equals("")
					&& !tfphoneNum.getText().equals("") && cbDesert.getValue() != null && cbEntree.getValue() != null) {
				//If everything is filled out then display the price in the GUI
				tfCost.setText("$" + Integer.toString(Integer.parseInt(tfnumGuest.getText()) * 35));
				
				//Type everything into a text file using PrintWriter
				try {
					PrintWriter writer = new PrintWriter("Event.txt", "UTF-8");
					writer.println("Customer Name: " + customerName.getText());
					writer.println("Customer Phone:" + tfphoneNum.getText());
					writer.println("Number of Guests: " + tfnumGuest.getText());
					writer.println("Chosen Entree: " + cbEntree.getValue());
					writer.println("Chosen Sides: " + ckResult);
					writer.println("Chosen Desert: " + cbDesert.getValue());
					writer.close();
				} catch(IOException error){
					System.out.println(error);
				}
			} else {
				tfCost.setText("$0");
				System.out.println(tfphoneNum.getText());
				JOptionPane.showMessageDialog(null, "You must fill out all fields.");
			}
		});
		
		Scene caterScene = new Scene(mainPane, 875, 400);
		primaryStage.setTitle("Cindy's Catering");
		primaryStage.setScene(caterScene);
		primaryStage.show();
	}
	
	//Used to see if the entered value is numeric
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

	public static void main(String[] args) {
		launch(args);
	}
}

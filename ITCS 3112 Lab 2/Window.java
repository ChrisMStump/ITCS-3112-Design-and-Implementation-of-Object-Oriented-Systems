import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class Window extends Application{

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		//Button btHW = new Button("Hello World");// Create a button
		
		 // Create a scene and add button btHW
		 //Scene hello = new Scene (btHW, 500, 350);
		 
		 //primaryStage.setScene (hello); // add scene to stage
		 //primaryStage.setTitle("Hello"); // set stage title to Hello
		
		 GridPane pane = new GridPane(); // Creates GridPane layout
		 pane.setAlignment(Pos.CENTER); // keeps nodes in center
		 pane.setHgap(20); // sets horizontal spacing at 20 pixels
		 pane.setVgap(10); // sets vertical spacing at 10 pixels
		 
		 Circle circ = new Circle(); //Create a circle with its properties
		 circ.setCenterX(100);
		 circ.setCenterY(100);
		 circ.setRadius(50);

		 //circ.setStroke(Color.BLACK); //Set outline to black
		 //circ.setFill(Color.WHITE); //Set inside to white
		 
		 circ.setStroke(Color.BLUE);
		 circ.setFill(Color.YELLOW);
		 
		 Label hello = new Label("Hello World"); //create label and font
		 hello.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.ITALIC, 20));
		 
		 Label fun = new Label("Programming is Fun!"); //create label
		 fun.setFont(Font.font("Arial", FontWeight.BOLD, 40)); //add font
		 
		 pane.add(circ, 2, 2); // add circle to pane
		 pane.add(hello, 1, 0); // add hello to pane
		 pane.add(fun, 0, 0); // add fun to pane

		 
		 Scene sceneCirc = new Scene(pane, 200, 200); //add to scene
		 primaryStage.setScene(sceneCirc); //place scene on stage
		 
		 primaryStage.setTitle("Circle"); //set title of stage to Circle
		 
		 primaryStage.show(); //display the stage
	}

	
	public static void main(String[] args) { // main method
		 launch(args);
	}

}

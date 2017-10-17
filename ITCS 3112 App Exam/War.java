import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javax.swing.JOptionPane;

public class War extends Application {
	
	int iterator; //Used to count how many cards are left
	@Override
	public void start(Stage primaryStage) {
		GridPane mainPane = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setHgap(100);
		mainPane.setVgap(50);
		
		mainPane.setStyle("-fx-background-color: lightgreen");
		
		Font appFont = Font.font("Courier New", FontWeight.BOLD, FontPosture.ITALIC, 20);
		
		//Create two rectangles that will be used as the playing cards
		Rectangle firstCard = new Rectangle();
		firstCard.setX(50);
		firstCard.setY(50);
		firstCard.setWidth(160);
		firstCard.setHeight(250);
		firstCard.setArcWidth(20);
		firstCard.setArcHeight(20);
		firstCard.setStroke(Color.BLACK);
		firstCard.setFill(Color.SALMON);
		
		Rectangle secondCard = new Rectangle();
		secondCard.setX(50);
		secondCard.setY(50);
		secondCard.setWidth(160);
		secondCard.setHeight(250);
		secondCard.setArcWidth(20);
		secondCard.setArcHeight(20);
		secondCard.setStroke(Color.BLACK);
		secondCard.setFill(Color.SALMON);
		
		//Create a button to play another turn and then some labels to keep score
		Button duelButton = new Button("DUEL!");
		Label player = new Label("Player");
		Label CPU = new Label("CPU");
		Label playerScore = new Label("0");
		Label cpuScore = new Label("0");
		
		//Set the font of all the labels
		player.setFont(appFont);
		CPU.setFont(appFont);
		playerScore.setFont(appFont);
		cpuScore.setFont(appFont);
		duelButton.setFont(appFont);
		
		//Create some stack panes to allow text within javafx shapes
		StackPane firstStack = new StackPane();
		StackPane secondStack = new StackPane();
		Label firstLabel = new Label("");
		Label secondLabel = new Label("");
		
		firstLabel.setWrapText(true);
		secondLabel.setWrapText(true);
		firstLabel.setPrefWidth(160);
		secondLabel.setPrefWidth(160);
		firstLabel.setFont(appFont);
		secondLabel.setFont(appFont);
		
		//Add labels on top of the shapes
		firstStack.getChildren().addAll(firstCard, firstLabel);
		secondStack.getChildren().addAll(secondCard, secondLabel);
		
		//Add everything to the main pane
		mainPane.add(firstStack, 0, 0);
		mainPane.add(secondStack, 2, 0);
		mainPane.add(player, 0, 1);
		mainPane.add(CPU, 2, 1);
		mainPane.add(playerScore, 0, 2);
		mainPane.add(cpuScore, 2, 2);
		mainPane.add(duelButton, 1, 2);

		//Get the shuffled deck of cards
		String[] deck = getDeck();
		iterator = 0;
		
		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		
		duelButton.setOnAction(e -> {
			if(iterator != 52) {
				//Set the text of the playing cards
				firstLabel.setText(deck[iterator]);
				secondLabel.setText(deck[iterator+1]);
				//If the players card is higher than the cpus card then add a point to the player. Otherwise, do the opposite.
				if(Arrays.asList(RANKS).indexOf(getFirstWord(deck[iterator])) > Arrays.asList(RANKS).indexOf(getFirstWord(deck[iterator+1]))){
					int temp = Integer.parseInt(playerScore.getText());
					temp += 1;
					playerScore.setText(Integer.toString(temp));
				} else if (Arrays.asList(RANKS).indexOf(getFirstWord(deck[iterator])) < Arrays.asList(RANKS).indexOf(getFirstWord(deck[iterator+1]))){
					int temp = Integer.parseInt(cpuScore.getText());
					temp += 1;
					cpuScore.setText(Integer.toString(temp));
				}
				iterator += 2;
			} else {
				//When there are no more cards display who won with a JOptionPane
				if(Integer.parseInt(playerScore.getText()) > Integer.parseInt(cpuScore.getText())) {
					JOptionPane.showMessageDialog(null, "Player won the match!");
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "CPU won the match!");
					System.exit(0);
				}
			}
			
		});
		
		Scene mainScene = new Scene(mainPane, 800, 500);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("War");
		primaryStage.show();
	}

	//Method used to get the first word of a string
	public String getFirstWord(String text) {
		return text.substring(0, text.indexOf(' '));
	}
	
	//Method to create the deck of cards with all the suits
	public static String[] getDeck() {
		String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		// initialize deck
		int n = SUITS.length * RANKS.length;
		String[] deck = new String[n];
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
			}
		}

		// shuffle
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

		// print shuffled deck
		for (int i = 0; i < n; i++) {
			System.out.println(deck[i]);
		}
		
		return deck;
	}
	
	public static void main(String[] args) { // main method
		 launch(args);
	}

}

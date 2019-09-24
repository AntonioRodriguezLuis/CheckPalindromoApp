package dad.palindromo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromoApp extends Application {

	private TextField nombreText;
	private Button comprobarButton;
	private Label palindromoLabel;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		nombreText = new TextField();
		nombreText.setPromptText("Introduce una sentencia");
		nombreText.setMaxWidth(150);
		
		palindromoLabel = new Label("¿Sera palindromo?");
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e ->onSaludarButtonAction(e));
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreText, comprobarButton,palindromoLabel);
		
		Scene scene = new Scene(root,320,200);
		
		primaryStage.setTitle("Hola JavaFX Mejorado");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void onSaludarButtonAction(ActionEvent e) {
		String  palindromo = nombreText.getText();
		
		if(checkPalindrome(palindromo) == true) {
		palindromoLabel.setText("Es Palindromo "+ palindromo +"!");
		palindromoLabel.setStyle("-fx-text-fill: green; -fx-font: Italic bold 30 consolas;");
		}
		else {
			palindromoLabel.setText("No es Palindromo "+ palindromo +"!");
			palindromoLabel.setStyle("-fx-text-fill: red; -fx-font: Italic bold 30 consolas;");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

	public static boolean checkPalindrome(String inputString) {
		boolean esPalindromo = true;
		int j = (int)inputString.length()/2;
		for (int i = 0; i < j; i++) {
			if(inputString.charAt(i) != inputString.charAt(inputString.length()-1-i)) {
				esPalindromo = false;
			}
		}
		return esPalindromo;
	}
}

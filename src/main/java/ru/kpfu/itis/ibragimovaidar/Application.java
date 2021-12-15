package ru.kpfu.itis.ibragimovaidar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Application.class.getResource("/Application.fxml"));

		AnchorPane anchorPane = loader.load();
		Scene scene = new Scene(anchorPane);

		primaryStage.setTitle("Weather app");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

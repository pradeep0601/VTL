package com.pradeep.vtl.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;

@SuppressWarnings("restriction")
public class Test1 extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {

		Text text = new Text();
		text.setText("Hello from Java FX");
		text.setFont(new Font(50));
		
		text.setX(40);
		text.setY(50);
		
		
		Group group = new Group(text);

		Scene scene = new Scene(group, 600, 300);

		// scene.setFill(Paint.BITMASK);
		stage.setTitle("test java fx");

		stage.setScene(scene);

		stage.show();

	}

}

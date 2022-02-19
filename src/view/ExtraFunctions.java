package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ExtraFunctions extends HBox {
	private Button clearButton = new Button("Clear All");
	private Button addFromFileButton = new Button("Add from file");
	
	public ExtraFunctions() {
		setMargin(clearButton, new Insets(0,10,0,0));
		clearButton.setStyle(
				"-fx-background-color:linear-gradient(#1A081B 0%, #232723 25%, #373837 75%, #1A081B 100%);"
				+ "-fx-text-fill: white;"
				);
		addFromFileButton.setStyle(
				"-fx-background-color:linear-gradient(#1A081B 0%, #232723 25%, #373837 75%, #1A081B 100%);"
			    + "-fx-text-fill: white;"
				);
		
		
		getChildren().addAll(clearButton, addFromFileButton);
	}
	
	public Button getClearButton( ) {
		return clearButton;
	}
	
	public Button getAddFromFileButton() {
		return addFromFileButton;
	}
}

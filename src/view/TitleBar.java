package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TitleBar extends HBox {
	
	Button closeButton = new Button();
	Button minimizeButton = new Button();
	
	public TitleBar() {
		setMargin(minimizeButton, new Insets(0,5,0,0));
		setMargin(closeButton, new Insets(0,5,0,0));
		
		setMinimizeButtonStyle("#bf9000");
		
		setCloseButtonStyle("#990000");
		
		setOnMouseEntered(e -> setEffectOnMouseEntered());
		setOnMouseExited(e -> setEffectOnMouseExited());
		
		
		getChildren().addAll(minimizeButton,closeButton);
		
	}
	public Button getCloseButton() {
		return closeButton;
	}
	
	public Button getMinimizeButton() {
		return minimizeButton;
	}
	
	private void setEffectOnMouseEntered() {
		closeButton.setText("×");
		minimizeButton.setText("-");
		setCloseButtonStyle("#ea0000");
		setMinimizeButtonStyle("#ffc000");
	}
	private void setEffectOnMouseExited() {
		closeButton.setText("");
		minimizeButton.setText("");
		setCloseButtonStyle("#990000");
		setMinimizeButtonStyle("#bf9000");
	}
	
	private void setCloseButtonStyle(String color) {
		closeButton.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 25px; " +
                "-fx-min-height: 25px; " +
                "-fx-max-width: 25px; " +
                "-fx-max-height: 25px;"+
                "-fx-background-color:"+color+";"+
                "-fx-text-fill: white");
        
	}
	private void setMinimizeButtonStyle(String color) {
		minimizeButton.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 25px; " +
                "-fx-min-height: 25px; " +
                "-fx-max-width: 25px; " +
                "-fx-max-height: 25px;"+
                "-fx-background-color:"+color+";"+
				 "-fx-text-fill: white");
        
	}
}

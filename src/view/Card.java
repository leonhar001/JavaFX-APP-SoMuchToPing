package view;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Card extends HBox {

	private String labelLink;
	private BackgroundFill fillGreen = new BackgroundFill(
			Color.web("#60a663"), CornerRadii.EMPTY, Insets.EMPTY);
	private BackgroundFill fillRed = new BackgroundFill(
			Color.web("#a66060"), CornerRadii.EMPTY, Insets.EMPTY);
	private BackgroundFill fillGray = new BackgroundFill(
			Color.web("#614e4e"), CornerRadii.EMPTY, Insets.EMPTY);
	
	@SuppressWarnings("unused")
	private InetAddress inet = null;
	
	public Card(String labelLink){
		
		this.labelLink = labelLink;
		
		setEffect(new DropShadow());
		setPrefSize(200, 80);
		setAlignment(Pos.CENTER);
		
		Label linkAdress = new Label(labelLink.toUpperCase());
		linkAdress.setTextFill(Color.BLACK);
		
		linkAdress.setStyle("-fx-text-fill: white;"
				+ "-fx-font-size: 16;" 
				+ "-fx-font-family: \"Verdana\";");
		
		setBackground(new Background(fillGray));
		
		getChildren().add(linkAdress);
	}
	
	public String getLabelLink() {
		return labelLink;
	}
	
	public void alterBackgroundColor(BackgroundFill fill) {
		setBackground(new Background(fill));
	}
	
	public void isOnline() throws IOException {
		try {
			this.inet = InetAddress.getByName(labelLink);
			alterBackgroundColor(fillGreen);
		} catch (UnknownHostException e) {
			alterBackgroundColor(fillRed);
		}
	}
}

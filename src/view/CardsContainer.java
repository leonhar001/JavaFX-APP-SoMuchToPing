package application;

import javafx.scene.control.ScrollPane;

public class CardsContainer extends ScrollPane{

	public CardsContainer(Cards cards) {
		super(cards);
		setFitToHeight(true);
		setFitToWidth(true);
	}

}
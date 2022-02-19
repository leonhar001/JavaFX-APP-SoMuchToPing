package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class CardsPlace extends FlowPane {
	
	RadialGradient shadeCenter = new RadialGradient(
			 0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE,
           new Stop(1, Color.BLACK),
           new Stop(0, Color.GRAY)
   );
	
	BackgroundFill fillCenter = new BackgroundFill(
			shadeCenter , CornerRadii.EMPTY, Insets.EMPTY);
	
	public CardsPlace() {
		setAlignment(Pos.TOP_CENTER);
		setVgap(15);
		setHgap(15);
		setBackground(new Background(fillCenter));
		setPadding(new Insets(10, 10, 10, 10));
	}
}

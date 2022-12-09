package application;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

	RadialGradient shadeCenter = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE,
			new Stop(1, Color.BLACK), new Stop(0, Color.GRAY));

	BackgroundFill fillCenter = new BackgroundFill(shadeCenter, CornerRadii.EMPTY, Insets.EMPTY);

	static final int max = 1000000;
	@Override
	public void start(Stage primaryStage) {
		BorderPane main = new BorderPane();
		
		Cards cards = new Cards();
		
		CardsContainer scrollPane = new CardsContainer(cards);
		
		Header header = new Header();
		
		ObservableList<Screen> screenSizes = Screen.getScreens();
		Double screenHeight = screenSizes.get(0).getBounds().getHeight();
		Double screenWidth = screenSizes.get(0).getBounds().getWidth();
		
		header.getAddCardButton().setOnAction(e -> {
			String input = header.getLink();
			if (!input.isEmpty()) {
				cards.getChildren().add(new Card(input));
				header.clearLabel();
			}
		});

		header.getPingButton().setOnAction(e -> {

			Task<Void> task = new Task<Void>() {
				@Override
				public Void call() {
					for (Node c : cards.getChildren()) {
						try {
							((Card) c).isOnline();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					for (int i = 1; i <= max; i++) {
						if (isCancelled()) {
							break;
						}
						updateProgress(i, max);
					}
					return null;
				}
			};

			header.getBar().progressProperty().bind(task.progressProperty());
			new Thread(task).start();
		});

		header.getClearButton().setOnAction(e -> {
			cards.getChildren().clear();
		});

		header.getAddFromFileButton().setOnAction(e->{
			LinksFromFile lff = new LinksFromFile();
			List<String> links = lff.getLinksList();
			links.stream().forEach(link -> cards.getChildren().add(new Card(link)));
		});

		header.getCloseButton().setOnAction(e -> {
			System.exit(0);
		});

		header.getMinimizeButton().setOnAction(e -> {
			primaryStage.setIconified(true);
		});
		header.getMaximizeButton().setOnAction(e -> {
			primaryStage.setFullScreen(true);
		});

		main.setCenter(scrollPane);
		main.setTop(header);

		Scene scene = new Scene(main, screenWidth*0.8, screenHeight*0.8);

		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setTitle("SoMuchToPing");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

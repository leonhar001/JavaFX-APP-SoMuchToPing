package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.TextAlignment;

public class Header extends GridPane {
	
	private static RadialGradient shadeTop = new RadialGradient(
			 0, 0, 0.5, 0.5, 1, true, CycleMethod.REPEAT,
            new Stop(1, Color.BLACK),
            new Stop(0.1, Color.GRAY)
    );
	
	private static BackgroundFill fillTop = new BackgroundFill(
			shadeTop, null, Insets.EMPTY);
	
	private Button addCardButton = new Button("Submit");
	private Button pingButton = new Button("Ping");
	private ExtraFunctions extraFunctions = new ExtraFunctions();
	private TextField linkEntering = new TextField ();
	private ProgressBar bar = new ProgressBar();
	private TitleBar titleBar = new TitleBar();
	
	public Header() {
		
		setAlignment(Pos.CENTER);
		setMinHeight(150);
		setMaxHeight(150);
		setBackground(new Background(fillTop));
		setHgap(15);
		//setGridLinesVisible(true);
		ColumnConstraints ccLinkEntering = new ColumnConstraints();
		ccLinkEntering.setMaxWidth(linkEntering.getMaxWidth());
		ColumnConstraints ccButtons = new ColumnConstraints();
		ccButtons.setMaxWidth(addCardButton.getMaxWidth());
		
		getColumnConstraints()
		.addAll(cc(),
				ccLinkEntering,
				ccButtons,
				cc());
		getRowConstraints()
		.addAll(rc(),
				rc(),
				rc(),
				rc());
		
		linkEntering.setPromptText("ENTER A LINK!");
		linkEntering.setMinSize(350, 40);
		linkEntering.setMaxSize(350, 40);
		linkEntering.setStyle("-fx-background-color: #444444;"
				+ "-fx-font-size: 18;"
				+ "-fx-text-fill: white;"
				+ "");
		
		addCardButton.setMinSize(80, 40);
		addCardButton.setStyle(
				"-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),"
				+"linear-gradient(#020b02, #3a3a3a),"
			    +"linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),"
			    +"linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),"
			    +"linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
			    + "-fx-text-fill: white;"
				);
		
		pingButton.setMinSize(80, 20);
		pingButton.setStyle(
				"-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),"
				+"linear-gradient(#020b02, #3a3a3a),"
			    +"linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),"
			    +"linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),"
			    +"linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
			    + "-fx-text-fill: white;"
				);
		pingButton.setTextAlignment(TextAlignment.CENTER);
		
		bar.setMinSize(350, 20);
		bar.setStyle("-fx-control-inner-background: #444444;"
				+ "-fx-text-box-border: black;"
				+ "-fx-accent: black");
		
		titleBar.setAlignment(Pos.CENTER_RIGHT);
		
		add(linkEntering, 1, 1);
		add(addCardButton, 2, 1);
		add(pingButton, 2, 2);
		add(bar, 1, 2);
		add(extraFunctions, 1, 3);
		add(titleBar, 3, 0);
		
	}
	
	private ColumnConstraints cc() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(32.5);
		//cc.setFillWidth(true);
		return cc;
	}
	
	private RowConstraints rc() {
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(38.5);
		rc.setFillHeight(true);
		return rc;
	}
	
	public Button getAddCardButton() {
		return addCardButton;
	}
	
	public Button getPingButton() {
		return pingButton;
	}
	
	public Button getClearButton() {
		return extraFunctions.getClearButton();
	}
	
	public Button getAddFromFileButton() {
		return extraFunctions.getAddFromFileButton();
	}
	
	public Button getCloseButton() {
		return titleBar.getCloseButton();
	}
	
	public Button getMinimizeButton() {
		return titleBar.getMinimizeButton();
	}
	
	public ProgressBar getBar() {
		return bar;
	}
	
	public String getLink() {
		return linkEntering.getText();
	}
	public void clearLabel() {
		linkEntering.clear();
	}
}

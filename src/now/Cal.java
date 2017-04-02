package now;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;

public class Cal extends Application {
	public static final int HEIGHT = 600;
	public static final int WIDTH = 600;
	public static final double XSCL = 0.01;
	public static final double YSCL = 0.01;

	boolean dec = false;   // not yet implemented, but this flag will make sure you can't cause a number format exception
	boolean leftParen = false;
	boolean rightParen = false;

	@Override
	public void start(Stage primaryStage) {
		VBox mainPane = new VBox(10);
		mainPane.setPadding(new Insets(10, 10, 10, 10));
		mainPane.prefHeightProperty().bind(primaryStage.heightProperty());
		mainPane.prefWidthProperty().bind(primaryStage.widthProperty());
		mainPane.setStyle("-fx-background-color: #000000;");

		Button[] nums = new Button[10];
		ArrayList<Button> ops;
		
		HBox hb = new HBox(10);
		hb.getChildren().addAll();                                // Can add buttons here. This is the Hbox below the text box and above the numpad buttons. 
		                                                                            // hb.getChildren().addAll(your, buttons, go, here);

		TextField textField = new TextField();
		textField.prefHeightProperty().bind(mainPane.heightProperty().divide(3));
		textField.setStyle("-fx-font-size:29px;");
		textField.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		for (int i = 0; i <= 9; i++) {
		    nums[i] = new Button(Integer.toString(i));
		    nums[i].prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		    nums[i].prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		    nums[i].setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		    nums[i].styleProperty().bind(Bindings.when(nums[i].hoverProperty())
	                .then(new SimpleStringProperty("-fx-color: gray;"))
	                .otherwise(new SimpleStringProperty("-fx-color: white;")));
		}
		
		Button div = new Button("/");
		div.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		div.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		div.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		div.styleProperty().bind(Bindings.when(div.hoverProperty())
				.then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: #434343;")));
		
		Button mul = new Button("*");
		mul.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		mul.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		mul.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.REGULAR, 14));
		mul.styleProperty()
				.bind(Bindings.when(mul.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		
		Button b1 = new Button("(");
		b1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		b1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		b1.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		b1.styleProperty().bind(Bindings.when(b1.hoverProperty())
				.then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
				.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		
		Button b2 = new Button(")");
		b2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		b2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		b2.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		b2.styleProperty().bind(Bindings.when(b2.hoverProperty())
				.then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
				.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		
		Button backSpace = new Button("\u2190");
		backSpace.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		backSpace.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		backSpace.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		backSpace.styleProperty()
				.bind(Bindings.when(backSpace.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		
		Button home = new Button("\u2302");
		home.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		home.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		home.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		home.styleProperty()
				.bind(Bindings.when(home.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		
		Button sub = new Button("-");
		sub.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		sub.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		sub.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		sub.styleProperty()
				.bind(Bindings.when(sub.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		
		Button xPower2 = new Button("x²");
		xPower2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		xPower2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		xPower2.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		xPower2.styleProperty()
				.bind(Bindings.when(xPower2.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		
		Button sqrt = new Button("\u221A");
		sqrt.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		sqrt.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		sqrt.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		sqrt.styleProperty()
				.bind(Bindings.when(sqrt.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		
		Button dot = new Button(".");
		dot.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		dot.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		dot.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		dot.styleProperty()
				.bind(Bindings.when(dot.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		
		Button mod = new Button("%");
		mod.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		mod.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		mod.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		mod.styleProperty()
				.bind(Bindings.when(mod.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		
		Button sum = new Button("+");
		sum.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		sum.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		sum.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		sum.styleProperty()
				.bind(Bindings.when(sum.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));

		Button butx = new Button("x");
		butx.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		butx.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		butx.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		butx.styleProperty()
				.bind(Bindings.when(butx.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #f4a54d;"))
						.otherwise(new SimpleStringProperty("-fx-color: #b96501;")));

		Button equal = new Button("=");
		equal.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		equal.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		equal.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		equal.styleProperty()
				.bind(Bindings.when(equal.hoverProperty())
						.then(new SimpleStringProperty("-fx-color: #f4a54d;"))
						.otherwise(new SimpleStringProperty("-fx-color: #b96501;")));
		
		// sub is a special case
		ops = new ArrayList<>(Arrays.asList(div, mul, sum, mod));
		
		HBox hBox1 = new HBox(5);
		hBox1.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox1.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox1.getChildren().addAll(nums[7], nums[8], nums[9], div, backSpace, home);
		
		HBox hBox2 = new HBox(5);
		hBox2.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox2.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox2.getChildren().addAll(nums[4], nums[5], nums[6], mul, b1, b2);
		
		HBox hBox3 = new HBox(5);
		hBox3.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox3.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox3.getChildren().addAll(nums[1], nums[2], nums[3], sub, xPower2, sqrt);
		
		HBox hBox4 = new HBox(5);
		hBox4.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox4.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox4.getChildren().addAll(nums[0], dot, mod, sum, butx, equal);

		/*
		 * Make Horizontal box to contain menus. (This is the HBox you want to
		 * use if you want to add more menus at the top). Usage is:
		 * menuBox.getChildren().addAll(your, items, go, here);
		 */
		HBox settingsBox = new HBox();
		settingsBox.setAlignment(Pos.BASELINE_LEFT);

		// Make settings drop down menu
		ComboBox<String> settingsComboBox = new ComboBox<String>();
		settingsComboBox.setValue("View");                                                                           // This is the text you see on the comboBox
		settingsComboBox.getItems().addAll(                                                                          // Items of the drop down menu
				"Basic Mode", 
				"Advanced Mode", 
				"Programming Mode", 
				"Graphing Mode");
		settingsComboBox.prefWidthProperty().bind(mainPane.widthProperty().divide(6));

		// Make base conversion drop down menu
		ComboBox<String> baseComboBox = new ComboBox<String>();
		baseComboBox.setValue("Bases");                                                                               // This is the text you see on the comboBox
		baseComboBox.getItems().addAll(                                                                                 // Items of the drop down menu
				"Base 2 (Binary)", 
				"Base 8 (Octal)", 
				"Base 10 (Decimal)", 
				"Base 16 (Hex)");
		baseComboBox.prefWidthProperty().bind(mainPane.widthProperty().divide(4));         // Sets the preferred width of this menu to be 1/4 the width of the calculator
		baseComboBox.prefHeightProperty().bind(mainPane.heightProperty().divide(15));
		settingsBox.getChildren().addAll(settingsComboBox);                                                    // Adds the combo box to the menuBox
		
		for (Button b : nums) {
		    b.setOnMouseClicked(e -> {
		        if (!rightParen) {
                    textField.appendText(b.getText());
		            leftParen = false;
		        }
		    });
		}

		butx.setOnMouseClicked(e -> {
			String txt = textField.getText();
		    if (txt.equals("") || (!rightParen && txt.charAt(txt.length() - 1) == ' ')) {
		        textField.appendText(butx.getText());
		        leftParen = false;
		    }
		});

		dot.setOnMouseClicked(e -> {
			if (!dec && !rightParen) {
			    textField.appendText(dot.getText());
			    leftParen = false;
			}
			    
		});
		
		for (Button b : ops) {
		    b.setOnMouseClicked(e -> {
		        String txt = textField.getText();
	            if (!txt.equals("") && 
	                    txt.charAt(txt.length() - 1) != ' ' && !leftParen) {
	                if (!rightParen)
                        textField.appendText(" ");
                    textField.appendText(b.getText() + " ");
	            }
		    });
		}

		sub.setOnMouseClicked(e -> {
		    String txt = textField.getText();
		    if (txt.equals(""))
			    textField.setText(sub.getText());
			else if (txt.charAt(txt.length() - 1) == ' ')
			    textField.appendText(sub.getText());
			else if (txt.charAt(txt.length() - 1) != ' ' && !leftParen) {
			    if (!rightParen)
			        textField.appendText(" ");
			    textField.appendText(sub.getText() + " ");
			}
		});
		
		xPower2.setOnMouseClicked(e -> {
		    String txt = textField.getText();
		    if (!txt.equals("") && 
                    txt.charAt(txt.length() - 1) != ' ')
		        if (!txt.equals("") && 
                        txt.charAt(txt.length() - 1) != ' ') {
                    if (!rightParen)
                        textField.appendText(" ");
                    textField.appendText("^ 2");
                    leftParen = false;
                }
		});
		
		sqrt.setOnMouseClicked(e -> {
		    String txt = textField.getText();
		    if (!txt.equals("") && 
                    txt.charAt(txt.length() - 1) != ' ')
		        if (!txt.equals("") && 
                        txt.charAt(txt.length() - 1) != ' ') {
                    if (!rightParen)
                        textField.appendText(" ");
                    textField.appendText("^ 0.5");
                    leftParen = false;
                }
		});

		equal.setOnMouseClicked(e -> {
			try {
			    String rpn = Parser.rpn(textField.getText());
			    if (rpn.indexOf('x') < 0)
			        textField.setText(Double.toString(Parser.calculate(rpn)));
			    else {
			        Stage graphingStage = new Stage();
		            graphingStage.setTitle("Graphing Calculator");
		            Group root = new Group();
		            Canvas canvas = new Canvas(HEIGHT, WIDTH);
		            // set up graphics context for drawing
		            GraphicsContext gc = canvas.getGraphicsContext2D();
		            // plot points
		            drawGraph(gc, Parser.rpn(textField.getText()));
		            // add canvas to scene
		            root.getChildren().add(canvas);
		            graphingStage.setScene(new Scene(root));
		            // show scene
		            graphingStage.show();
			    }
			} catch (NullPointerException eed) {
			} catch (NumberFormatException eed) {
			}
		});

		home.setOnMouseClicked(e -> {
			textField.setText("");
		});
		
		backSpace.setOnMouseClicked(e -> {
			try {
			    String txt = textField.getText();
			    if (txt.length() < 2)
			        textField.setText("");
			    else if (txt.charAt(txt.length() - 1) == ' ')
			        textField.setText(txt.substring(0, txt.length() - 3));
			    else
			        textField.setText(txt.substring(0, txt.length() - 1));
			} catch (IndexOutOfBoundsException ex) {
			    textField.setText("");
			}
		});

		b1.setOnMouseClicked(e -> {
		    String txt = textField.getText();
            if (txt.equals(""))
                textField.setText(b1.getText());
            else if (!rightParen && txt.charAt(txt.length() - 1) == ' ') {
                textField.appendText(b1.getText() + " ");
                leftParen = true;
            }
                
		});
		
		b2.setOnMouseClicked(e -> {
		    String txt = textField.getText();
		    if (!txt.equals("") && !leftParen && txt.charAt(txt.length() - 1) != ' ') {
		        textField.appendText(" " + b2.getText() + " ");
		        rightParen = true;
		    }
		        
		});
		
		textField.setDisable(true);
		// textField.disabledProperty();

		mainPane.getChildren().addAll(settingsBox, textField, hb, hBox1, hBox2, hBox3, hBox4);
		Scene scene = new Scene(mainPane, 410, 500);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	// method to draw graph based on user equation
	public void drawGraph(GraphicsContext gc, String rpn) {
		// get points to be graphed
		ArrayList<Vector> points = getPoints(rpn);
		// translate origin to (0,0)
		gc.translate(WIDTH / 2, HEIGHT / 2);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		// draw x and y axes
		gc.strokeLine(-WIDTH / 2, 0, WIDTH / 2, 0);
		gc.strokeLine(0, -HEIGHT / 2, 0, HEIGHT / 2);
		// plot points from user equation
		for (int i = 1; i < points.size(); i++) {
			gc.strokeLine(points.get(i).getX(), points.get(i).getY(), points.get(i - 1).getX(),
					points.get(i - 1).getY());
		}
	}

	// method to return list of points to be plotted
	// NOTE: The entire equation must be multiplied by -1 when obtaining y values,
	// the graphics in javafx invert the y axis (lower y coordinates higher) for whatever reason
	// Another NOTE: doesn't display when the graph is translated because for example x^2 + 5 doesn't scale 5 to the window size
	public ArrayList<Vector> getPoints(String rpn) {
		double y = 0;
		ArrayList<Vector> pts = new ArrayList<Vector>();
		// loop from xmin to xmax, calculate y for each x
		for (double x = -WIDTH / 2; x <= WIDTH / 2; x += XSCL) {
		    String test = rpn.replaceAll("x", String.format("%f", x));
			y = -1.0 * Parser.calculate(test);
			pts.add(new Vector(x / XSCL, y / YSCL));
		}
		return pts;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
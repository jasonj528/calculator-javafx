package now;

import java.math.BigDecimal;
import java.util.ArrayList;

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
	public static final double XSCL = .01;
	public static final double YSCL = .01;

	boolean x2 = false;

	boolean res = false;

	String exp = "";

	@Override
	public void start(Stage primaryStage) {
		VBox mainPane = new VBox(10);
		mainPane.setPadding(new Insets(10, 10, 10, 10));
		mainPane.prefHeightProperty().bind(primaryStage.heightProperty());
		mainPane.prefWidthProperty().bind(primaryStage.widthProperty());
		mainPane.setStyle("-fx-background-color: #000000;");

		HBox hb = new HBox(10);
		hb.getChildren().addAll(); // Can add buttons here. This is the Hbox
									// below the text box and above the numpad
									// buttons. hb.getChildren().addAll(your,
									// buttons, go, here);

		TextField textField = new TextField();

		textField.prefHeightProperty().bind(mainPane.heightProperty().divide(3));
		textField.setStyle("-fx-font-size:29px;");

		textField.setAlignment(Pos.BOTTOM_RIGHT);
		Button num9 = new Button("9");
		num9.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num9.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num9.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num9.styleProperty().bind(Bindings.when(num9.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button num8 = new Button("8");
		num8.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num8.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num8.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num8.styleProperty().bind(Bindings.when(num8.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button num7 = new Button("7");
		num7.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num7.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num7.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num7.styleProperty().bind(Bindings.when(num7.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button div = new Button("/");
		div.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		div.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		div.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		div.styleProperty().bind(Bindings.when(div.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: #434343;")));
		Button num6 = new Button("6");
		num6.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num6.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num6.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num6.styleProperty().bind(Bindings.when(num6.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button num5 = new Button("5");
		num5.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num5.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num5.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num5.styleProperty().bind(Bindings.when(num5.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button num4 = new Button("4");
		num4.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num4.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num4.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num4.styleProperty().bind(Bindings.when(num4.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button mul = new Button("*");
		mul.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		mul.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		mul.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.REGULAR, 14));
		mul.styleProperty()
				.bind(Bindings.when(mul.hoverProperty()).then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		Button b1 = new Button("(");
		b1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		b1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		b1.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		b1.styleProperty().bind(Bindings.when(b1.hoverProperty()).then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
				.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		Button b2 = new Button(")");
		b2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		b2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		b2.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		b2.styleProperty().bind(Bindings.when(b2.hoverProperty()).then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
				.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		Button backSpace = new Button("\u2190");
		backSpace.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		backSpace.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		backSpace.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		backSpace.styleProperty()
				.bind(Bindings.when(backSpace.hoverProperty()).then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		Button home = new Button("\u2302");
		home.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		home.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		home.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		home.styleProperty()
				.bind(Bindings.when(home.hoverProperty()).then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		Button num3 = new Button("3");
		num3.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num3.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num3.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num3.styleProperty().bind(Bindings.when(num3.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button num2 = new Button("2");
		num2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num2.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num2.styleProperty().bind(Bindings.when(num2.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button num1 = new Button("1");
		num1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		num1.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num1.styleProperty().bind(Bindings.when(num1.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button sub = new Button("-");
		sub.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		sub.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		sub.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		sub.styleProperty()
				.bind(Bindings.when(sub.hoverProperty()).then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		Button xPower2 = new Button("x²");
		xPower2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		xPower2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		xPower2.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		xPower2.styleProperty()
				.bind(Bindings.when(xPower2.hoverProperty()).then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		Button sqrt = new Button("\u221A");
		sqrt.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		sqrt.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		sqrt.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		sqrt.styleProperty()
				.bind(Bindings.when(sqrt.hoverProperty()).then(new SimpleStringProperty("-fx-color: #4f7aa2;"))
						.otherwise(new SimpleStringProperty("-fx-color: #34516e;")));
		Button num0 = new Button("0");
		num0.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		num0.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		// num0.setStyle("-fx-line-height: 1.8;");
		num0.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		num0.styleProperty().bind(Bindings.when(num0.hoverProperty()).then(new SimpleStringProperty("-fx-color: gray;"))
				.otherwise(new SimpleStringProperty("-fx-color: white;")));
		Button dot = new Button(".");
		dot.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		dot.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		dot.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		dot.styleProperty()
				.bind(Bindings.when(dot.hoverProperty()).then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		Button mod = new Button("%");
		mod.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		mod.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		mod.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		mod.styleProperty()
				.bind(Bindings.when(mod.hoverProperty()).then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));
		Button sum = new Button("+");
		sum.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		sum.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		sum.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		sum.styleProperty()
				.bind(Bindings.when(sum.hoverProperty()).then(new SimpleStringProperty("-fx-color: #949494;"))
						.otherwise(new SimpleStringProperty("-fx-color: #2e2e2e;")));

		Button graph = new Button("Graph");
		graph.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		graph.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		graph.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		graph.styleProperty()
				.bind(Bindings.when(graph.hoverProperty()).then(new SimpleStringProperty("-fx-color: #f4a54d;"))
						.otherwise(new SimpleStringProperty("-fx-color: #b96501;")));

		Button equal = new Button("=");
		equal.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
		equal.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
		equal.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		equal.styleProperty()
				.bind(Bindings.when(equal.hoverProperty()).then(new SimpleStringProperty("-fx-color: #f4a54d;"))
						.otherwise(new SimpleStringProperty("-fx-color: #b96501;")));

		HBox hBox1 = new HBox(5);
		hBox1.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox1.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox1.getChildren().addAll(num7, num8, num9, div, backSpace, home);
		HBox hBox2 = new HBox(5);
		hBox2.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox2.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox2.getChildren().addAll(num4, num5, num6, mul, b1, b2);
		HBox hBox3 = new HBox(5);
		hBox3.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox3.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox3.getChildren().addAll(num1, num2, num3, sub, xPower2, sqrt);
		HBox hBox4 = new HBox(5);
		hBox4.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
		hBox4.prefWidthProperty().bind(primaryStage.widthProperty());
		hBox4.getChildren().addAll(num0, dot, mod, sum, graph, equal);

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

		num0.setOnMouseClicked(e -> {
			String x = "0";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "0";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num1.setOnMouseClicked(e -> {
			String x = "1";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "1";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num2.setOnMouseClicked(e -> {
			String x = "2";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "2";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num3.setOnMouseClicked(e -> {
			String x = "3";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "3";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num4.setOnMouseClicked(e -> {
			String x = "4";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "4";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num5.setOnMouseClicked(e -> {
			String x = "5";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "5";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num6.setOnMouseClicked(e -> {
			String x = "6";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "6";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num7.setOnMouseClicked(e -> {
			String x = "7";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "7";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num8.setOnMouseClicked(e -> {
			String x = "8";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "8";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});
		num9.setOnMouseClicked(e -> {
			String x = "9";
			exp += x;
			textField.setText(exp);
			if (res == true) {
				exp = "";
				textField.setText(exp);

				String x2 = "9";
				exp += x2;
				textField.setText(exp);
				res = false;

			}

		});

		graph.setOnMouseClicked(e -> {
			Stage graphingStage = new Stage();
			graphingStage.setTitle("Graphing calc test");
			Group root = new Group();
			Canvas canvas = new Canvas(HEIGHT, WIDTH);
			// set up graphics context for drawing
			GraphicsContext gc = canvas.getGraphicsContext2D();
			// plot points
			drawGraph(gc);
			// add canvas to scene
			root.getChildren().add(canvas);
			graphingStage.setScene(new Scene(root));
			// show scene
			graphingStage.show();

		});

		dot.setOnMouseClicked(e -> {

			if (x2 == false) {

				String x = ".";
				exp += x;
				textField.setText(exp);
				res = false;
				x2 = true;
			}

		});
		mod.setOnMouseClicked(e -> {
			String x = "%";
			exp += x;
			textField.setText(exp);
			res = false;
			x2 = false;

		});
		mul.setOnMouseClicked(e -> {

			String x = "*";
			exp += x;
			textField.setText(exp);
			res = false;

			x2 = false;

		});
		div.setOnMouseClicked(e -> {
			String x = "/";
			exp += x;
			textField.setText(exp);
			res = false;
			x2 = false;

		});
		sum.setOnMouseClicked(e -> {
			String x = "+";
			exp += x;
			textField.setText(exp);
			res = false;
			x2 = false;

		});

		sub.setOnMouseClicked(e -> {

			String x = "-";
			exp += x;
			textField.setText(exp);
			res = false;

			x2 = false;

		});

		equal.setOnMouseClicked(e -> {
			try {
				
				exp = exam.solve2(exp);
				textField.setText(exp);
				res = true;
				x2 = false;

			} catch (NullPointerException eed) {
			} catch (NumberFormatException eed) {
			}
		});

		home.setOnMouseClicked(e -> {

			exp = "";
			textField.setText(exp);
			x2 = false;

			res = false;

		});
		backSpace.setOnMouseClicked(e -> {
			try {
				int i = 1;
				exp = exp.substring(0, exp.length() - i);
				i++;
				textField.setText(exp);
				res = false;

				x2 = false;

			} catch (IndexOutOfBoundsException ees) {

			}
		});

		/**
		 * here we do it 4-5^ 4-(5)^
		 * 
		 * @param e
		 */
		xPower2.setOnMouseClicked(e -> {
			exp += "^";
			int yy = 0;
			int yy2 = 0;
			for (int i = 0; i < exp.length(); i++) {
				if (exp.charAt(i) == '^') {
					yy = i;
				}
			}
			for (int i = yy; i >= 1; i--) {
				if ((exp.charAt(i) == '-' || exp.charAt(i) == '+' || exp.charAt(i) == '*' || exp.charAt(i) == '%'
						|| exp.charAt(i) == '/') && i != 0) {
					yy2 = i + 1;
					break;
				}
			}
			String h = exp.substring(0, yy2);
			String u = exp.substring(yy2, yy);
			exp = "";
			exp = h + "(" + u + "^" + ")";

			textField.setText(exp);
			res = false;

			x2 = false;
		});
		b1.setOnMouseClicked(e -> {

			exp += "(";
			textField.setText(exp);
			res = false;
			x2 = false;

		});
		b2.setOnMouseClicked(e -> {

			exp += ")";
			textField.setText(exp);
			res = false;
			x2 = false;

		});
		sqrt.setOnMouseClicked(e -> {
			exp += "S" + "(";
			textField.setText(exp);
			res = false;
			x2 = false;
		});
		textField.setDisable(true);

		// textField.disabledProperty();

		mainPane.getChildren().addAll(settingsBox, textField, hb, hBox1, hBox2, hBox3, hBox4);
		Scene scene = new Scene(mainPane, 410, 500);
		primaryStage.setTitle("Calculator");
		/*
		 * 
		 * android project
		 * 
		 * 
		 * primaryStage.setScene(scene); primaryStage.show(); Rectangle2D
		 * visualBounds = Screen.getPrimary().getVisualBounds(); Scene scene =
		 * new Scene(mainPane, visualBounds.getWidth(),
		 * visualBounds.getHeight());
		 * 
		 * primaryStage.getIcons().add(new
		 * Image(Project.class.getResourceAsStream("/icon.png")));
		 */

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	// method to draw graph based on user equation
	public void drawGraph(GraphicsContext gc) {

		// get points to be graphed
		// TODO: function should receive equation string, pass to getPoints and
		// parse from there
		ArrayList<Vector> points = getPoints();
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
	// NOTE: The entire equation must be multiplied by -1 when obtaining y
	// values,
	// the graphics in javafx invert the y axis (lower y coordinates higher) for
	// whatever reason
	public ArrayList<Vector> getPoints() {

		double y = 0;
		ArrayList<Vector> pts = new ArrayList<Vector>();

		// loop from xmin to xmax, calculate y for each x
		for (double x = -WIDTH / 2; x <= WIDTH / 2; x += XSCL) {

			// test case, parabola
			y = -(Math.pow(x, 3));
			// test case, x^3
			// y= -(Math.pow(x, 3));
			// create vector object, add to array
			pts.add(new Vector(x / XSCL, y / YSCL));
		}
		return pts;
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}

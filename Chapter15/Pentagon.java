import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pentagon extends Application {
    public void start(Stage stage) {
        Pane root = new Pane();
        Point2D[] points = new Point2D[] {
                new Point2D(200, 50),
                new Point2D(350, 150),
                new Point2D(300, 300),
                new Point2D(100, 300),
                new Point2D(50, 150)
        };

        Polygon pentagon = new Polygon();
        for (Point2D p : points) {
            pentagon.getPoints().addAll(p.getX(), p.getY());
        }
        pentagon.setFill(Color.WHITE);
        pentagon.setStroke(Color.BLACK);
        pentagon.setStrokeWidth(2);
        HBox hBox = new HBox();
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPause, btResume );
        Rectangle rect = new Rectangle(20, 20, Color.ROYALBLUE);
        final double[] t = {0};    
        final double speed = 0.002; 
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            t[0] += speed;
            if (t[0] > 1) t[0] = 0;
            Point2D pos = interpolatePentagon(points, t[0]);
            rect.setX(pos.getX() - 10);
            rect.setY(pos.getY() - 10);
            double alpha = 0.5 + 0.5 * Math.sin(t[0] * Math.PI * 2);
            rect.setOpacity(alpha);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        btPause.setOnAction(e -> timeline.pause());
        btResume.setOnAction(e-> timeline.play());
        root.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                timeline.pause();
            } else if (event.getButton() == MouseButton.SECONDARY) {
                timeline.play();
            }
        });

        root.getChildren().addAll(pentagon, rect,hBox);
        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Pentagon Animation");
        stage.setScene(scene);
        stage.show();
    }

    private Point2D interpolatePentagon(Point2D[] pts, double t) {
        double segment = 1.0 / pts.length;
        int side = (int) (t / segment);
        double progress = (t - side * segment) / segment;
        Point2D a = pts[side];
        Point2D b = pts[(side + 1) % pts.length];
        return new Point2D(
                a.getX() + (b.getX() - a.getX()) * progress,
                a.getY() + (b.getY() - a.getY()) * progress
        );
    }

    public static void main(String[] args) {
        launch();
    }
}

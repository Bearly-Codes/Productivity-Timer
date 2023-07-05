import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.animation.Timeline;
import javafx.util.Duration;
/**
 * Main.java
 * This class is the main class for the Productivity Timer.
 * It loads the timer_format.fxml file and starts the timer.
 * It sets the title, scene, and makes the window unresizable.
 * It updates the timers every 100 milliseconds.
 *
 * @author Nicholas Bogan
 */
public class Main extends Application {
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("timer_format.fxml"));
        Parent root = loader.load();
        TimerController controller = loader.getController();
        primaryStage.setTitle("Productivity Timer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> controller.updateTimers()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
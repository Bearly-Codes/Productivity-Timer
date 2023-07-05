import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
/**
 * TimerController.java
 * This class is the controller for the timer_format.fxml file.
 * It handles the button presses and updates the timers.
 * It also initializes the timers and the stylesheet.
 * @author Nicholas Bogan
 */
public class TimerController {
    private Stopwatch leftStopwatch = new Stopwatch();
    private Stopwatch rightStopwatch = new Stopwatch();
    @FXML
    private VBox box;

    @FXML
    private Button pauseButton;

    @FXML
    private void handlePauseButton() {
        leftStopwatch.pause();
        rightStopwatch.pause();
    }

    @FXML
    private Button switchButton;

    @FXML
    //Handles switch button + colors when switching
    private void handleSwitchButton() {
        if(leftStopwatch.isRunning()) {
            leftStopwatch.stop();
            rightStopwatch.start();
            leftTimer.getStyleClass().remove("selected");
            rightTimer.getStyleClass().add("selected");
        } else {
            rightStopwatch.stop();
            leftStopwatch.start();
            rightTimer.getStyleClass().remove("selected");
            leftTimer.getStyleClass().add("selected");
        }
    }

    @FXML
    private Button resetButton;

    @FXML
    private void handleResetButton() {
        leftStopwatch.reset();
        rightStopwatch.reset();
    }
    @FXML
    private Label rightTimer;

    @FXML
    private Label leftTimer;

    @FXML
    private void initialize() {
        pauseButton.setOnAction(event -> handlePauseButton());
        switchButton.setOnAction(event -> handleSwitchButton());
        resetButton.setOnAction(event -> handleResetButton());
        rightTimer.setText("00:00:00");
        leftTimer.setText("00:00:00");
        leftStopwatch.start();
        leftTimer.getStyleClass().add("selected");
        box.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

    public void updateTimers() {
        rightTimer.setText(rightStopwatch.toString());
        leftTimer.setText(leftStopwatch.toString());
    }

}

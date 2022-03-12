import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int INIT_WIDTH = 800;
    private static final int INIT_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Schedule App");
        primaryStage.setWidth(INIT_WIDTH);
        primaryStage.setHeight(INIT_HEIGHT);
        primaryStage.show();
        new Schedule();
    }
}

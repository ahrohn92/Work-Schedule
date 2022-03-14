import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final FXMLLoader mFXMLLoader = new FXMLLoader();
    private static final int INIT_WIDTH = 800;
    private static final int INIT_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


//        new Schedule();

        mFXMLLoader.setLocation(getClass().getResource("/schedule.fxml"));
        Parent rootFxml = mFXMLLoader.load();

        primaryStage.setTitle("Schedule App");
        primaryStage.setScene(new Scene(rootFxml, 300, 275));
        primaryStage.setWidth(INIT_WIDTH);
        primaryStage.setHeight(INIT_HEIGHT);
        primaryStage.show();
    }
}

import boggle.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    GUI gui;

    /**
     * Main method
     *
     * @param args agument, if any
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method.  Control of application flow is dictated by JavaFX framework
     *
     * @param primaryStage stage upon which to load GUI elements
     */
    @Override
    public void start(Stage primaryStage) {
        this.gui = new GUI(primaryStage);
    }


}

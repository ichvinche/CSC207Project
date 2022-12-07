package boggle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 * Help class for the GUI.
 */
public class Help {

    /**
     * The BoggleGame.
     */
    static BoggleGame game;

    /**
     * Display when the help button is clicked.
     */
    public static void display() {
        game = new BoggleGame(true);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Boggle Game - Help");
        window.setMinWidth(300);
        Label label = new Label();
        label.setText(game.giveInstructions());
        Button close = new Button("Close");
        close.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, close);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
package boggle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class Help {

    static BoggleGame game;

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
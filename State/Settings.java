package State;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.Objects;

public class Settings {

    private static String isInt(String str, Context ctx) {
        int textInt;
        try {
            textInt = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return "Please enter a valid number.";
        }
        if ((textInt > 100 || textInt < 10) && !Objects.equals(ctx.state.getClass(), StartState.instance().getClass())) {
            return "Please enter a text size between 10 and 100.";
        } else if ((textInt > 25 || textInt < 10) && Objects.equals(ctx.state.getClass(), StartState.instance().getClass())) {
            return "Please enter a text size between 10 and 25.";
        }
        return "The text size is now " + textInt + ".";
    }
    public static void displaySettings(Context ctx) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Boggle G" +
                "ame - Settings");
        window.setMinWidth(300);
        Label label = new Label();
        if (Objects.equals(ctx.getState().getClass(), StartState.instance().getClass())) {
            label.setText("Input a text size between 10 and 25");
        } else{
            label.setText("Input a text size between 10 and 100");
        }

        TextField textSize = new TextField();
        textSize.setPromptText("Enter a text size.");
        textSize.setPrefColumnCount(10);

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            label.setText(isInt(textSize.getText(), ctx));
            String response = isInt(textSize.getText(), ctx);
            if (!response.equals("Please enter a text size between 10 and 100") && !response.equals("Please enter a valid number")){
                ctx.state.textSize(Integer.parseInt(textSize.getText()));
            }
        });

        Button close = new Button("Close");
        close.setOnAction(e -> window.close());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, textSize, submit, close);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        }


    }
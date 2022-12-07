package boggle;
import Strategy.Strategy;
import Strategy.Context;
import Strategy.EasyGameStrategy;
import Strategy.HardGameStrategy;
import State.Context;
import State.Settings;
import State.*;
import State.StartState;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;

/**
 * The Boggle game GUI.
 */
public class GUI {
    /**
     * The window for the GUI stage.
     */
    Stage window;
    /**
     * All GUI labels.
     */
    Label scoreLabel = new Label("");
    Label words = new Label("");
    Label  words1 = new Label("");
    Label scoreLabel1 = new Label("");
    Label prefixLabel1 = new Label("");
    Label prefixLabel = new Label("");
    /**
     * Variable for the GUI scene choice.
     */
    Boolean scene_choice;
    /**
     * The BoggleGame.
     */
    public BoggleGame game;
    Context ctx;
    /**
     * All GUI text textfield attributes.
     */
    TextField text = new TextField();
    TextField text1 = new TextField();
    /**
     * All GUI prefix textfield attributes.
     */
    TextField prefix = new TextField();
    TextField prefix2 = new TextField();
    /**
     * Check to see if the game is on easy or not.
     */
    Boolean easy;
    /**
     * All GUI buttons.
     */
    public Button newButton, endroundButton, startButton, stopButton, helpButton, size4Button, size5Button,
            SettingsButton, helpButton1, SettingsButton1, HintButton, submitButton, startButton2, stopButton2,
            newButton2, endroundButton2, SettingsButton2, helpButton2, submitButton2, HintButton2, PrefixNumButton1,
            PrefixNumButton2;

    /**
     * Different GUI scenes.
     */
    public Scene scene1,scene2, scene3;

    /**
     * GUI Constructor.
     *
     * @param stage The GUI stage.
     */
    public GUI(Stage stage){
        window = stage;
        initUI();
        this.easy = null;
    }

    /**
     * Draw the scene.
     */
    public void initUI() {
        window.setTitle("Boggle Game");


        //In-Game menu

        endroundButton = new Button("End Round");
        endroundButton.setId("EndRound");
        endroundButton.setPrefSize(150, 50);
        endroundButton.setFont(new Font(12));
        endroundButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        startButton = new Button("Start");
        startButton.setId("Start");
        startButton.setPrefSize(150, 50);
        startButton.setFont(new Font(12));
        startButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        stopButton = new Button("Stop");
        stopButton.setId("Start");
        stopButton.setPrefSize(150, 50);
        stopButton.setFont(new Font(12));
        stopButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        newButton = new Button("New Game");
        newButton.setId("New");
        newButton.setPrefSize(150, 50);
        newButton.setFont(new Font(12));
        newButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        HintButton = new Button("Hint");
        HintButton.setId("Hint");
        HintButton.setPrefSize(150, 50);
        HintButton.setFont(new Font(12));
        HintButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        submitButton = new Button("Submit");
        submitButton.setId("Submit");
        submitButton.setPrefSize(150, 50);
        submitButton.setFont(new Font(12));
        submitButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");



        //Game menu features
        SettingsButton = new Button("Settings");
        SettingsButton.setId("Settings1");
        SettingsButton.setPrefSize(200, 100);
        SettingsButton.setFont(new Font(12));
        SettingsButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        helpButton1 = new Button("Help");
        helpButton1.setId("Help1");
        helpButton1.setPrefSize(150, 50);
        helpButton1.setFont(new Font(12));
        helpButton1.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        helpButton = new Button("Help");
        helpButton.setId("Help");
        helpButton.setPrefSize(200, 50);
        helpButton.setFont(new Font(12));
        helpButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        size4Button = new Button("Size: 4x4");
        size4Button.setId("Size: 4x4");
        size4Button.setPrefSize(200, 100);
        size4Button.setFont(new Font(12));
        size4Button.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        size5Button = new Button("Size: 5x5");
        size5Button.setId("Size: 5x5");
        size5Button.setPrefSize(200, 100);
        size5Button.setFont(new Font(12));
        size5Button.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        //scene 2
        SettingsButton1 = new Button("Settings");
        SettingsButton1.setId("settings");
        SettingsButton1.setPrefSize(150, 50);
        SettingsButton1.setFont(new Font(12));
        SettingsButton1.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        //scene 3
        SettingsButton2 = new Button("Settings");
        SettingsButton2.setId("Settings2");
        SettingsButton2.setPrefSize(150, 50);
        SettingsButton2.setFont(new Font(12));
        SettingsButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        helpButton2 = new Button("Help");
        helpButton2.setId("Help2");
        helpButton2.setPrefSize(150, 50);
        helpButton2.setFont(new Font(12));
        helpButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        stopButton2 = new Button("Stop");
        stopButton2.setId("Stop2");
        stopButton2.setPrefSize(150, 50);
        stopButton2.setFont(new Font(12));
        stopButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        startButton2 = new Button("Start");
        startButton2.setId("Start2");
        startButton2.setPrefSize(150, 50);
        startButton2.setFont(new Font(12));
        startButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        endroundButton2 = new Button("End Round");
        endroundButton2.setId("End Round 2");
        endroundButton2.setPrefSize(150, 50);
        endroundButton2.setFont(new Font(12));
        endroundButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        newButton2 = new Button("New");
        newButton2.setId("New2");
        newButton2.setPrefSize(150, 50);
        newButton2.setFont(new Font(12));
        newButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        submitButton2 = new Button("Submit");
        submitButton2.setId("Submit2");
        submitButton2.setPrefSize(150, 50);
        submitButton2.setFont(new Font(12));
        submitButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        HintButton2 = new Button("Hint");
        HintButton2.setId("Hint2");
        HintButton2.setPrefSize(150, 50);
        HintButton2.setFont(new Font(12));
        HintButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        PrefixNumButton1 = new Button("Prefix Words");
        PrefixNumButton1.setId("Prefix");
        PrefixNumButton1.setPrefSize(150, 50);
        PrefixNumButton1.setFont(new Font(12));
        PrefixNumButton1.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        PrefixNumButton2 = new Button("Prefix Words");
        PrefixNumButton2.setId("Prefix");
        PrefixNumButton2.setPrefSize(150, 50);
        PrefixNumButton2.setFont(new Font(12));
        PrefixNumButton2.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");


        final ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton DifficultyButtonE = new RadioButton("Easy");
        DifficultyButtonE.setToggleGroup(toggleGroup);
        DifficultyButtonE.setSelected(true);
        DifficultyButtonE.setUserData(Color.BLACK);
        DifficultyButtonE.setFont(new Font(16));
        DifficultyButtonE.setStyle("-fx-text-fill: black");

        RadioButton DifficultyButtonH = new RadioButton("Hard");
        DifficultyButtonH.setToggleGroup(toggleGroup);
        DifficultyButtonH.setUserData(Color.BLACK);
        DifficultyButtonH.setFont(new Font(16));
        DifficultyButtonH.setStyle("-fx-text-fill: black");


        RadioButton DifficultyButtonE2 = new RadioButton("Easy");
        DifficultyButtonE2.setToggleGroup(toggleGroup);
        DifficultyButtonE2.setSelected(true);
        DifficultyButtonE2.setUserData(Color.BLACK);
        DifficultyButtonE2.setFont(new Font(16));
        DifficultyButtonE2.setStyle("-fx-text-fill: black");

        RadioButton DifficultyButtonH2 = new RadioButton("Hard");
        DifficultyButtonH2.setToggleGroup(toggleGroup);
        DifficultyButtonH2.setUserData(Color.BLACK);
        DifficultyButtonH2.setFont(new Font(16));
        DifficultyButtonH2.setStyle("-fx-text-fill: black");

        //Scene 1 - Main Menu
        Label name = new Label();
        name.setText("Boggle Game");
        name.setFont(new Font(40));
        VBox layout1 = new VBox();
        layout1.setPadding(new Insets(20, 20, 20, 20));
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(name, size4Button, size5Button, helpButton, SettingsButton);
        scene1 = new Scene(layout1, 750, 500);


        //Top layout Scene 2:
        HBox top = new HBox(startButton, stopButton, newButton, endroundButton, SettingsButton1, helpButton1);

        //Side layout
        scoreLabel.setText("Score is: 0");
        scoreLabel.setFont(new Font(20));
        prefix.setPromptText("Prefix");
        prefixLabel.setText("Number of words: 0");
        VBox side = new VBox(8, scoreLabel, DifficultyButtonE, DifficultyButtonH, prefix, PrefixNumButton1,
                prefixLabel);

        // bottom layout
        words.setText("Type Word:");
        text.setPromptText("Word");
        HBox bot = new HBox(8,words, text, submitButton, HintButton);

        //Top layout Scene 3:
        HBox top1 = new HBox(startButton2, stopButton2, newButton2, endroundButton2, SettingsButton2, helpButton2);

        //Side layout
        scoreLabel1.setText("Score is: 0");
        scoreLabel1.setFont(new Font(20));
        prefix2.setPromptText("Prefix");
        prefixLabel1.setText("Number of words: 0");
        VBox side1 = new VBox(8, scoreLabel1, DifficultyButtonE2, DifficultyButtonH2, prefix2, PrefixNumButton2,
                prefixLabel1);

        // bottom layout
        words1.setText("Type Word:");
        text1.setPromptText("Word");
        HBox bot1 = new HBox(8,words1, text1, submitButton2, HintButton2);

        ctx = new Context(this, game, null);
        ctx.getState().Update(ctx);

        //actions

        // new button: creates new game in same size scene 1
        newButton.setOnAction(e -> {
            game = new BoggleGame(true);
            BorderPane layout2 = new BorderPane();
            layout2.setTop(top);
            scoreLabel1.setText("Score is: 0");
            layout2.setLeft(side);
            layout2.setBottom(bot);
            // grid layout
            GridPane pane1 = new GridPane();
            pane1.setAlignment(Pos.CENTER);
            pane1.setPadding(new Insets(10));
            pane1.setHgap(10);
            pane1.setVgap(10);
            
            //Initialize the context
            ctx = new Context(this, game, pane1);
            State newState = SmallGridState.instance();
            ctx.setState(newState);
            newState.Update(ctx);
            
            BoggleGrid grid_check1 = game.getgrid();
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    Label Char = new Label();
                    Char.setText(Character.toString(grid_check1.getCharAt(row, col)));
                    Char.setFont(new Font(50));
                    pane1.add(Char, col, row);
                }
            }
            layout2.setCenter(pane1);


            scene2 = new Scene(layout2, 900, 500);
            window.setScene(scene2);

        });

        newButton2.setOnAction(e -> {
            game = new BoggleGame(false);
            BorderPane layout3 = new BorderPane();
            layout3.setTop(top1);
            scoreLabel1.setText("Score is: 0");
            layout3.setLeft(side1);
            layout3.setBottom(bot1);
            // grid layout
            GridPane pane1 = new GridPane();
            pane1.setAlignment(Pos.CENTER);
            pane1.setPadding(new Insets(10));
            pane1.setHgap(10);
            pane1.setVgap(10);
            
            //Initialize the context
            ctx = new Context(this, game, pane1);
            State newState = SmallGridState.instance();
            ctx.setState(newState);
            newState.Update(ctx);
            
            BoggleGrid grid_check1 = game.getgrid();
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    Label Char = new Label();
                    Char.setText(Character.toString(grid_check1.getCharAt(row, col)));
                    Char.setFont(new Font(50));
                    pane1.add(Char, col, row);
                }
            }
            layout3.setCenter(pane1);


            scene3 = new Scene(layout3, 900, 500);
            window.setScene(scene3);
        });
        stopButton.setOnAction(e -> {
            game.EndGame();
            window.setScene(scene1);

            //change current state to the menu
            ctx.setState(StartState.instance());
        });
        stopButton2.setOnAction(e -> {
            game.EndGame();
            window.setScene(scene1);

            //change current state to the menu
            ctx.setState(StartState.instance());
        });

        // endroundbutton: ends round lets computer play then starts another round
        endroundButton.setOnAction(e -> {
            game.endround();
            BorderPane layout2 = new BorderPane();
            layout2.setTop(top);
            scoreLabel.setText("Score is: 0");
            layout2.setLeft(side);
            layout2.setBottom(bot);
            // grid layout
            GridPane pane1 = new GridPane();
            pane1.setAlignment(Pos.CENTER);
            pane1.setPadding(new Insets(10));
            pane1.setHgap(10);
            pane1.setVgap(10);
            BoggleGrid grid_check1 = game.getgrid();
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    Label Char = new Label();
                    Char.setText(Character.toString(grid_check1.getCharAt(row, col)));
                    Char.setFont(new Font(50));
                    pane1.add(Char, col, row);
                }
            }
            layout2.setCenter(pane1);
            scene2 = new Scene(layout2, 900, 500);
            window.setScene(scene2);
        });
        // submit button: gets text and searches dictionary
        submitButton.setOnAction(e -> {
            String Userword = text.getText();
            if (!easy && Userword.length() >= 5) {
                game.addword(Userword);
            } else if (easy) {
                game.addword(Userword);
            }
            text.clear();
            updateScore();
        });
        submitButton2.setOnAction(e -> {
            String Userword = text.getText();
            if (!easy && Userword.length() >= 5) {
                game.addword(Userword);
            } else if (easy) {
                game.addword(Userword);
            }
            text.clear();
            updateScore1();

        });
        endroundButton2.setOnAction(e -> {
            game.endround();
            BorderPane layout3 = new BorderPane();
            layout3.setTop(top1);
            scoreLabel1.setText("Score is: 0");
            layout3.setLeft(side1);
            layout3.setBottom(bot1);
            // grid layout
            GridPane pane1 = new GridPane();
            pane1.setAlignment(Pos.CENTER);
            pane1.setPadding(new Insets(10));
            pane1.setHgap(10);
            pane1.setVgap(10);

            BoggleGrid grid_check1 = game.getgrid();
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    Label Char = new Label();
                    Char.setText(Character.toString(grid_check1.getCharAt(row, col)));
                    Char.setFont(new Font(50));
                    pane1.add(Char, col, row);
                }
            }
            layout3.setCenter(pane1);
            scene3 = new Scene(layout3, 900, 500);
            window.setScene(scene3);
        });
        //Change to help:
        helpButton2.setOnAction(e -> Help.display());

        //Change to help:
        helpButton.setOnAction(e -> Help.display());

        //Change to help:
        helpButton1.setOnAction(e -> Help.display());


        startButton.setOnAction(e->{
            if (easy){
                Strategy strat = new EasyGameStrategy();
                Context cont = new Context(strat);
                game.context = cont;
            }
            else{
                Strategy strat = new HardGameStrategy();
                Context cont = new Context(strat);
                game.context = cont;
            }
            game.playGame();

            game.playRound();
        });


        startButton2.setOnAction(e-> {
            if (easy){
                Strategy strat = new EasyGameStrategy();
                Context cont = new Context(strat);
                game.context = cont;
            }
            else{
                Strategy strat = new HardGameStrategy();
                Context cont = new Context(strat);
                game.context = cont;
            }
            game.playGame();

            game.playRound();
        });


        //Change to 4x4 size game:
        size4Button.setOnAction(e -> {
            scene_choice = true;
            game = new BoggleGame(true);
            //Scene 2:
            BorderPane layout2 = new BorderPane();
            layout2.setTop(top);
            scoreLabel.setText("Score is: 0");
            layout2.setLeft(side);
            layout2.setBottom(bot);

            //grid layout
            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);
            pane.setPadding(new Insets(10));
            pane.setHgap(10);
            pane.setVgap(10);

            //initialize context and state
            ctx = new Context(this, game, pane);
            State newState = SmallGridState.instance();
            ctx.setState(newState);
            newState.Update(ctx);

            BoggleGrid grid_check = game.getgrid();
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    Label Char = new Label();
                    Char.setText(Character.toString(grid_check.getCharAt(row, col)));
                    Char.setFont(new Font(50));
                    pane.add(Char, col, row);
                }
            }
            layout2.setCenter(pane);
            scene2 = new Scene(layout2, 900, 500);
            window.setScene(scene2);
        });


        //Change to 5x5 size game:
        size5Button.setOnAction(e -> {
            scene_choice = false;
            game = new BoggleGame(false);
            //Scene 3:
            BorderPane layout3 = new BorderPane();
            layout3.setTop(top1);
            scoreLabel1.setText("Score is: 0");
            layout3.setLeft(side1);
            layout3.setBottom(bot1);

            // grid layout

            GridPane pane1 = new GridPane();
            pane1.setAlignment(Pos.CENTER);
            pane1.setPadding(new Insets(10));
            pane1.setHgap(10);
            pane1.setVgap(10);
            
            //initialize context and state
            ctx = new Context(this, game, pane);
            State newState = SmallGridState.instance();
            ctx.setState(newState);
            newState.Update(ctx);

            BoggleGrid grid_check1 = game.getgrid();
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    Label Char = new Label();
                    Char.setText(Character.toString(grid_check1.getCharAt(row, col)));
                    Char.setFont(new Font(50));
                    pane1.add(Char, col, row);

                }
            }
            layout3.setCenter(pane1);
            scene3 = new Scene(layout3, 900, 500);
            window.setScene(scene3);
        });

        //ADD
        // for 4x4 Grid(scene2)
        PrefixNumButton1.setOnAction(e -> {
            String prfix = prefix.getText();
            int num = game.CheckPrefix(prfix, game.allWords);
            updateNumPrefix(num);


        });
        // for 4x4 Grid(scene2)
        HintButton.setOnAction(e->{
            String hint = game.RequestHint(game.allWords);
            text.setText(hint);
        });
        // for 4x4 Grid(scene2)
        SettingsButton1.setOnAction(e->{
            SettingsButton1.setOnAction(e->{Settings.displaySettings(ctx);});
        });

        // for 5x5 Grid(scene3)
        PrefixNumButton2.setOnAction(e -> {
            String prfix = prefix2.getText();
            int num = game.CheckPrefix(prfix, game.allWords);
            updateNumPrefix1(num);
        });
        // for 5x5 Grid(scene3)
        HintButton2.setOnAction(e->{
            String hint = game.RequestHint(game.allWords);
            text.setText(hint);
        });
        // for 5x5 Grid(scene3)
        SettingsButton2.setOnAction(e->{
            SettingsButton2.setOnAction(e->{Settings.displaySettings(ctx);});
        });

        // for main menu(scene1)
        SettingsButton.setOnAction(e->{Settings.displaySettings(ctx);});

        DifficultyButtonE.setOnAction(e -> {
            easy = true;
            game.easyGameMode();
        });

        DifficultyButtonH.setOnAction(e -> {easy = false;});

        DifficultyButtonE2.setOnAction(e -> {
            easy = true;
        });

        DifficultyButtonH2.setOnAction(e -> {easy = false;});

        //Start Scene
        window.setScene(scene1);
        window.show();
    }

    /**
     * Update the score shown to the player.
     */
    private void updateScore() {
        scoreLabel.setText("Score is:" + game.getscore());

    }

    /**
     * Update the second score label.
     */
    private void updateScore1() {
        scoreLabel1.setText("Score is:" + game.getscore());

    }

    /**
     * Update the number of prefixes on the screen for easy game mode.
     *
     * @param num The number we want to show on the screen.
     */
    private void updateNumPrefix(int num) {
        prefixLabel.setText("Number of words:" + num);
    }

    /**
     * Update the number of prefixes on the screen for hard game mode.
     * @param num The number we want to show on the screen.
     */
    private void updateNumPrefix1(int num) {
        prefixLabel.setText("Number of words:" + num);
    }


}

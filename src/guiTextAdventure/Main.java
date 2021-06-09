package guiTextAdventure;

import guiTextAdventure.game.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main extends Application {

    private GameEngine engine;
    private FlowPane buttonsPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Text Adventure");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        buttonsPane = (FlowPane)loader.getNamespace().get("buttonsPane");
        Label label1 = (Label)loader.getNamespace().get("gameLabel1");
        Label label2 = (Label)loader.getNamespace().get("gameLabel2");


        GameMessageCallback callback = new GameMessageCallback() {
            @Override
            public void call(String message) {
                label1.setText(label2.getText());
                label2.setText(message);
            }
        };

        setupGame(callback);
        renderState(engine.getAvailableActions());
    }

    private void renderState(List<GameAction> actions) {
        engine.printCurrentState();
        buttonsPane.getChildren().clear();
        if (engine.checkVictory()){
            Alert victoryAlert = new Alert(Alert.AlertType.CONFIRMATION);
            victoryAlert.setTitle("You won!");
            victoryAlert.setContentText("You are in the final room, good job!");
            victoryAlert.show();
            return;
        }
        for (GameAction action: actions) {
            Button actionButton = new Button(action.toString());
            EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    action.apply(engine);
                    renderState(engine.getAvailableActions());
                }
            };
            actionButton.setOnMouseClicked(handler);
            /*actionButton.setOnMouseClicked(mouseEvent -> {
                action.apply(engine);
                renderState(engine.getAvailableActions());
            });
             */
            buttonsPane.getChildren().add(actionButton);
        }
    }

    private void setupGame(GameMessageCallback callback) {
        WorldBuilder builder = new WorldBuilder();
        GameWorld world = builder.build();
        Room initialPosition = (Room)world.getThings().stream().filter((Thing r) -> r.getId() == "ROOM_1").findFirst().get();
        GameState initialState = new GameState(world,initialPosition);
        Room targetPosition = (Room)world.getThings().stream().filter((Thing r) -> r.getId() == "ROOM_5").findFirst().get();

        engine = new GameEngine(initialState, targetPosition,callback);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

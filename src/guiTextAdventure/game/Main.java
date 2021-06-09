package guiTextAdventure.game;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*WorldBuilder builder = new WorldBuilder();
        GameWorld world = builder.build();
        Room initialPosition = (Room)world.getThings().stream().filter((Thing r) -> r.getId() == "ROOM_1").findFirst().get();
        GameState initialState = new GameState(world,initialPosition);
        Room targetPosition = (Room)world.getThings().stream().filter((Thing r) -> r.getId() == "ROOM_5").findFirst().get();

        GameEngine engine = new GameEngine(initialState, targetPosition);
        Scanner input = new Scanner(System.in);
        while (true) {
            engine.printCurrentState();
            List<GameAction> actions = engine.getAvailableActions();
            //engine.printActions(actions);
            int option = input.nextInt();
            GameAction selectedAction = actions.get(option-1);
            selectedAction.apply(engine);
            if (engine.checkVictory()){
                System.out.println("You won!");
                return;
            }
        }

         */
    }
}

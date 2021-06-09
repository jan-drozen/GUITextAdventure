package guiTextAdventure.game;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private GameWorld world;
    private StandIn playerStandsIn;
    private List<Key> keys = new ArrayList<>();

    public GameState(GameWorld world, StandIn standsIn){
        this.world = world;
        this.playerStandsIn = standsIn;
    }

    public StandIn getPlayerStandsIn() {
        return playerStandsIn;
    }

    public void setPlayerStandsIn(StandIn playerStandsIn) {
        this.playerStandsIn = playerStandsIn;
    }

    public GameWorld getWorld() {
        return world;
    }

    public void setWorld(GameWorld world) {
        this.world = world;
    }

    public List<Key> getKeys() {
        return keys;
    }
}

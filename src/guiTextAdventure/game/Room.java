package guiTextAdventure.game;

public class Room extends Space {

    public Room(String description, String id) {
        super(id);
        this.description = description;
    }

    @Override
    public Iterable<GameAction> getActions(GameEngine engine) {
        return engine.getActions(this);
    }
}

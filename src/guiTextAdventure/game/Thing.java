package guiTextAdventure.game;

public abstract class Thing {
    protected String id;
    protected String description;

    public Thing(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getId() {
        return id;
    }

    public abstract Iterable<GameAction> getActions(GameEngine engine);
}

package guiTextAdventure.game;

import java.util.List;

public class GameWorld {
    private List<Room> rooms;
    private List<Thing> things;

    public GameWorld(List<Thing> things) {
        this.things = things;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }
}

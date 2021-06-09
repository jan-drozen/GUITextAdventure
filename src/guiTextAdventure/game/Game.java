package guiTextAdventure.game;

public class Game {
}

abstract class DoorAction extends GameAction {
    protected final Door door;

    protected DoorAction(Door door) {
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }
}

class OpenDoor extends DoorAction {

    protected OpenDoor(Door door) {
        super(door);
    }

    @Override
    public String toString() {
        return "Open "+door.toString();
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}

class CloseDoor extends DoorAction {

    protected CloseDoor(Door door) {
        super(door);
    }
    @Override
    public String toString() {
        return "Close "+door.toString();
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}

class GoThrough extends DoorAction {

    protected GoThrough(Door door) {
        super(door);
    }
    @Override
    public String toString() {
        return "Go through "+door.toString();
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}

abstract class KeyDoorAction extends DoorAction{
    protected final Key key;
    protected KeyDoorAction(Door door, Key key) {
        super(door);
        this.key = key;
    }
    protected Key getKey() {
        return this.key;
    }
}

class LockDoor extends KeyDoorAction {

    protected LockDoor(Door door, Key key) {
        super(door, key);
    }
    @Override
    public String toString() {
        return "Lock "+door.toString();
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}

class UnlockDoor extends KeyDoorAction {
    protected UnlockDoor(Door door, Key key) {
        super(door, key);
    }
    @Override
    public String toString() {
        return "Unlock "+door.toString();
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}

abstract class ThingAction extends GameAction{
    protected Thing thing;
    public ThingAction(Thing thing) {
        this.thing = thing;
    }

    public Thing getThing() {
        return thing;
    }
}

class Grab extends ThingAction {
    public Grab(Thing thing) {
        super(thing);
    }

    @Override
    public String toString() {
        return "Grab "+thing;
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}

class Drop extends ThingAction {

    public Drop(Thing thing) {
        super(thing);
    }

    @Override
    public String toString() {
        return "Drop "+thing;
    }

    @Override
    public void apply(GameEngine engine) {
        engine.apply(this);
    }
}



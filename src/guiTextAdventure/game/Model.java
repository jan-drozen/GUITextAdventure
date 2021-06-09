package guiTextAdventure.game;

import java.util.ArrayList;
import java.util.List;

public class Model {
}

interface Container {
    Iterable<Thing> getThings();
    void removeThing(Thing thing);
    void addThing(Thing thing);
}

abstract class AbstractContainer extends Thing implements Container{
    protected List<Thing> things;

    public AbstractContainer(String id) {
        super(id);
        things = new ArrayList<>();
    }

    public void add(Thing t) {
        things.add(t);
    }

    @Override
    public Iterable<Thing> getThings() {
        return things;
    }

    @Override
    public void removeThing(Thing thing) {
        things.remove(thing);
    }

    @Override
    public void addThing(Thing thing) {
        things.add(thing);
    }
}

interface StandIn extends Container{
}

abstract class Space extends AbstractContainer implements StandIn {
    private List<Door> doors;

    public Space(String id) {
        super(id);
        doors = new ArrayList<>();
    }

    public List<Door> getDoors() {
        return doors;
    }

    @Override
    public void add(Thing t) {
        if (t instanceof Door) {
            doors.add((Door)t);
        }
        things.add(t);
    }
}


enum DoorLockState {Locked, Unlocked}
enum DoorState {Open,Closed}

class Door extends Thing {
    private Space from;
    private DoorLockState lockState;
    private final Key compatibleKey;
    private Space to;
    private DoorState state;

    public Door(String description, String id,Space from, Space to, DoorLockState lockState, Key compatibleKey, DoorState state) {
        super(id);
        this.description = description;
        this.from = from;
        this.lockState = lockState;
        this.compatibleKey = compatibleKey;
        from.add(this);
        this.to = to;
        to.add(this);
        this.state = state;
    }

    @Override
    public Iterable<GameAction> getActions(GameEngine engine) {
        return engine.getActions(this);
    }

    public DoorLockState getLockState() {
        return lockState;
    }
    public void setLockState(DoorLockState value) {
        this.lockState = value;
    }

    public Key getCompatibleKey() {
        return compatibleKey;
    }

    public DoorState getState() {
        return state;
    }

    public void setState(DoorState state) {
        this.state = state;
    }

    public Space getFrom() {
        return from;
    }

    public Space getTo() {
        return to;
    }
}

interface Wearable {}

class Key extends Thing implements Wearable {
    public Key(String description, String id) {
        super(id);
        this.description = description;
    }

    @Override
    public Iterable<GameAction> getActions(GameEngine engine) {
        return engine.getActions(this);
    }
}
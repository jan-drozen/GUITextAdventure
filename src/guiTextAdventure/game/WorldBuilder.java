package guiTextAdventure.game;

import java.util.Arrays;
import java.util.List;

public class WorldBuilder {
    public GameWorld build() {
        Room firstRoom = new Room("Room with Gray metal door in the north and Old wooden door in the east","ROOM_1");
        Room secondRoom = new Room("Dark room with Yellow wooden door in the north and Old wooden door in the west","ROOM_2");
        Room thirdRoom = new Room("Room with three doors - Yellow wooden door in the south, Green metal door in the east and  Red steel door in the north","ROOM_3");
        Room fourthRoom = new Room("Room with two doors. Green metal door in the east, the other Gray metal door in the south ","ROOM_4");
        Room fifthRoom = new Room("The final room","ROOM_5");

        Key key1_4 = new Key("An old rusty black key","KEY_DOOR_1_4");
        firstRoom.add(key1_4);
        Key key3_5 = new Key("A nice gold key","KEY_DOOR_3_5");
        fourthRoom.add(key3_5);

        Door door1_2 = new Door("Old wooden door","DOOR_1_2",firstRoom, secondRoom, DoorLockState.Unlocked, null, DoorState.Closed);
        Door door1_4 = new Door("Gray metal door","DOOR_1_4",firstRoom, fourthRoom, DoorLockState.Locked, key1_4, DoorState.Closed);
        Door door2_3 = new Door("Yellow wooden door","DOOR_2_3",secondRoom, thirdRoom, DoorLockState.Unlocked, null, DoorState.Closed);
        Door door3_4 = new Door("Green metal door","DOOR_3_4",thirdRoom, fourthRoom, DoorLockState.Unlocked, null, DoorState.Closed);
        Door door3_5 = new Door("Red steel door","DOOR_3_5",thirdRoom, fifthRoom, DoorLockState.Locked, key3_5, DoorState.Closed);

        List<Thing> things = Arrays.asList(firstRoom, secondRoom, thirdRoom, fourthRoom, fifthRoom, key3_5, door1_2, door1_4, door2_3, door3_4, door3_5);

        return new GameWorld(things);
    }
}

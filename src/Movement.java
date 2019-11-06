import lang.JaVALOR.utils.ConsoleMenu.ConsoleMenu;
import lang.JaVALOR.utils.ConsoleMenu.MenuItem;

import java.util.HashMap;

public class Movement {

    private RoomDatabase roomDatabase = new RoomDatabase();
    private int currentRoom = 0;

    public Movement() {
    }

    public Movement(RoomDatabase roomDatabase) {
        this.roomDatabase = roomDatabase;
    }

    public void run() {
        while(true) {
            waitForMovement();
        }
    }

    public void waitForMovement() {
        ConsoleMenu menu = new ConsoleMenu();

        for (Direction eachDirection : Direction.values()) {
            menu.add( new MenuItem(eachDirection.toString(), eachDirection,
                    (menuIndex, menuItem) -> move((Direction) menuItem.getData())
            ));
        }

        menu.add(new MenuItem("Quit", null, (menuIndex, menuItem) -> System.exit(0)));
        menu.show();
        menu.action(menu.waitForChoice("at "+roomDatabase.get(this.currentRoom).getName()+" > "));
    }

    public boolean move(Direction direction) {
        Room room = getRoom();
        Door door = room.getDoor(direction);
        if ((door == null)||
                (door.getOneWayDoorCollection().size() == 0) ) {
            System.out.printf(" * There is no door on '%s'\n", direction);
            return false;
        }

        int newRoomIndex = -1;
        if (door.getOneWayDoorCollection().size() == 1) {
            moveTo(door.getOneWayDoorCollection().get(0).getDestination());
        }
        else {
            moveToMultiDoor(door);
        }

        return true;

    }

    private void moveTo(Room room) {
        int key = roomDatabase.getKey(room);

        if (key < 0)
            return;

        this.currentRoom = key;
        System.out.printf(" * Move to room #%d '%s'\n", this.currentRoom, roomDatabase.get(this.currentRoom));
    }

    private void moveToMultiDoor(Door door) {
        ConsoleMenu menu = new ConsoleMenu();
        OneWayDoor returnValue = null;
        for (int index = 0; index < door.getOneWayDoorCollection().size(); index++) {
            menu.add(new MenuItem(
                    door.getOneWayDoorCollection().get(index).getDestination().getName(),
                    door.getOneWayDoorCollection().get(index),
                    (menuIndex, menuItem) -> moveTo(((OneWayDoor) menuItem.getData()).getDestination())
                    ));
        }

        menu.show();
        menu.action(menu.waitForChoice());
    }




    public HashMap<Integer, Room> getRoomDatabase() {
        return roomDatabase;
    }

    public void setRoomDatabase(RoomDatabase roomDatabase) {
        this.roomDatabase = roomDatabase;
    }

    public Room getRoom() {
        return roomDatabase.getOrDefault(currentRoom, new Room());
    }
    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }
}

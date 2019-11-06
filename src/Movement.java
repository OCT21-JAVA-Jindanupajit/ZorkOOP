import java.util.HashMap;

public class Movement {

    private RoomDatabase roomDatabase = new RoomDatabase();
    private int currentRoom = 0;

    public Movement() {
    }

    public Movement(RoomDatabase roomDatabase) {
        this.roomDatabase = roomDatabase;
    }

    public boolean move(Direction direction) {
        Room room = getRoom();
        Door door = room.getDoor(direction);
        if ((door == null)||
                (door.getOneWayDorCollection().size() == 0) ) {
            System.out.printf(" * There is no door on '%s'\n", direction);
            return false;
        }

        int newRoomIndex = -1;
        if (door.getOneWayDorCollection().size() == 1) {
            if (door.getOneWayDorCollection().get(0).isOpened()) {
                newRoomIndex = roomDatabase.getKey(door.getOneWayDorCollection().get(0).getDestination());
            }
        }
        else {
            newRoomIndex = getSelection(door);
        }

    }

    private OneWayDoor getSelection(Door door) {

    }




    public HashMap<Integer, Room> getRoomDatabase() {
        return roomDatabase;
    }

    public void setRoomDatabase(HashMap<Integer, Room> roomDatabase) {
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

import java.util.HashMap;

public class ZorkOOPApplication {
    public static void main(String[] args) {
        RoomDatabase roomDatabase = roomDatabaseBuilder();
        Movement movement = new Movement();

        movement.setRoomDatabase(roomDatabase);
        movement.setCurrentRoom(1);

        movement.run();

    }

    private static RoomDatabase roomDatabaseBuilder() {

        RoomDatabase roomDatabase = new RoomDatabase();

        roomDatabase.put(1, new Room("Foyer") );
        roomDatabase.put(2, new Room("Front") );
        roomDatabase.put(3, new Room("Library") );
        roomDatabase.put(4, new Room("Kitchen") );
        roomDatabase.put(5, new Room("Dining") );
        roomDatabase.put(6, new Room("Vault") );
        roomDatabase.put(7, new Room("Parlor") );
        roomDatabase.put(8, new Room("Secret") );

        roomDatabase.get(1).getDoor().put(Direction.NORTH,
                new Door( new OneWayDoor(roomDatabase.get(2)) )
        );

        roomDatabase.get(2).getDoor().put(Direction.SOUTH,
                new Door( new OneWayDoor(roomDatabase.get(1)) )
        );
        roomDatabase.get(2).getDoor().put(Direction.EAST,
                new Door( new OneWayDoor(roomDatabase.get(4)) )
        );
        roomDatabase.get(2).getDoor().put(Direction.WEST,
                new Door( new OneWayDoor(roomDatabase.get(3)) )
        );

        roomDatabase.get(3).getDoor().put(Direction.EAST,
                new Door( new OneWayDoor(roomDatabase.get(2)) )
        );
        roomDatabase.get(3).getDoor().put(Direction.NORTH,
                new Door( new OneWayDoor(roomDatabase.get(5)) )
        );

        roomDatabase.get(4).getDoor().put(Direction.NORTH,
                new Door( new OneWayDoor(roomDatabase.get(7)) )
        );
        roomDatabase.get(4).getDoor().put(Direction.WEST,
                new Door( new OneWayDoor(roomDatabase.get(2)) )
        );

        roomDatabase.get(5).getDoor().put(Direction.SOUTH,
                new Door( new OneWayDoor(roomDatabase.get(3)) )
        );

        roomDatabase.get(6).getDoor().put(Direction.EAST,
                new Door( new OneWayDoor(roomDatabase.get(7)) )
        );
        roomDatabase.get(6).getDoor().get(Direction.EAST).getOneWayDoorCollection().add(
                new OneWayDoor(roomDatabase.get(8))
        );

        roomDatabase.get(7).getDoor().put(Direction.SOUTH,
                new Door( new OneWayDoor(roomDatabase.get(4)) )
        );
        roomDatabase.get(7).getDoor().put(Direction.WEST,
                new Door( new OneWayDoor(roomDatabase.get(6)) )
        );

        roomDatabase.get(8).getDoor().put(Direction.WEST,
                new Door( new OneWayDoor(roomDatabase.get(6)) )
        );

        return roomDatabase;
    }

}

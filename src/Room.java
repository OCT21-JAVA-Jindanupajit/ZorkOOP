import java.util.HashMap;

public class Room {

    private final HashMap<Direction, Door> door = new HashMap<>();

    public Room() {
    }

    public Room move(Direction direction) {
        if (door.containsKey(direction)) {
            return null;
        }
        else
            return this;
    }

    public HashMap<Direction, Door> getDoor() {
        return door;
    }

    @Override
    public String toString() {
        return "Room{" +
                "door=" + door +
                '}';
    }
}

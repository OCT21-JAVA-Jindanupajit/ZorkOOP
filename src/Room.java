import java.util.HashMap;

public class Room {

    private final HashMap<Direction, Door> door = new HashMap<>();

    public Room() {
    }

    public Door getDoor(Direction direction) {
        return door.getOrDefault(direction, null);
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

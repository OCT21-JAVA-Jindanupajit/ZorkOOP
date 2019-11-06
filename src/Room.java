import java.util.HashMap;

public class Room {

    private String name;
    private final HashMap<Direction, Door> door = new HashMap<>();

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public Door getDoor(Direction direction) {
        return door.getOrDefault(direction, null);
    }

    public HashMap<Direction, Door> getDoor() {
        return door;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

import java.util.HashMap;
import java.util.Map;

public class RoomDatabase extends HashMap<Integer, Room> {
    public RoomDatabase(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public RoomDatabase(int initialCapacity) {
        super(initialCapacity);
    }

    public RoomDatabase() {
    }

    public RoomDatabase(Map<? extends Integer, ? extends Room> m) {
        super(m);
    }

    public int getKey(Room room) {

        for (Integer key : this.keySet()) {
            if (this.get(key).equals(room))
                return key;
        }
        return -1;
    }
}

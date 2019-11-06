import java.util.ArrayList;


public class Door {
    private final ArrayList<OneWayDoor> oneWayDoorCollection = new ArrayList<>();

    public Door() {
    }

    public Door(OneWayDoor oneWayDoor) {
        this.oneWayDoorCollection.add(oneWayDoor);
    }

    public Room getDestination() {
    // if only one door return that room
        if (oneWayDoorCollection.size() == 1)
            return oneWayDoorCollection.get(0).getDestination();
        else
            return null;

    }

    public Room getDestination(int index) {
        if (index < 0)
            return null;
        else if (oneWayDoorCollection.size() > index)
            return oneWayDoorCollection.get(index).getDestination();
        else
            return null;
    }

    public ArrayList<OneWayDoor> getOneWayDoorCollection() {
        return oneWayDoorCollection;
    }
}

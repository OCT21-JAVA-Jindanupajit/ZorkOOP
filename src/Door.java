import java.util.ArrayList;


public class Door {
    private final ArrayList<OneWayDoor> oneWayDorCollection = new ArrayList<>();

    public Door() {
    }



    public Room getDestination() {
    // if only one door return that room
        if (oneWayDorCollection.size() == 1)
            return oneWayDorCollection.get(0).getDestination();
        else
            return null;

    }

    public Room getDestination(int index) {
        if (index < 0)
            return null;
        else if (oneWayDorCollection.size() > index)
            return oneWayDorCollection.get(index).getDestination();
        else
            return null;
    }

    public ArrayList<OneWayDoor> getOneWayDorCollection() {
        return oneWayDorCollection;
    }
}

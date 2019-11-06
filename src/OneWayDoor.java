public class OneWayDoor {

    private Room destination;
    private boolean opened;

    public OneWayDoor() {

        this.destination = new Room();
        this.opened = true;
    }

    public OneWayDoor(Room destination) {

        this.destination = destination;
        this.opened = true;
    }

    public OneWayDoor(Room destination, boolean opened) {

        this.destination = destination;
        this.opened = opened;
    }

    public Room getDestination() {
        return destination;
    }

    public void setDestination(Room destination) {
        this.destination = destination;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "OneWayDoor{" +
                ", destination=" + destination +
                ", opened=" + opened +
                '}';
    }
}

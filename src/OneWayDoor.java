public class OneWayDoor {
    private Room from;
    private Room destination;
    private boolean opened;

    public OneWayDoor() {
        this.from = new Room();
        this.destination = new Room();
        this.opened = true;
    }

    public OneWayDoor(Room from, Room destination) {
        this.from = from;
        this.destination = destination;
        this.opened = true;
    }

    public OneWayDoor(Room from, Room destination, boolean opened) {
        this.from = from;
        this.destination = destination;
        this.opened = opened;
    }

    public Room getFrom() {
        return from;
    }

    public void setFrom(Room from) {
        this.from = from;
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
                "from=" + from +
                ", destination=" + destination +
                ", opened=" + opened +
                '}';
    }
}

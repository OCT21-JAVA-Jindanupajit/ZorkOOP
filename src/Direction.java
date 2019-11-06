
public enum Direction {
    NORTH ("North"),
    SOUTH ("South"),
    EAST ("East"),
    WEST ("West");

    private String label;
    Direction(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }


}

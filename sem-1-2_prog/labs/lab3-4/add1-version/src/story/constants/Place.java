package story.constants;

public enum Place {
    SINK("раковина"),
    ROAD("дорога"),
    SCENE("сцена"),
    KATALAJKA("каталажка");

    private final String description;

    Place(String description) {
        this.description = description;
    }

    public String toPrint() {
        return description;
    }

    @Override
    public String toString() {
        return this.name();
    }
    // hashCode нельзя переопределеить - final
    // equals нельзя переопределеить - final
}

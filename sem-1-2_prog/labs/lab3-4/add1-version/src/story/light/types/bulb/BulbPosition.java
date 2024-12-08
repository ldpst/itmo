package story.light.types.bulb;

public enum BulbPosition {
    HIGH("высоко"),
    LOW("низко"),
    MID("по средине");

    private final String description;

    BulbPosition(String description) {
        this.description = description;
    }

    public String toPrint() {
        return description;
    }

    @Override
    public String toString() {
        return this.name();
    }
}

package story.constants;

public enum Place {
    SINK,
    ROAD,
    SCENE;

    public String toPrint() {
        if (this.name().equals("SCENE")) {
            return "сцена";
        }
        if (this.name().equals("ROAD")) {
            return "дорога";
        }
        if (this.name().equals("SINK")) {
            return "раковина";
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
    // hashCode нельзя переопределеить - final
    // equals нельзя переопределеить - final
}

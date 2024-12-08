package story.constants;

public enum Mood {
    GLAD("захохотал"),
    ANGRY("злится"),
    HAPPY("стал счастлив"),
    SAD("загрустил");

    private final String description;
    Mood(String description) {
        this.description = description;
    }

    public String describe() {
        return description;
    }

    @Override
    public String toString() {
        return this.name();
    }
    // hashCode нельзя переопределеить - final
    // equals нельзя переопределеить - final
}

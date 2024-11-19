package story.constants;

public enum Mood {
    GLAD,
    ANGRY,
    HAPPY,
    SAD;

    @Override
    public String toString() {
        return this.name();
    }
    // hashCode нельзя переопределеить - final
    // equals нельзя переопределеить - final
}

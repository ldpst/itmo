package story.constants;

public enum Imagination {
    GREATPERSON("воображают себя какими-нибудь великими личностями, знаменитостями или отважными путешественниками"),
    HERO("воображают себя какими-нибудь героями: суперменами или бетманами"),
    SPORTSMAN("воображают себя какими-нибудь спорсменами: бегунами или шахматистами");

    private final String description;
    Imagination(String description) {
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

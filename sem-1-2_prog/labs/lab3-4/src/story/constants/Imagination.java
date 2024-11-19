package story.constants;

public enum Imagination {
    GREATPERSON,
    HERO,
    SPORTSMAN;

    public String toPrint() {
        if (this.name().equals("GREATPERSON")) {
            return " воображают себя какими-нибудь великими личностями, знаменитостями или отважными путешественниками";
        } else if (this.name().equals("HERO")) {
            return " воображают себя какими-нибудь героями: суперменами или бетманами";
        } else if (this.name().equals("SPORTSMAN")) {
            return " воображают себя какими-нибудь спорсменами: бегунами или шахматистами";
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

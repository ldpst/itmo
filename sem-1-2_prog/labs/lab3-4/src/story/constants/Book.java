package story.constants;

public enum Book {
    SUN("за Солнцем есть какие-то огромные планеты и звезды, на которых тоже якобы живут коротышки."),
    MOON("за наружной Луной есть какие-то огромные планеты и звезды, на которых тоже якобы живут коротышки."),
    PLANETS("за нашими планетами есть какие-то другие огромные планеты и звезды, на которых тоже якобы живут коротышки.");

    private final String description;
    Book(String description) {
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

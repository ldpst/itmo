package story;

public enum Book {
    SUN,
    MOON,
    PLANETS;

    public String toPrint() {
        if (this.name().equals("SUN")) {
            return "за Солнцем есть какие-то огромные планеты и звезды, на которых тоже якобы живут коротышки.";
        } else if (this.name().equals("MOON")) {
            return "за наружной Луной есть какие-то огромные планеты и звезды, на которых тоже якобы живут коротышки.";
        } else if (this.name().equals("PLANETS")) {
            return "за нашими планетами есть какие-то другие огромные планеты и звезды, на которых тоже якобы живут коротышки.";
        }
        return null;
    }

}

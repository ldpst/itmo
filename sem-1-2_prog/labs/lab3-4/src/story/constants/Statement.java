package story.constants;

import story.person.shorty.Shorty;

public enum Statement {
    POLICE("нарочно придумывает разные небылицы, чтоб сбить с толку полицию"),
    FOOL("попросту дурачок и болтает, что придет в голову"),
    CRAZY("сумасшедший"),
    BOOKS(", должно быть, свихнулся с ума, начитавшись книжек. А в книжках на самом деле сказано: %s Вот он и вообразил, наверно, что прилетел к нам с такой планеты");

    private final String description;
    Statement(String description) {
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

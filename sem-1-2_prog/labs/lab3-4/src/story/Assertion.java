package story;

public enum Assertion {
    POLICE,
    FOOL,
    CRAZY,
    BOOKS;

    public String toPrint(Shorty shorty) {
        if (this.name().equals("POLICE")) {
            return shorty.getName() + " нарочно придумывает разные небылицы, чтоб сбить с толку полицию";
        } else if (this.name().equals("CRAZY")) {
            return shorty.getName() + " сумасшедший";
        } else if (this.name().equals("BOOKS")) {
            return shorty.getName() + ", должно быть, свихнулся с ума, начитавшись книжек. А в книжках на самом деле сказано: %s Вот он и вообразил, наверно, что прилетел к нам с такой планеты";
        } else if (this.name().equals("FOOL")) {
            return shorty.getName() + " попросту дурачок и болтает, что придет в голову";
        }
        return null;
    }
}

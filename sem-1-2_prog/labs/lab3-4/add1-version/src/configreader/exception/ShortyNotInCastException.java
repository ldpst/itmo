package configreader.exception;

public class ShortyNotInCastException extends RuntimeException {
    private final String STRUCTURE;

    public ShortyNotInCastException(String structure) {
        super();
        STRUCTURE = structure;
    }

    @Override
    public String getMessage() {
        return "Введённый " + STRUCTURE + " отсутсвует в Cast.";
    }
}

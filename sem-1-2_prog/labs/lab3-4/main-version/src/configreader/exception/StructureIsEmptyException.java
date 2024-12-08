package configreader.exception;

public class StructureIsEmptyException extends RuntimeException {
    private final String STRUCTURE;
    public StructureIsEmptyException(String structure) {
        super();
        STRUCTURE = structure;
    }
    @Override
    public String getMessage() {
        return "Введёный " + STRUCTURE + " пуст.";
    }
}

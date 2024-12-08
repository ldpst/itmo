package configreader.exception;

public class WrongFormatException extends RuntimeException {
    private final String ERRORPOSITION;
    private final String STRUCTURE;

    public WrongFormatException(String structure, String errorPosition) {
        super();
        STRUCTURE = structure;
        ERRORPOSITION = errorPosition;
    }

    @Override
    public String getMessage() {
        return "Введёный " + STRUCTURE + " неверного формата. Примерное место ошибки: " + ERRORPOSITION;
    }
}

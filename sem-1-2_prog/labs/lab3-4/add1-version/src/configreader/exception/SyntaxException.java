package configreader.exception;

public class SyntaxException extends RuntimeException {
    private final String ERRORPOSITION;
    public SyntaxException(String errorPosition) {
        super();
        ERRORPOSITION = errorPosition;
    }

    @Override
    public String getMessage() {
        return "Синтаксическая ошибка: " + ERRORPOSITION + " не распознано.";
    }
}

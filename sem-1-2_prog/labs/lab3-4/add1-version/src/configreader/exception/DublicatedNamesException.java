package configreader.exception;

public class DublicatedNamesException extends RuntimeException {
  private final String STRUCTURE;

  public DublicatedNamesException(String structure) {
    super();
    STRUCTURE = structure;
  }

  @Override
  public String getMessage() {
    return "В введённом " + STRUCTURE + " присутствуют повторяющиеся значения.";
  }
}

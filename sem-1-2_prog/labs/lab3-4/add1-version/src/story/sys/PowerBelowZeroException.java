package story.sys;

public class PowerBelowZeroException extends RuntimeException {
    private final String action;
    public PowerBelowZeroException(String action) {
        super();
        this.action = action;
    }

    @Override
    public String getMessage() {
        return "Введёная сила " + action + " ниже нуля";
    }
}

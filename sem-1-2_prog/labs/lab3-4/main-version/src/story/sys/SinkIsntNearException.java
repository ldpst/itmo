package story.sys;

public class SinkIsntNearException extends Exception {
    public SinkIsntNearException() {
        super();
    }
    @Override
    public String getMessage() {
        return "Не может умыться. Персонаж находится не у раковины.";
    }
}

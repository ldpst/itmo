package story.sys;

public class ShortyInMoreThanOneTeamException extends RuntimeException {
    private final String SHORTYNAME;

    public ShortyInMoreThanOneTeamException(String shortyName) {
        super();
        SHORTYNAME = shortyName;
    }

    @Override
    public String getMessage() {
        return SHORTYNAME + " has more than one team";
    }
}

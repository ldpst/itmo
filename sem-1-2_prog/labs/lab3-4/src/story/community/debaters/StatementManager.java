package story.community.debaters;

import story.statementable.Statementable;
import story.sys.Time;

public class StatementManager implements Statementable {
    private Debaters debaters;
    public StatementManager(Debaters debaters) {
        this.debaters = debaters;
    }

    public void statementAbout(story.constants.Statement statement) {
        debaters.setOpinion(statement);
        System.out.println(debaters.getCommaSeparatedNames() + " утверждают: " + statement.toPrint(debaters.getStatementAim()) + ".");
        Time.sleep(1);
    }
}

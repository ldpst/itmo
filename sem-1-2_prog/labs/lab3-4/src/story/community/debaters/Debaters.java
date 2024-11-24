package story.community.debaters;

import story.sys.Time;
import story.community.Community;
import story.person.shorty.Shorty;

import java.util.ArrayList;
import java.util.List;

public class Debaters extends Community {
    private List<Shorty> opponents = new ArrayList<Shorty>();
    private story.constants.Statement opinion;
    private Shorty statementAim;

    private StatementManager statementManager;

    public Debaters(List<Shorty> members, Shorty statementAim) {
        super(members);
        this.statementAim = statementAim;
        createManagers();
    }

    public Debaters(List<Shorty> members) {
        super(members);
        createManagers();
    }

    public Debaters() {
        super();
        createManagers();
    }

    private void createManagers() {
        this.statementManager = new StatementManager(this);
    }

    public void addOpponent(Debaters opponent) {
        this.opponents.addAll(opponent.getMembers());
        System.out.println(this.getCommaSeparatedNames() + " спорят с " + opponent.getCommaSeparatedNames() + ".");
        Time.sleep(1);
    }

    public void removeOpponent(Shorty opponent) {
        this.opponents.remove(opponent);
    }

    public void setOpinion(story.constants.Statement opinion) {
        this.opinion = opinion;
    }

    public List<Shorty> getOpponents() {
        return opponents;
    }

    public String getOppinion() {
        return this.statementAim + " " + opinion.toPrint();
    }

    public StatementManager getStatementManager() {
        return statementManager;
    }

    public Shorty getStatementAim() {
        return statementAim;
    }
}

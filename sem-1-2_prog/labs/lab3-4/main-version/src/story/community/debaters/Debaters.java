package story.community.debaters;

import story.constants.Statement;
import story.statementable.Statementable;
import story.community.Community;
import story.person.shorty.Shorty;
import story.sys.ShortyInMoreThanOneTeamException;

import java.util.ArrayList;
import java.util.List;

public class Debaters extends Community implements Statementable {
    private List<Shorty> opponents = new ArrayList<Shorty>();
    private story.constants.Statement opinion;
    private Shorty statementAim;

    public Debaters(List<Shorty> members, Shorty statementAim) {
        super(members);
        this.statementAim = statementAim;
    }

    public Debaters() {
        super();
    }

    public void addOpponent(Debaters opponent) throws ShortyInMoreThanOneTeamException {
        List<Shorty> opponentMembers = opponent.getMembers();
        for (Shorty opponentMember : opponentMembers) {
            String found = null;
            for (Shorty member : this.getMembers()) {
                if (member.equals(opponentMember)) {
                    found = member.getName();
                }
            }
            if (found != null) {
                throw new ShortyInMoreThanOneTeamException(found);
            }
            this.opponents.add(opponentMember);
        }
        System.out.println(this.getCommaSeparatedNames() + " спорят с " + opponent.getCommaSeparatedNames() + ".");
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

    public Shorty getStatementAim() {
        return statementAim;
    }

    @Override
    public void statementAbout(Statement statement) {
        System.out.println(this.getCommaSeparatedNames() + " утверждают: " + this.getStatementAim() + " " + statement.toPrint() + ".");
    }
}

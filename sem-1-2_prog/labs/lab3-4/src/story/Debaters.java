package story;

import java.util.ArrayList;
import java.util.List;

public class Debaters extends Community implements Assertionable {
    private List<Shorty> opponents = new ArrayList<Shorty>();
    private Assertion opinion;
    private Shorty assertionAim = new Shorty("Neznaika");

    public Debaters(List<Shorty> members, Shorty assertionAim) {
        super(members);
        this.assertionAim = assertionAim;
    }

    public Debaters(List<Shorty> members) {
        super(members);
    }

    public Debaters() {
        super();
    }

    public void argueWith(Debaters opponent) {
        this.opponents.addAll(opponent.getMembers());
        System.out.println(this.getCommaSeparatedNames() + " спорят с " + opponent.getCommaSeparatedNames() + ".");
        Time.sleep(1);
    }

    public void removeOpponent(Shorty opponent) {
        this.opponents.remove(opponent);
    }

    @Override
    public void assertAbout(Assertion assertion) {
        opinion = assertion;
        System.out.println(this.getCommaSeparatedNames() + " утверждают: " + assertion.toPrint(this.assertionAim) + ".");
        Time.sleep(1);
    }

    public List<Shorty> getOpponents() {
        return opponents;
    }

    public String getOppinion() {
        return opinion.toPrint(this.assertionAim);
    }
}

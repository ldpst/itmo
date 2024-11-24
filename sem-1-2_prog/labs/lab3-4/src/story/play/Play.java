package story.play;

import story.community.Community;
import story.community.debaters.Debaters;
import story.constants.Statement;
import story.person.crazyman.Crazyman;
import story.person.shorty.Shorty;
import story.person.someonewithoutshirt.SomeoneWithoutShirt;
import story.scene.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Play {
    private Scene scene;

    private EmoteManager emoteManager;
    private PlaceManager placeManager;
    private WashManager washManager;
    private ArgueManager argueManager;
    private StatementManager statementManager;

    public Play(Scene scene) {
        this.scene = scene;
        this.emoteManager = new EmoteManager(scene);
        this.placeManager = new PlaceManager(scene);
        this.washManager = new WashManager(scene);
        this.argueManager = new ArgueManager(scene);
        this.statementManager = new StatementManager(scene);
    }
    public void go() {
        Community everyone = new Community(scene.getCast());
        this.getEmoteManager().emote(everyone);
        PrintHelperManager.nextLine();

        this.getPlaceManager().goTo();
        PrintHelperManager.nextLine();

        this.getWashManager().washUp();
        PrintHelperManager.nextLine();

        List<Shorty> randomSeq = everyone.getMembers();
        Collections.shuffle(randomSeq);
        List<Shorty> groupPoliceList = new ArrayList<Shorty>();
        List<Shorty> groupFoolList = new ArrayList<Shorty>();
        List<Shorty> groupCrazyList = new ArrayList<Shorty>();
        for (int i = 0; i < randomSeq.size(); i++) {
            if (!randomSeq.get(i).equals(scene.getStatementAim())) {
                if (groupPoliceList.size() < (randomSeq.size() - 1) / 3) {
                    groupPoliceList.add(randomSeq.get(i));
                } else if (groupFoolList.size() < (randomSeq.size() - 1) / 3) {
                    groupFoolList.add(randomSeq.get(i));
                } else if (groupCrazyList.size() < (randomSeq.size() - 1) / 3) {
                    groupCrazyList.add(randomSeq.get(i));
                }
            }
        }
        Debaters groupPolice = new Debaters(groupPoliceList, scene.getStatementAim());
        Debaters groupFool = new Debaters(groupFoolList, scene.getStatementAim());
        Debaters groupCrazy = new Debaters(groupCrazyList, scene.getStatementAim());

        this.getArgueManager().argue(groupPolice, groupFool);
        this.getArgueManager().argue(groupCrazy, groupFool);
        this.getArgueManager().argue(groupPolice, groupCrazy);
        PrintHelperManager.nextLine();

        this.getStatementManager().statementAbout(groupPolice, Statement.POLICE);
        this.getStatementManager().statementAbout(groupFool, Statement.FOOL);
        this.getStatementManager().statementAbout(groupCrazy, Statement.CRAZY);
        PrintHelperManager.nextLine();

        SomeoneWithoutShirt.getStatementManager().statementAbout(scene.getStatementAim(), Statement.BOOKS, scene.getStatementAimsBook());
        PrintHelperManager.nextLine();

        Crazyman.getImagineManager().imagine(scene.getCrazymansIdeology());
    }

    public EmoteManager getEmoteManager() {
        return emoteManager;
    }

    public PlaceManager getPlaceManager() {
        return placeManager;
    }

    public WashManager getWashManager() {
        return washManager;
    }

    public ArgueManager getArgueManager() {
        return argueManager;
    }

    public StatementManager getStatementManager() {
        return statementManager;
    }
}

package story.play;

import story.community.Community;
import story.community.debaters.Debaters;
import story.constants.Mood;
import story.constants.Place;
import story.constants.Statement;
import story.person.crazyman.Crazyman;
import story.person.shorty.Emotable;
import story.person.shorty.Movable;
import story.person.shorty.Shorty;
import story.person.shorty.Washable;
import story.person.someonewithoutshirt.SomeoneWithoutShirt;
import story.scene.Scene;
import story.sys.SinkIsntNearException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Play implements Washable, Arguable, Movable, Emotable {
    private Scene scene;

    public Play(Scene scene) {
        this.scene = scene;
    }

    public void go() {
        Community everyone = new Community(scene.getCast());
        this.emote(scene.getCast());
        PrintHelperManager.nextLine();

        this.goTo(scene.getGoToThisPlace());
        PrintHelperManager.nextLine();

        this.washUp();
        PrintHelperManager.nextLine();

        Debaters[] groups = makeRandomDebaters();
        Debaters groupPolice = groups[0];
        Debaters groupFool = groups[1];
        Debaters groupCrazy = groups[2];

        this.argue(groupPolice, groupFool);
        this.argue(groupCrazy, groupFool);
        this.argue(groupPolice, groupCrazy);
        PrintHelperManager.nextLine();

        groupPolice.statementAbout(Statement.POLICE);
        groupFool.statementAbout(Statement.FOOL);
        groupCrazy.statementAbout(Statement.CRAZY);
        PrintHelperManager.nextLine();

        SomeoneWithoutShirt.statementAbout(scene.getStatementAim(), Statement.BOOKS, scene.getStatementAimsBook());
        PrintHelperManager.nextLine();

        Crazyman.imagine(scene.getCrazymansIdeology());
    }

    @Override
    public void goTo(Place place) {
        this.scene.getSlacker().goTo(place);
    }

    @Override
    public void washUp() {
        try {
            scene.getSlacker().washUp();
        } catch (SinkIsntNearException e) {
            System.out.println(e.getMessage());
        }
    }

    private Debaters[] makeRandomDebaters() {
        List<Shorty> randomSeq = scene.getCast();
        Collections.shuffle(randomSeq);
        List<Shorty> groupPoliceList = new ArrayList<Shorty>();
        List<Shorty> groupFoolList = new ArrayList<Shorty>();
        List<Shorty> groupCrazyList = new ArrayList<Shorty>();
        for (int i = 0; i < randomSeq.size(); i++) {
            if (!randomSeq.get(i).equals(scene.getStatementAim())) {
                if (groupPoliceList.size() < ((randomSeq.size() - 1) / 3 + (((randomSeq.size() - 1) % 3 > 0) ? 1 : 0))) {
                    groupPoliceList.add(randomSeq.get(i));
                } else if (groupFoolList.size() < ((randomSeq.size() - 1) / 3 + (((randomSeq.size() - 1) % 3 > 1) ? 1 : 0))) {
                    groupFoolList.add(randomSeq.get(i));
                } else if (groupCrazyList.size() < (randomSeq.size() - 1) / 3) {
                    groupCrazyList.add(randomSeq.get(i));
                }
            }
        }
        return new Debaters[]{new Debaters(groupPoliceList, scene.getStatementAim()), new Debaters(groupFoolList, scene.getStatementAim()), new Debaters(groupCrazyList, scene.getStatementAim())};
    }

    public void emote(List<Shorty> members) {
        for (Shorty member : members) {
            if (scene.getRandomEmotions()) {
                randomEmote(member);
            } else {
                member.emote(Mood.GLAD);
            }
        }
    }

    private void randomEmote(Shorty shorty) {
        int rnd = (int) (Math.random() * Mood.values().length);
        shorty.emote(Mood.values()[rnd]);
    }
}

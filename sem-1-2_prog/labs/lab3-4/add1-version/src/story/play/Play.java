package story.play;

import story.community.Community;
import story.community.debaters.Debaters;
import story.constants.Mood;
import story.constants.Place;
import story.constants.Statement;
import story.light.types.bulb.Bulb;
import story.person.crazyman.Crazyman;
import story.person.shorty.Emotable;
import story.person.shorty.Movable;
import story.person.shorty.Shorty;
import story.person.shorty.Washable;
import story.person.someonewithoutshirt.SomeoneWithoutShirt;
import story.premises.room.Room;
import story.premises.room.lightableroom.LightableRoom;
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
        this.scene.room().setCountOfWindows(scene.countOfWindows());
        System.out.println();

        this.scene.room().setBulb(new Bulb());
        this.scene.room().bulb.setPosition(scene.bulbPosition());
        this.scene.room().bulb.setPower(scene.bulbPower());
        System.out.println();

        this.goTo(scene.katalajka());
        if (!(scene.doorClosed())) {
            scene.room().door.close(scene.closePower());
        }
        else {
            scene.room().door.open(scene.closePower());
        }

        this.emote(scene.cast());
        System.out.println();

        this.goTo(scene.goToThisPlace());
        System.out.println();

        this.washUp();
        System.out.println();

        Debaters[] groups = makeRandomDebaters();
        Debaters groupPolice = groups[0];
        Debaters groupFool = groups[1];
        Debaters groupCrazy = groups[2];

        this.argue(groupPolice, groupFool);
        this.argue(groupCrazy, groupFool);
        this.argue(groupPolice, groupCrazy);
        System.out.println();

        groupPolice.statementAbout(Statement.POLICE);
        groupFool.statementAbout(Statement.FOOL);
        groupCrazy.statementAbout(Statement.CRAZY);
        System.out.println();

        SomeoneWithoutShirt.statementAbout(scene.statementAim(), Statement.BOOKS, scene.statementAimsBook());
        System.out.println();

        Crazyman.imagine(scene.crazymansIdeology());
    }

    @Override
    public void goTo(Place place) {
        this.scene.slacker().goTo(place);
    }

    @Override
    public void washUp() {
        try {
            scene.slacker().washUp();
        } catch (SinkIsntNearException e) {
            System.out.println(e.getMessage());
        }
    }

    private Debaters[] makeRandomDebaters() {
        List<Shorty> randomSeq = scene.cast();
        Collections.shuffle(randomSeq);
        List<Shorty> groupPoliceList = new ArrayList<Shorty>();
        List<Shorty> groupFoolList = new ArrayList<Shorty>();
        List<Shorty> groupCrazyList = new ArrayList<Shorty>();
        for (int i = 0; i < randomSeq.size(); i++) {
            if (!randomSeq.get(i).equals(scene.statementAim())) {
                if (groupPoliceList.size() < ((randomSeq.size() - 1) / 3 + (((randomSeq.size() - 1) % 3 > 0) ? 1 : 0))) {
                    groupPoliceList.add(randomSeq.get(i));
                } else if (groupFoolList.size() < ((randomSeq.size() - 1) / 3 + (((randomSeq.size() - 1) % 3 > 1) ? 1 : 0))) {
                    groupFoolList.add(randomSeq.get(i));
                } else if (groupCrazyList.size() < (randomSeq.size() - 1) / 3) {
                    groupCrazyList.add(randomSeq.get(i));
                }
            }
        }
        return new Debaters[]{new Debaters(groupPoliceList, scene.statementAim()), new Debaters(groupFoolList, scene.statementAim()), new Debaters(groupCrazyList, scene.statementAim())};
    }

    public void emote(List<Shorty> members) {
        for (Shorty member : members) {
            if (scene.randomEmotions()) {
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

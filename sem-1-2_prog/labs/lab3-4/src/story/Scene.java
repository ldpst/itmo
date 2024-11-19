package story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scene {
    List<Shorty> cast = new ArrayList<Shorty>();
    boolean randomEmotions = false;
    Shorty neznaika;
    Place goToThisPlace;
    Shorty assertionAim;
    Book assertionAimsBook;
    Imagination crazymansIdeology;

    public Scene(List<Shorty> cast, boolean randomEmotions, Shorty neznaika, Place goToThisPlace, Shorty assertionAim, Book assertionAimsBook, Imagination crazymansIdeology) {
        this.cast = cast;
        this.randomEmotions = randomEmotions;
        this.neznaika = neznaika;
        this.goToThisPlace = goToThisPlace;
        this.assertionAim = assertionAim;
        this.assertionAimsBook = assertionAimsBook;
        this.crazymansIdeology = crazymansIdeology;
    }

    public Scene(List<Shorty> cast) {
        this.cast = cast;
    }

    public Scene() {
    }

    public void play() {
        Community everyone = new Community(this.cast);
        this.emote(everyone);
        nextLine();

        this.move(this.neznaika, goToThisPlace);
        nextLine();

        this.whashUp(this.neznaika);
        nextLine();

        List<Shorty> randomSeq = everyone.getMembers();
        Collections.shuffle(randomSeq);
        List<Shorty> groupPoliceList = new ArrayList<Shorty>();
        List<Shorty> groupFoolList = new ArrayList<Shorty>();
        List<Shorty> groupCrazyList = new ArrayList<Shorty>();
        for (int i = 0; i < randomSeq.size(); i++) {
            if (!randomSeq.get(i).equals(this.assertionAim)) {
                if (groupPoliceList.size() < (randomSeq.size() - 1) / 3) {
                    groupPoliceList.add(randomSeq.get(i));
                } else if (groupFoolList.size() < (randomSeq.size() - 1) / 3) {
                    groupFoolList.add(randomSeq.get(i));
                } else if (groupCrazyList.size() < (randomSeq.size() - 1) / 3) {
                    groupCrazyList.add(randomSeq.get(i));
                }
            }
        }
        Debaters groupPolice = new Debaters(groupPoliceList, this.assertionAim);
        Debaters groupFool = new Debaters(groupFoolList, this.assertionAim);
        Debaters groupCrazy = new Debaters(groupCrazyList, this.assertionAim);

        this.argue(groupPolice, groupFool);
        this.argue(groupCrazy, groupFool);
        this.argue(groupPolice, groupCrazy);
        nextLine();

        this.assertAbout(groupPolice, Assertion.POLICE);
        this.assertAbout(groupFool, Assertion.FOOL);
        this.assertAbout(groupCrazy, Assertion.CRAZY);
        nextLine();

        SomeoneWithoutShirt.assertAbout(assertionAim, Assertion.BOOKS, assertionAimsBook);
        nextLine();

        Crazyman.imagine(crazymansIdeology);
    }

    public void setRandomEmotions(boolean randomEmotions) {
        this.randomEmotions = randomEmotions;
    }

    public void addToCast(Shorty shorty) {
        this.cast.add(shorty);
    }

    public void addToCast(List<Shorty> cast) {
        this.cast.addAll(cast);
    }

    public void setNeznaika(Shorty neznaika) {
        this.neznaika = neznaika;
    }

    public void setAssertionAim(Shorty assertionAim) {
        this.assertionAim = assertionAim;
    }

    public void setAssertionAimsBook(Book book) {
        this.assertionAimsBook = book;
    }

    public void setCrazymansIdeology(Imagination imagination) {
        this.crazymansIdeology = imagination;
    }

    public void nextLine() {
        System.out.println();
        Time.sleep(1);
    }

    public void setGoToThisPlace(Place place) {
        this.goToThisPlace = place;
    }

    private void assertAbout(Debaters debaters, Assertion assertion) {
        debaters.assertAbout(assertion);
    }

    private void argue(Debaters deb1, Debaters deb2) {
        deb1.argueWith(deb2);
        deb2.argueWith(deb1);
    }

    private void whashUp(Shorty shorty) {
        try {
            shorty.whashUp();
        } catch (SinkIsntNearException e) {
            System.out.println(e.getMessage());
        }
    }

    private void move(Shorty shorty, Place goToThisPlace) {
        shorty.goTo(goToThisPlace);
    }

    private void emote(Community community) {
        List<Shorty> members = community.getMembers();
        for (Shorty member : members) {
            emote(member);
        }
    }

    private void randomEmote(Shorty shorty) {
        int rnd = (int) (Math.random() * 4) + 1;
        if (rnd == 1) {
            shorty.laught();
        } else if (rnd == 2) {
            shorty.rage();
        } else if (rnd == 3) {
            shorty.beHappy();
        } else if (rnd == 4) {
            shorty.beSad();
        }
    }

    private void emote(Shorty shorty) {
        if (randomEmotions) {
            randomEmote(shorty);
        } else {
            shorty.laught();
        }
    }
}

package story.scene;

import story.constants.Book;
import story.constants.Imagination;
import story.constants.Place;
import story.person.shorty.Shorty;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<Shorty> cast = new ArrayList<Shorty>();
    private boolean randomEmotions = false;
    private Shorty slacker;
    private Place goToThisPlace;
    private Shorty statementAim;
    private Book statementAimsBook;
    private Imagination crazymansIdeology;

    public Scene(List<Shorty> cast, boolean randomEmotions, Shorty slacker, Place goToThisPlace, Shorty statementAim, Book statementAimsBook, Imagination crazymansIdeology) {
        this.cast = cast;
        this.randomEmotions = randomEmotions;
        this.slacker = slacker;
        this.goToThisPlace = goToThisPlace;
        this.statementAim = statementAim;
        this.statementAimsBook = statementAimsBook;
        this.crazymansIdeology = crazymansIdeology;
    }

    public Scene(List<Shorty> cast) {
        this.cast = cast;
    }

    public Scene() {
    }


    public void setRandomEmotions(boolean randomEmotions) {
        this.randomEmotions = randomEmotions;
    }

    public void setCast(List<Shorty> cast) {
        this.cast = cast;
    }

    public void setSlacker(Shorty slacker) {
        this.slacker = slacker;
    }

    public void setStatementAim(Shorty statementAim) {
        this.statementAim = statementAim;
    }

    public Shorty getStatementAim() {
        return statementAim;
    }

    public void setStatementAimsBook(Book book) {
        this.statementAimsBook = book;
    }

    public Book getStatementAimsBook() {
        return statementAimsBook;
    }

    public void setCrazymansIdeology(Imagination imagination) {
        this.crazymansIdeology = imagination;
    }

    public Imagination getCrazymansIdeology() {
        return crazymansIdeology;
    }

    public void setGoToThisPlace(Place place) {
        this.goToThisPlace = place;
    }

    public List<Shorty> getCast() {
        return cast;
    }

    public Place getGoToThisPlace() {
        return this.goToThisPlace;
    }

    public boolean getRandomEmotions() {
        return this.randomEmotions;
    }

    public Shorty getSlacker() {
        return this.slacker;
    }
}

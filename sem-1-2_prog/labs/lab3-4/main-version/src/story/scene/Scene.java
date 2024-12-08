package story.scene;

import story.constants.Book;
import story.constants.Imagination;
import story.constants.Place;
import story.person.shorty.Shorty;

import java.util.ArrayList;
import java.util.List;

public record Scene(List<Shorty> cast, boolean randomEmotions, Shorty slacker, Place goToThisPlace, Shorty statementAim, Book statementAimsBook, Imagination crazymansIdeology) {

    public Scene(List<Shorty> cast, boolean randomEmotions, Shorty slacker, Place goToThisPlace, Shorty statementAim, Book statementAimsBook, Imagination crazymansIdeology) {
        this.cast = cast;
        this.randomEmotions = randomEmotions;
        this.slacker = slacker;
        this.goToThisPlace = goToThisPlace;
        this.statementAim = statementAim;
        this.statementAimsBook = statementAimsBook;
        this.crazymansIdeology = crazymansIdeology;
    }



    public Shorty getStatementAim() {
        return statementAim;
    }

    public Book getStatementAimsBook() {
        return statementAimsBook;
    }

    public Imagination getCrazymansIdeology() {
        return crazymansIdeology;
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

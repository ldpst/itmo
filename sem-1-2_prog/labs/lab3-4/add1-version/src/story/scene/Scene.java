package story.scene;

import story.constants.Book;
import story.constants.Imagination;
import story.constants.Place;
import story.light.types.bulb.Bulb;
import story.light.types.bulb.BulbPosition;
import story.person.shorty.Shorty;
import story.premises.room.lightableroom.LightableRoom;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;

public record Scene(List<Shorty> cast, boolean randomEmotions, Shorty slacker, Place goToThisPlace, Shorty statementAim,
                    Book statementAimsBook, Imagination crazymansIdeology, Place katalajka, int countOfWindows, BulbPosition bulbPosition, int bulbPower, boolean doorClosed, int closePower, LightableRoom room) {
    public Scene(List<Shorty> cast, boolean randomEmotions, Shorty slacker, Place goToThisPlace, Shorty statementAim,
                 Book statementAimsBook, Imagination crazymansIdeology, Place place, int countOfWindows, BulbPosition bulbPosition, int bulbPower, boolean doorClosed, int closePower) {
        this(cast, randomEmotions, slacker, goToThisPlace, statementAim, statementAimsBook, crazymansIdeology, place, countOfWindows, bulbPosition, bulbPower, doorClosed, closePower, new LightableRoom(place.toPrint()));
    }
}

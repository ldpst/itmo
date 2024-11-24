package story.person.shorty;

import story.constants.Place;
import story.sys.Time;

public class PlaceManager {
    Shorty shorty;

    public PlaceManager(Shorty shorty) {
        this.shorty = shorty;
    }

    public void goTo(Place place) {
        System.out.println(shorty.getName() + " подошёл к " + place.toPrint() + ".");
        Time.sleep(1);
        shorty.setPlace(place);
    }
}

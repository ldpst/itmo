package story.person.shorty;

import story.sys.Time;
import story.constants.Place;
import story.sys.SinkIsntNearException;

public class WashManager {
    Shorty shorty;
    public WashManager(Shorty shorty) {
        this.shorty = shorty;
    }
    public void washUp() throws SinkIsntNearException {
        System.out.println(shorty.getName() + " пытается умыться:");
        Time.sleep(1);
        if (isNearSink(shorty)) {
            System.out.println(shorty.getName() + " успешно умылся.");
            Time.sleep(1);
            shorty.setWashed(true);
            System.out.println(shorty.getName() + " помытый.");
        } else {
            throw new SinkIsntNearException();
        }
    }

    private boolean isNearSink(Shorty shorty) {
        return shorty.getPlace() == Place.SINK;
    }

    public void getDirty() {
        System.out.println(shorty.getName() + " испачкался.");
        Time.sleep(1);
        shorty.setWashed(false);
    }
}

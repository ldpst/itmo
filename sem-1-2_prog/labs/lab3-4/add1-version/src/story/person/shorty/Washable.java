package story.person.shorty;

import story.sys.SinkIsntNearException;

public interface Washable {
    default void washUp() throws SinkIsntNearException {
        System.out.println("Washing up");
    }
}

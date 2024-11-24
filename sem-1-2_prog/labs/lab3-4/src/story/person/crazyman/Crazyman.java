package story.person.crazyman;

import story.constants.Imagination;
import story.person.Person;

public abstract class Crazyman extends Person {
    static private Imagination ideology;
    static private final ImagineManager IMAGINE_MANAGER = new ImagineManager();

    public Crazyman(String name, int age) {
        super(name, age);
    }

    static public void setIdeology(Imagination ideology) {
        Crazyman.ideology = ideology;
    }

    public static ImagineManager getImagineManager() {
        return IMAGINE_MANAGER;
    }
}

package story.crazyman;

import story.constants.Imagination;

public abstract class Crazyman {
    static private Imagination ideology;
    static private final ImagineManager IMAGINE_MANAGER = new ImagineManager();

    static public void setIdeology(Imagination ideology) {
        Crazyman.ideology = ideology;
    }

    public static ImagineManager getImagineManager() {
        return IMAGINE_MANAGER;
    }
}

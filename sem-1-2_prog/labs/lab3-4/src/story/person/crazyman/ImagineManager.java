package story.person.crazyman;

import story.constants.Imagination;

public class ImagineManager {
    public void imagine(Imagination imagination) {
        Crazyman.setIdeology(imagination);
        System.out.println("Сумасшедшие " + imagination.toPrint() + '.');
    }
}

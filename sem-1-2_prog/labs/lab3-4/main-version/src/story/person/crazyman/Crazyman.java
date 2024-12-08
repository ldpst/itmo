package story.person.crazyman;

import story.constants.Imagination;
import story.person.Person;

public abstract class Crazyman extends Person {
    static private Imagination ideology;

    public Crazyman(String name, int age) {
        super(name, age);
    }

    static void setIdeology(Imagination ideology) {
        Crazyman.ideology = ideology;
    }

    public static void imagine(Imagination imagination) {
        Crazyman.setIdeology(imagination);
        System.out.println("Сумасшедшие " + imagination.toPrint() + '.');
    }
}

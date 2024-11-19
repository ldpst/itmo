package story;

public abstract class Crazyman {
    static private Imagination ideology;

    static public void imagine(Imagination imagination) {
        ideology = imagination;
        System.out.println("Сумасшедшие" + imagination.toPrint() + '.');
    }
}

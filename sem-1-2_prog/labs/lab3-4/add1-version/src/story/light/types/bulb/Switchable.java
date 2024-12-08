package story.light.types.bulb;

public interface Switchable {
    abstract void switchPower();

    default void switchOn() {
        System.out.println("Включено");
    }

    default void switchOff() {
        System.out.println("Выключено");
    }
}

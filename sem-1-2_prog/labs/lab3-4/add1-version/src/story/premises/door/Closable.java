package story.premises.door;

public interface Closable {
    default void close() {
        System.out.println("закрылся");
    }

    default void open() {
        System.out.println("открылся");
    }
}

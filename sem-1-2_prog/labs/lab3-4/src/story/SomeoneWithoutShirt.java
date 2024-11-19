package story;

public abstract class SomeoneWithoutShirt extends Person implements Assertionable {
    static private final String NAME = "Тот, который без рубахи,";
    public SomeoneWithoutShirt() {
        super("Тот, который без рубахи,", 0);
    }

    static private Book hatedBook;

    static Book getHatedBook() {
        return hatedBook;
    }

    static public void assertAbout(Shorty assertionAim, Assertion assertion, Book book) {
        hatedBook = book;
        System.out.printf(SomeoneWithoutShirt.NAME + " утверждает: " + assertion.toPrint(assertionAim) + ".\n", book.toPrint());
    }
}

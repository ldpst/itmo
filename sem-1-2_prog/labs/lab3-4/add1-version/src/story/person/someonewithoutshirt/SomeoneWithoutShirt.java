package story.person.someonewithoutshirt;

import story.constants.Statement;
import story.person.Person;
import story.person.shorty.Shorty;
import story.statementable.Statementable;
import story.constants.Book;

import java.util.Objects;

public abstract class SomeoneWithoutShirt extends Person {
    static protected String name;
    static private Book hatedBook;
    static private Shorty statementAim;

    public SomeoneWithoutShirt(String name, int age) {
        super(name, age);
    }

    static public Book getHatedBook() {
        return hatedBook;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    static public String getSomeoneName() {
        return "Тот, который без рубахи,";
    }

    static public void setHatedBook(Book hatedBook) {
        SomeoneWithoutShirt.hatedBook = hatedBook;
    }

    static public Shorty getStatementAim() {
        return statementAim;
    }

    static public void statementAbout(Shorty statementAim, Statement statement, Book book) {
        SomeoneWithoutShirt.setHatedBook(book);
        SomeoneWithoutShirt.statementAim = statementAim;
        System.out.printf(SomeoneWithoutShirt.getSomeoneName() + " утверждает: " + statementAim + statement.toPrint() + ".\n", SomeoneWithoutShirt.getHatedBook().toPrint());
    }
}

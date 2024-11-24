package story.person.someonewithoutshirt;

import story.person.Person;
import story.statementable.Statementable;
import story.constants.Book;

import java.util.Objects;

public abstract class SomeoneWithoutShirt extends Person {
    static protected String name;
    static private Book hatedBook;
    static public StatementManager statementManager = new StatementManager();

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

    static public StatementManager getStatementManager() {
        return statementManager;
    }
}

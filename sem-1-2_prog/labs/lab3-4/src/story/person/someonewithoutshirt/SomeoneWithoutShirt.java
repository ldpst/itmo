package story.person.someonewithoutshirt;

import story.statementable.Statementable;
import story.constants.Book;

public abstract class SomeoneWithoutShirt implements Statementable {
    static private final String NAME = "Тот, который без рубахи,";
    static private Book hatedBook;
    static public StatementManager statementManager = new StatementManager();

    static public Book getHatedBook() {
        return hatedBook;
    }

    static public String getName() {
        return NAME;
    }

    static public void setHatedBook(Book hatedBook) {
        SomeoneWithoutShirt.hatedBook = hatedBook;
    }

    static public StatementManager getStatementManager() {
        return statementManager;
    }
}

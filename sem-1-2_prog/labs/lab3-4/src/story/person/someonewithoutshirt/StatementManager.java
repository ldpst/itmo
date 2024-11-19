package story.person.someonewithoutshirt;

import story.statementable.Statementable;
import story.constants.Book;
import story.constants.Statement;
import story.person.shorty.Shorty;

public class StatementManager implements Statementable {
    private Shorty statementAim;
    public void statementAbout(Shorty statementAim, Statement statement, Book book) {
        SomeoneWithoutShirt.setHatedBook(book);
        this.statementAim = statementAim;
        statementAbout(statement);
    }

    @Override
    public void statementAbout(Statement statement) {
        System.out.printf(SomeoneWithoutShirt.getName() + " утверждает: " + statement.toPrint(this.statementAim) + ".\n", SomeoneWithoutShirt.getHatedBook().toPrint());
    }
}

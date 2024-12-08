package story.statementable;

import story.constants.Statement;

public interface Statementable {
    default void statementAbout(Statement statement) {
        System.out.println("утверждает: " + statement.toString());
    }
}
package story.play;

import story.community.debaters.Debaters;
import story.constants.Statement;
import story.scene.Scene;

public class StatementManager {
    private Scene scene;

    public StatementManager(Scene scene) {
        this.scene = scene;
    }

    public void statementAbout(Debaters debaters, Statement statement) {
        debaters.getStatementManager().statementAbout(statement);
    }
}

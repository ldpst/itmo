package story.play;

import story.community.debaters.Debaters;
import story.scene.Scene;

public class ArgueManager {
    private Scene scene;

    public ArgueManager(Scene scene) {
        this.scene = scene;
    }

    public void argue(Debaters deb1, Debaters deb2) {
        deb1.addOpponent(deb2);
        deb2.addOpponent(deb1);
    }
}

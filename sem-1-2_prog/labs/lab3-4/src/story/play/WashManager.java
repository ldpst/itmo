package story.play;

import story.scene.Scene;
import story.sys.SinkIsntNearException;

public class WashManager {
    private Scene scene;
    public WashManager(Scene scene) {
        this.scene = scene;
    }
    public void washUp() {
        try {
            scene.getSlacker().getSinkManager().washUp();
        } catch (SinkIsntNearException e) {
            System.out.println(e.getMessage());
        }
    }
}

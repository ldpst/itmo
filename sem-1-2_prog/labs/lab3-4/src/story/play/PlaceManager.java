package story.play;

import story.scene.Scene;

public class PlaceManager {
    private Scene scene;

    public PlaceManager(Scene scene) {
        this.scene = scene;
    }

    public void goTo() {
        scene.getSlacker().getPlaceManager().goTo(scene.getGoToThisPlace());
    }
}

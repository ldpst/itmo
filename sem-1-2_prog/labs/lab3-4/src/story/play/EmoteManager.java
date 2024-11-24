package story.play;

import story.community.Community;
import story.constants.Mood;
import story.person.shorty.Shorty;
import story.scene.Scene;

import java.util.List;

public class EmoteManager {
    private Scene scene;

    public EmoteManager(Scene scene) {
        this.scene = scene;
    }

    public void emote(Shorty shorty) {
        if (scene.getRandomEmotions()) {
            randomEmote(shorty);
        } else {
            shorty.getMoodManager().emote(Mood.GLAD);
        }
    }

    public void emote(Community community) {
        List<Shorty> members = community.getMembers();
        for (Shorty member : members) {
            emote(member);
        }
    }

    private void randomEmote(Shorty shorty) {
        int rnd = (int) (Math.random() * Mood.values().length);
        shorty.getMoodManager().emote(Mood.values()[rnd]);
    }
}

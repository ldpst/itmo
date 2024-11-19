package story.play;

import story.community.Community;
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
            shorty.getMoodManager().laught();
        }
    }

    public void emote(Community community) {
        List<Shorty> members = community.getMembers();
        for (Shorty member : members) {
            emote(member);
        }
    }

    private void randomEmote(Shorty shorty) {
        int rnd = (int) (Math.random() * 4) + 1;
        if (rnd == 1) {
            shorty.getMoodManager().laught();
        } else if (rnd == 2) {
            shorty.getMoodManager().rage();
        } else if (rnd == 3) {
            shorty.getMoodManager().beHappy();
        } else if (rnd == 4) {
            shorty.getMoodManager().beSad();
        }
    }
}

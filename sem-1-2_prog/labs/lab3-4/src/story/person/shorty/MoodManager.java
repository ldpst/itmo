package story.person.shorty;

import story.constants.Mood;
import story.sys.Time;

public class MoodManager {
    Shorty shorty;
    Mood mood;
    public MoodManager(Shorty shorty) {
        this.shorty = shorty;
    }

    public void emote(Mood mood) {
        this.mood = mood;
        System.out.println(shorty.getName() + " " + mood.emote() + ".");
    }
}

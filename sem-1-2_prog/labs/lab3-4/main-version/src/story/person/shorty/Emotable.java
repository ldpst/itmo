package story.person.shorty;

import story.constants.Mood;
import story.person.Person;

public interface Emotable {
    default void emote(Mood mood) {
        System.out.println(mood.describe());
    }
}

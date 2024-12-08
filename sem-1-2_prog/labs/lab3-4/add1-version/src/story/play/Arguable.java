package story.play;

import story.community.debaters.Debaters;

public interface Arguable {
    default void argue(Debaters deb1, Debaters deb2) {
        deb1.addOpponent(deb2);
        deb2.addOpponent(deb1);
    }
}

package story.person.shorty;

import story.constants.Mood;
import story.sys.Time;

public class MoodManager {
    Shorty shorty;
    Mood mood;
    public MoodManager(Shorty shorty) {
        this.shorty = shorty;
    }

    public void laught() {
        this.mood = Mood.GLAD;
        System.out.println(shorty.getName() + " захохотал.");
        Time.sleep(1);
    }

    public void rage() {
        this.mood = Mood.ANGRY;
        System.out.println(shorty.getName() + " злится.");
        Time.sleep(1);
    }

    public void beHappy() {
        this.mood = Mood.HAPPY;
        System.out.println(shorty.getName() + " стал счастлив.");
        Time.sleep(1);
    }

    public void beSad() {
        this.mood = Mood.SAD;
        System.out.println(shorty.getName() + " загрустил.");
        Time.sleep(1);
    }
}

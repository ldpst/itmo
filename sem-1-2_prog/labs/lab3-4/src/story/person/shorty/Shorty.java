package story.person.shorty;

import story.constants.Mood;
import story.person.Person;
import story.constants.Place;

public class Shorty extends Person {
    private Place place;
    private Mood mood;
    private boolean isWashed = false;

    private MoodManager moodManager;
    private WashManager sinkManager;
    private PlaceManager placeManager;

    public Shorty(String name) {
        super(name, 0);
        createManagers();
    }

    public Shorty(String name, int age) {
        super(name, age);
        createManagers();
    }

    public Shorty() {
        super("Nameless", 0);
        createManagers();
    }

    private void createManagers() {
        this.moodManager = new MoodManager(this);
        this.sinkManager = new WashManager(this);
        this.placeManager = new PlaceManager(this);
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setWashed(boolean washed) {
        this.isWashed = washed;
    }

    public Mood getMood() {
        return mood;
    }

    public MoodManager getMoodManager() {
        return moodManager;
    }

    public WashManager getSinkManager() {
        return sinkManager;
    }

    public PlaceManager getPlaceManager() {
        return placeManager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
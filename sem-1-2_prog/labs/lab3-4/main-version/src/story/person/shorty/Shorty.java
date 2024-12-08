package story.person.shorty;

import story.constants.Mood;
import story.constants.Place;
import story.person.Person;
import story.sys.SinkIsntNearException;

public class Shorty extends Person implements Washable, Movable, Emotable {
    private Place place;
    private Mood mood;
    private boolean isWashed = false;

    public Shorty(String name) {
        super(name, 0);
    }

    public Shorty(String name, int age) {
        super(name, age);
    }

    public Shorty() {
        super("Nameless", 0);
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    void setWashed(boolean washed) {
        this.isWashed = washed;
    }

    public boolean getIsWashed() {
        return isWashed;
    }

    public Mood getMood() {
        return mood;
    }

    @Override
    public void emote(Mood mood) {
        System.out.println(this.getName() + " " + mood.describe() + ".");
    }

    @Override
    public void goTo(Place place) {
        System.out.println(this.getName() + " подошёл к " + place.toPrint() + ".");
        this.setPlace(place);
    }

    @Override
    public void washUp() throws SinkIsntNearException {
        System.out.println(this.getName() + " пытается умыться:");
        if (isSinkNear()) {
            System.out.println(this.getName() + " успешно умылся.");
            this.setWashed(true);
            System.out.println(this.getName() + " помытый.");
        } else {
            throw new SinkIsntNearException();
        }
    }

    private boolean isSinkNear() {
        return this.getPlace() == Place.SINK;
    }

    public void getDirty() {
        System.out.println(this.getName() + " испачкался.");
        this.setWashed(false);
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
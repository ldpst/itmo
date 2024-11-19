package story;

public class Shorty extends Person {
    private Place place;
    private Mood mood;
    boolean isWashed = false;

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

    public void goTo(Place place) {
        System.out.println(this.getName() + " подошёл к " + place.toString() + ".");
        Time.sleep(1);
        this.place = place;
    }

    public void whashUp() throws SinkIsntNearException {
        System.out.println(this.getName() + " пытается умыться:");
        Time.sleep(1);
        if (isNearSink()) {
            System.out.println(this.getName() + " успешно умылся.");
            Time.sleep(1);
            isWashed = true;
            System.out.println(this.getName() + " помытый.");
        } else {
            throw new SinkIsntNearException();
        }
    }

    public void getDirty() {
        System.out.println(this.getName() + " испачкался.");
        Time.sleep(1);
        isWashed = false;
    }

    private boolean isNearSink() {
        return this.place == Place.SINK;
    }

    public void laught() {
        this.mood = Mood.GLAD;
        System.out.println(this.getName() + " захохотал.");
        Time.sleep(1);
    }

    public void rage() {
        this.mood = Mood.ANGRY;
        System.out.println(this.getName() + " злится.");
        Time.sleep(1);
    }

    public void beHappy() {
        this.mood = Mood.HAPPY;
        System.out.println(this.getName() + " стал счастлив.");
        Time.sleep(1);
    }

    public void beSad() {
        this.mood = Mood.SAD;
        System.out.println(this.getName() + " загрустил.");
        Time.sleep(1);
    }

    public Mood getMood() {
        return mood;
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

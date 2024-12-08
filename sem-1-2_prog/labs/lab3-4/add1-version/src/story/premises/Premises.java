package story.premises;

import story.person.shorty.Shorty;

public abstract class Premises {
    private String name;
    private Shorty owner;

    public Premises(String name, Shorty owner) {
        this.name = name;
        this.owner = owner;
    }

    public Premises(String name) {
        this(name, new Shorty("Владелец"));
    }

    public String getName() {
        return name;
    }

    public Shorty getOwner() {
        return owner;
    }
}

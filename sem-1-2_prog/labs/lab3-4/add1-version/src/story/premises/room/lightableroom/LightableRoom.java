package story.premises.room.lightableroom;

import story.light.types.bulb.Bulb;
import story.person.shorty.Shorty;
import story.premises.room.Room;

public class LightableRoom extends Room {
    public Bulb bulb;

    public LightableRoom(String name) {
        this(name, 0, new Bulb());
    }

    public LightableRoom(String name, Bulb bulb) {
        this(name, 0, bulb);
    }

    public LightableRoom(String name, int countOfWindows, Bulb bulb) {
        this(name, new Shorty("Владелец"), countOfWindows, bulb);
    }

    public LightableRoom(String name, Shorty owner, int countOfWindows, Bulb bulb) {
        super(name, owner, countOfWindows);
        this.bulb = bulb;
    }

    public void setBulb(Bulb bulb) {
        this.bulb = bulb;
        System.out.println("Помещение " + this.getName() + " освещается одной лампочкой.");
    }

}

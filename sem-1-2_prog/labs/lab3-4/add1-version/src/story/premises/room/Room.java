package story.premises.room;

import story.person.shorty.Shorty;
import story.premises.Premises;
import story.premises.door.Door;

public class Room extends Premises {
    private int countOfWindows;
    public Door door = new Door("Дверь " + this.getName());

    public Room(int countOfWindows) {
        this("комната", new Shorty("Владелец"), countOfWindows);
    }

    public Room(String roomName, Shorty owner, int countOfWindows) {
        super(roomName, owner);
        this.countOfWindows = countOfWindows;
    }

    public void setCountOfWindows(int countOfWindows) {
        this.countOfWindows = countOfWindows;
        System.out.println("В помещении " + this.getName() + " " + countOfWindows + " окон.");
    }


    public int getCountOfWindows() {
        return countOfWindows;
    }
}

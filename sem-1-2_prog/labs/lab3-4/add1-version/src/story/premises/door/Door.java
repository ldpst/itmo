package story.premises.door;

import story.sys.PowerBelowZeroException;

public class Door implements Closable {
    private boolean isOpened = false;
    private String name;

    public Door(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void close() {
        close(1);
    }

    public void close(int power) {
        chechInputPower(power, "story.premises.door.Door.close");
        isOpened = false;
        System.out.println(getCloseMessageAddictPower(power));
    }

    @Override
    public void open() {
        open(1);
    }

    public void open(int power) {
        chechInputPower(power, "story.premises.door.Door.open");
        isOpened = true;
        System.out.println(getOpenMessageAddictPower(power));
    }

    private void chechInputPower(int power, String action) {
        if (power < 0) {
            throw new PowerBelowZeroException(action);
        }
    }

    public String getCloseMessageAddictPower(int power) {
        if (power < 10) {
            return this.getName() + " закрылась";
        }
        if (power < 20) {
            return this.getName() + " захлопнулась";
        }
        if (power < 30) {
            return this.getName() + " с треском разлетелась";
        }
        return null;
    }

    public String getOpenMessageAddictPower(int power) {
        if (power < 10) {
            return "Дверь " + this.getName() + " открылась";
        }
        if (power < 20) {
            return "Дверь " + this.getName() + " расхопнулась";
        }
        if (power < 30) {
            return "Дверь " + this.getName() + " с треском расхлопнулась";
        }
        return null;
    }
}

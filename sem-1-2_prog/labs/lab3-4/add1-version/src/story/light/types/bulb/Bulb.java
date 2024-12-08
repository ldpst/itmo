package story.light.types.bulb;

import story.light.Light;

public class Bulb extends Light implements Switchable {
    private BulbPosition position;
    private boolean poweredOn = false;
    
    public Bulb() {
        this(BulbPosition.HIGH);
    }
    public Bulb(BulbPosition position) {
        super(0);
        this.position = position;
    }

    public void setPosition(BulbPosition position) {
        this.position = position;
        System.out.println("Лампочка висит " + position.toPrint() + ".");
    }

    public void setPower(int power) {
        checkPowerBelowZero(power);
        System.out.print("Лампочка ");
        this.setLightPower(power);
    }

    public boolean getPoweredOn() {
        return poweredOn;
    }

    public BulbPosition getPosition() {
        return position;
    }

    public void switchPower() {
        poweredOn = !poweredOn;
    }

    @Override
    public void switchOn() {
        poweredOn = true;
    }

    @Override
    public void switchOff() {
        poweredOn = false;
    }
}

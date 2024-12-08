package story.light;

import story.sys.PowerBelowZeroException;

public abstract class Light {
    private int power;
    private int maxPower = 10;
    private int minPower = 0;

    public Light() {
        this(0);
    }

    public Light(int power) {
        this.power = power;
    }

    public void setLightPower(int power) {
        checkPowerBelowZero(power);
        this.power = power;
        System.out.println("светит " + getPowerToPrint() + ".");
    }

    public void raisePower() {
        raisePower(1);
    }

    public void raisePower(int diff) {
        checkPowerBelowZero(diff);
        if (power == maxPower) {
            System.out.println(getUnsuccesfullRaisePowerMassage());
        }
        else if (power < maxPower) {
            power = (power + diff) % maxPower;
            System.out.println(getRaisePowerMassage());
        }
        if (power == maxPower) {
            System.out.println(getRaisePowerMassage());
        }
    }

    protected void checkPowerBelowZero(int power) {
        if (power < 0) {
            throw new PowerBelowZeroException("Bulb");
        }
    }

    public void lowerPower() {
        lowerPower(1);
    }

    public void lowerPower(int diff) {
        checkPowerBelowZero(diff);
        if (power == minPower) {
            System.out.println(getUnsuccesfullLowerPowerMassage());
        }
        else if (power > minPower) {
            power = Math.max(0, (power - diff));
            System.out.println(getLowerPowerMassage());
        }
        if (power == minPower) {
            System.out.println(getLowerPowerMinMassage());
        }
    }

    private String getRaisePowerMassage() {
        return "Уровень света повышен";
    }

    private String getUnsuccesfullRaisePowerMassage() {
        return "Не удалось повысить уровень света";
    }

    private String getRaisePowerMaxMassage() {
        return "Уровень света достиг максимума";
    }

    private String getLowerPowerMassage() {
        return "Уровень света понижен";
    }

    private String getUnsuccesfullLowerPowerMassage() {
        return "Не удалось понизить уровень света";
    }

    private String getLowerPowerMinMassage() {
        return "Уровень света достиг минимума";
    }

    public int getPower() {
        return power;
    }

    public String getPowerToPrint() {
        if (power <= 0.333 * maxPower) {
            return "тускло";
        }
        if (power <= 0.666 * maxPower) {
            return "средне";
        }
        return "ярко";
    }
}

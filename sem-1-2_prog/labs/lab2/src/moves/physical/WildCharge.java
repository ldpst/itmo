package moves.physical;

import ru.ifmo.se.pokemon.*;

public class WildCharge extends PhysicalMove {
    public WildCharge() {
        super(Type.ELECTRIC, 90, 100);
    }

    @Override
    protected void applySelfDamage(Pokemon att, double damage) {
        att.setMod(Stat.HP, (int) (damage * (1.0 / 4)));
    }

    @Override
    protected java.lang.String describe() {
        return "использует \"Wild Charge\"";
    }
}

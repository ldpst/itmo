package moves.special;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove {
    public Thunder() {
        super(Type.ELECTRIC, 110, 70);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        if (0.3 >= Math.random()) {
            Effect.paralyze(def);
        }
        def.setMod(Stat.HP, (int) damage);
    }

    @Override
    protected java.lang.String describe() {
        return "использует \"Thunder\"";
    }
}

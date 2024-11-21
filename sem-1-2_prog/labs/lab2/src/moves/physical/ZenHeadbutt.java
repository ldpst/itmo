package moves.physical;

import ru.ifmo.se.pokemon.*;

public class ZenHeadbutt extends PhysicalMove {
    public ZenHeadbutt() {
        super(Type.PSYCHIC, 80, 90);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) damage);
        if (0.2 >= Math.random()) {
            Effect.flinch(def);
        }
    }

    @Override
    protected java.lang.String describe() {
        return "использует \"Zen Headbutt\"";
    }
}

package moves.special;

import ru.ifmo.se.pokemon.*;

public class SludgeBomb extends SpecialMove {
    public SludgeBomb() {
        super(Type.POISON, 90, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) damage);
        if (0.3 >= Math.random()) {
            Effect.poison(def);
        }
    }

    @Override
    protected java.lang.String describe() {
        return "использует \"Sludge Bomb\"";
    }
}

package moves.special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Absorb extends SpecialMove {
    public Absorb() {
        super(Type.GRASS, 20, 100);
    }

    @Override
    protected void applySelfDamage(Pokemon atk, double damage) {
        atk.setMod(Stat.HP, -1 * (int) (damage * 0.5));
    }

    @Override
    protected java.lang.String describe() {
        return "использует \"Absorb\"";
    }
}

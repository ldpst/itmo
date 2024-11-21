package moves.special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class MistBall extends SpecialMove {
    public MistBall() {
        super(Type.PSYCHIC, 95, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) damage);
        if (0.5 >= Math.random()) {
            def.setMod(Stat.SPECIAL_ATTACK, -1);
        }
    }
}

package pokemons;

import moves.physical.Bulldoze;
import moves.physical.ZenHeadbutt;
import moves.special.MistBall;
import moves.status.HealPulse;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Latias extends Pokemon {
    public Latias(String name, int lvl) {
        super(name, lvl);
        setType(Type.DRAGON, Type.PSYCHIC);
        setStats(80, 80, 90, 110, 130, 110);
        addMove(new Bulldoze());
        addMove(new HealPulse());
        addMove(new ZenHeadbutt());
        addMove(new MistBall());
    }
}

package pokemons;

import moves.special.Absorb;
import moves.special.MegaDrain;
import moves.status.DoubleTeam;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import java.util.Arrays;

public class Sandygast extends Pokemon {
    public Sandygast(String name, int lvl) {
        super(name, lvl);
        setType(Type.GHOST, Type.GROUND);
        setStats(55, 55, 80, 70, 45, 15);
        addMove(new Absorb());
        addMove(new MegaDrain());
        addMove(new DoubleTeam());
    }
}

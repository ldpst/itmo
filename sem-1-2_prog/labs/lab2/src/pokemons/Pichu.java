package pokemons;

import moves.physical.WildCharge;
import moves.special.Thunder;
import ru.ifmo.se.pokemon.*;

public class Pichu extends Pokemon {
    public Pichu(String name, int lvl) {
        super(name, lvl);
        setType(Type.ELECTRIC);
        setStats(20, 40, 15, 35, 35, 60);
        addMove(new WildCharge());
        addMove(new Thunder());
    }
}

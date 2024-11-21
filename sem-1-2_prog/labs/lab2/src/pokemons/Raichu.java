package pokemons;

import moves.status.Confide;

public class Raichu extends Pikachu {
    public Raichu(String name, int lvl) {
        super(name, lvl);
        setStats(60, 90, 55, 90, 80, 110);
        addMove(new Confide());
    }
}

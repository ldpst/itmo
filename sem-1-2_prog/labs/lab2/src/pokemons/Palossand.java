package pokemons;

import moves.special.SludgeBomb;

public class Palossand extends Sandygast {
    public Palossand(String name, int lvl) {
        super(name, lvl);
        setStats(85, 75, 110, 100, 75, 35);
        addMove(new SludgeBomb());
    }
}

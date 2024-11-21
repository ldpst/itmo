package pokemons;

import moves.status.Agility;

public class Pikachu extends Pichu {
    public Pikachu(String name, int lvl) {
        super(name, lvl);
        setStats(35, 55, 40, 50, 50, 90);
        addMove(new Agility());
    }
}

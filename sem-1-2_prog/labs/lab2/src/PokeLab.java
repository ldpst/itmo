import pokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class PokeLab {
    public static void main(String[] args) {
        Latias latias = new Latias("Латиас", 1);
        Palossand palossand = new Palossand("Палоссэнд", 1);
        Pichu pichu = new Pichu("Пичу", 1);
        Pikachu pikachu = new Pikachu("Пикачу", 1);
        Raichu raichu = new Raichu("Раичу", 1);
        Sandygast sandygast = new Sandygast("Сэндигаст", 1);
        Battle battle = new Battle();
        battle.addAlly(latias);
        battle.addAlly(pichu);
        battle.addAlly(raichu);
        battle.addFoe(palossand);
        battle.addFoe(pikachu);
        battle.addFoe(sandygast);
        battle.go();
    }
}

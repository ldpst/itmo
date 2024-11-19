import story.constants.Book;
import story.constants.Imagination;
import story.constants.Place;
import story.person.shorty.Shorty;
import story.scene.Scene;
import story.play.Play;
import story.sys.Time;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shorty> cast = new ArrayList<>(); // список всех участников истории
        String[] names = {"Незнайка", "Знайка", "Кнопочка", "Пилюлькин", "Пончик", "Ромашка", "Мушка"};
        for (var i : names) {
            cast.add(new Shorty(i));
        }

        boolean randomEmotions = true; // случайные эмоции (вместо "захохотал")
        Shorty slacker = cast.get(0); // персонаж, подходящий к раковине и моющий руки
        Place goToThisPlace = Place.SINK; // место, куда идет slacker
        Shorty statementAim = cast.get(0); // цель утверждений и мнений трех групп коротышех и персоны без рубахи
        Book statementAimsBook = Book.MOON; // содержание книги, которую упоминает коротышка без рубахи
        Imagination crazymansIdeology = Imagination.GREATPERSON; // то, кем считают себя сумасшедшие


//        Инициализация конструктором
        Scene scene = new Scene(cast, randomEmotions, slacker, goToThisPlace, statementAim, statementAimsBook, crazymansIdeology);


//        Инициализация через сетеры
//        Scene scene = new Scene();
//        scene.setCast(cast);
//        scene.setRandomEmotions(randomEmotions);
//        scene.setSlacker(slacker);
//        scene.setGoToThisPlace(goToThisPlace);
//        scene.setStatementAim(statementAim);
//        scene.setStatementAimsBook(statementAimsBook);
//        scene.setCrazymansIdeology(crazymansIdeology);

        Time.skipSleep(); // убирает паузы между выводом сообщений

        Play play = new Play(scene);
        play.go();
    }
}
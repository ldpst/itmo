import story.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shorty> cast = new ArrayList<Shorty>();
        cast.add(new Shorty("Нейзнайка"));
        cast.add(new Shorty("Знайка"));
        cast.add(new Shorty("Кнопочка"));
        cast.add(new Shorty("Пилюлькин"));
        cast.add(new Shorty("Пончик"));
        cast.add(new Shorty("Ромашка"));
        cast.add(new Shorty("Мушка"));

        Scene scene = new Scene(cast, true, cast.get(0), Place.SINK, cast.get(0), Book.MOON, Imagination.GREATPERSON);
//        Time.skipSleep();

//        scene.addToCast(cast);
//        scene.setRandomEmotions(true);
//        scene.setNeznaika(cast.get(0));
//        scene.setGoToThisPlace(Place.SINK);
//        scene.setAssertionAim(cast.get(0));
//        scene.setAssertionAimsBook(Book.MOON);
//        scene.setCrazymansIdeology(Imagination.GREATPERSON);
        scene.play();
    }
}
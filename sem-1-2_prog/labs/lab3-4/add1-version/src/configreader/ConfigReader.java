package configreader;

import configreader.exception.*;
import story.constants.Book;
import story.constants.Imagination;
import story.constants.Place;
import story.person.shorty.Shorty;

import java.util.ArrayList;
import java.util.List;

public class ConfigReader {
    List<Shorty> cast = new ArrayList<>();
    boolean randomEmotions;
    Shorty slacker = null;
    Place goToThisPlace = null;
    Shorty statementAim = null;
    Book statementAimsBook = null;
    Imagination crazymansIdeology = null;

    public ConfigReader() {
    }

    public void parse(String line) throws SyntaxException {
        List<String> split = List.of(line.split(" "));
        if (split.getFirst().equals("Cast")) {
            checkIsStructureEmpty(split, "Cast");
            parseCast(split.subList(1, split.size()));
        } else if (split.getFirst().equals("RandomEmotions")) {
            checkIsStructureEmpty(split, "RandomEmotions");
            parseRandomEmotions(split.subList(1, split.size()));
        } else if (split.getFirst().equals("Slacker")) {
            checkIsStructureEmpty(split, "Slacker");
            parseSlacker(split.subList(1, split.size()));
        } else if (split.getFirst().equals("NewPlace")) {
            checkIsStructureEmpty(split, "NewPlace");
            parseNewPlace(split.subList(1, split.size()));
        } else if (split.getFirst().equals("Aim")) {
            checkIsStructureEmpty(split, "Aim");
            parseAim(split.subList(1, split.size()));
        } else if (split.getFirst().equals("Book")) {
            checkIsStructureEmpty(split, "Book");
            parseBook(split.subList(1, split.size()));
        } else if (split.getFirst().equals("Crazyman")) {
            checkIsStructureEmpty(split, "Crazyman");
            parseCrazyman(split.subList(1, split.size()));
        } else {
            throw new SyntaxException(line);
        }
    }

    private void parseCast(List<String> line) {
        cast.clear();
        List<String> names = parseNames(line, "Cast");
        checkDublicates(names, "Cast");
        for (var i : names) {
            this.cast.add(new Shorty(i));
        }
    }

    private List<String> parseNames(List<String> line, String structure) throws WrongFormatException {
        List<String> names = new ArrayList<>();
        names.add(line.getFirst());
        for (int i = 1; i < line.size(); i++) {
            if (!(line.get(i).startsWith("\""))) {
                names.set(names.size() - 1, names.get(names.size() - 1) + " " + line.get(i));
            } else {
                names.add(line.get(i));
            }
        }
        for (int i = 0; i < names.size(); i++) {
            if (!(names.get(i).startsWith("\"") && names.get(i).endsWith("\""))) {
                throw new WrongFormatException(structure, names.get(i));
            }
            names.set(i, names.get(i).substring(1, names.get(i).length() - 1));
        }
        return names;
    }

    private void parseRandomEmotions(List<String> line) {
        checkIsSingleValue(line, "RandomEmotions");
        if (line.getFirst().equals("true")) {
            this.randomEmotions = true;
        } else if (line.getFirst().equals("false")) {
            this.randomEmotions = false;
        } else {
            throw new WrongFormatException("RandomEmotions", line.getFirst());
        }
    }

    private void parseSlacker(List<String> line) {
        List<String> names = parseNames(line, "Slacker");
        checkIsSingleValue(names, "Slacker");
        String name = names.getFirst();
        checkIsShortyInCast(name, "Slacker");
        this.slacker = new Shorty(name);
    }

    private void parseNewPlace(List<String> line) throws WrongFormatException {
        checkIsSingleValue(line, "NewPlace");
        String place = line.getFirst();
        Place found = null;
        for (var p : Place.values()) {
            if (p.name().equals(place)) {
                found = p;
            }
        }
        if (found == null) {
            throw new WrongFormatException("NewPlace", place);
        } else {
            this.goToThisPlace = found;
        }
    }

    private void parseAim(List<String> line) {
        List<String> names = parseNames(line, "Aim");
        checkIsSingleValue(names, "Aim");
        String name = names.getFirst();
        checkIsShortyInCast(name, "Aim");
        this.statementAim = new Shorty(name);
    }

    private void parseBook(List<String> line) {
        checkIsSingleValue(line, "Book");
        String book = line.getFirst();
        Book found = null;
        for (var b : Book.values()) {
            if (b.name().equals(book)) {
                found = b;
            }
        }
        if (found == null) {
            throw new WrongFormatException("Book", book);
        } else {
            this.statementAimsBook = found;
        }
    }

    private void parseCrazyman(List<String> line) {
        checkIsSingleValue(line, "Crazyman");
        String imagination = line.getFirst();
        Imagination found = null;
        for (var i : Imagination.values()) {
            if (i.name().equals(imagination)) {
                found = i;
            }
        }
        if (found == null) {
            throw new WrongFormatException("Crazyman", imagination);
        } else {
            this.crazymansIdeology = found;
        }
    }

    private void checkIsShortyInCast(String name, String structure) throws ShortyNotInCastException {
        boolean found = false;
        for (Shorty s : cast) {
            if (s.getName().equals(name)) {
                found = true;
            }
        }
        if (!found) {
            throw new ShortyNotInCastException(structure);
        }
    }

    private void checkDublicates(List<String> line, String structure) throws DublicatedNamesException {
        List<String> copy = new ArrayList<String>(line);
        copy.sort(new ListOfStringsComparator());
        for (int i = 1; i < copy.size(); i++) {
            if (copy.get(i).equals(copy.get(i - 1))) {
                throw new DublicatedNamesException(structure);
            }
        }
    }

    private void checkIsSingleValue(List<String> line, String structure) throws WrongFormatException {
        if (line.size() != 1) {
            throw new WrongFormatException(structure, OpenListOfStrings.open(line));
        }
    }

    private void checkIsStructureEmpty(List<String> line, String structure) throws StructureIsEmptyException {
        if (line.size() == 1) {
            throw new StructureIsEmptyException(structure);
        }
    }

    public List<Shorty> getCast() {
        return cast;
    }

    public boolean getRandomEmotions() {
        return randomEmotions;
    }

    public Shorty getSlacker() {
        return slacker;
    }

    public Place getGoToThisPlace() {
        return goToThisPlace;
    }

    public Shorty getStatementAim() {
        return statementAim;
    }

    public Book getStatementAimsBook() {
        return statementAimsBook;
    }

    public Imagination getCrazymansIdeology() {
        return crazymansIdeology;
    }
}

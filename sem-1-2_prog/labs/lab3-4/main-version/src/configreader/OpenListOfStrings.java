package configreader;

import java.util.List;

public abstract class OpenListOfStrings {
    static public String open(List<String> list) {
        String res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = res.concat(" " + list.get(i));
        }
        return res;
    }
}

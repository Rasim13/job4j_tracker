package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word:origin) {
            check.addAll(Collections.singleton(word));
        }
        for (String newText:text) {
            if(check.contains(newText)){
                rsl = true;
            } else {
                rsl = false;
            }

        }

        /* for-each origin -> new HashSet. */
        /* for-each text -> hashSet.contains */
        return rsl;
    }
}

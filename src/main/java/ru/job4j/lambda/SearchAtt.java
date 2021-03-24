package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Supplier<Integer> initValue = new Supplier<Integer>() {
            public Integer get() {
                return size;
            }
        };
        Predicate<Attachment> att = new Predicate<Attachment>() {
            public boolean test(Attachment attachment) {
                boolean result = false;
                if (attachment.getSize() > initValue.get()) {
                    result = true;
                }
                return result;
            }
        };
        return filter(list, att);
    }

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Supplier<String> initValue = new Supplier<String>() {
            public String get() {
                return name;
            }
        };
        Predicate<Attachment> att = new Predicate<Attachment>() {
            public boolean test(Attachment attachment) {
                boolean result = false;
                if (attachment.getName().contains(initValue.get())) {
                    result = true;
                }
                return result;
            }
        };
        return filter(list, att);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> attachment) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (attachment.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}

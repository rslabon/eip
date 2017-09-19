package com.example.eip.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Randoms {
    private static final Random random = new Random();
    private static final String[] c = {
            "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", " "
    };

    public static String string() {
        int length = random.nextInt(50) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(c.length);
            sb.append(random.nextBoolean() ? c[idx].toUpperCase() : c[idx]);
        }
        return sb.toString();
    }

    public static <T> T oneOf(Collection<T> items) {
        int idx = random.nextInt(items.size());
        return new ArrayList<>(items).get(idx);
    }

    public static int positiveInt(int startInc, int endInc) {
        return random.nextInt(endInc + 1) + startInc;
    }
}

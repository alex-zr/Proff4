package session3;

import java.util.Arrays;
import java.util.Objects;

public class ArrayUtils {
    public int sum(Integer[] vector) {
        if (vector == null) {
            return 0;
        }
        return Arrays.stream(vector)
                .filter(Objects::nonNull)
                .mapToInt(e -> e)
                .sum();
    }
}

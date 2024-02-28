import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1, 100).toArray();

        Map<Predicate<Integer>, String> preds = new LinkedHashMap<>();
        preds.put(x -> x % 3 == 0, "Fizz");
        preds.put(x -> x % 5 == 0, "Buzz");

        System.out.println(fizzBuzz(arr, preds));
    }

    private static String fizzBuzz(int[] arr, Map<Predicate<Integer>, String> preds) {
        return Arrays.stream(arr)
                .mapToObj(x -> preds.entrySet().stream()
                        .filter(entry -> entry.getKey().test(x))
                        .map(Map.Entry::getValue)
                        .reduce(String::concat)
                        .orElse(String.valueOf(x)))
                .collect(Collectors.joining(" "));
    }
}

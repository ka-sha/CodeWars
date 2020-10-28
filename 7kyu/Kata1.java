import java.util.*;

public class Kata1 {
  public static String highAndLow(String numbers) {
        int[] trueNumbers = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(trueNumbers);

        return trueNumbers[trueNumbers.length - 1] + " " + trueNumbers[0];
    }
}

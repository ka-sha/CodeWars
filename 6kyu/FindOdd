import java.util.HashMap;
import java.util.Map;

public class FindOdd {
  public static int findIt(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int b : a)
    {
      if (map.containsKey(b))
        map.put(b, map.get(b) + 1);
      else
        map.put(b, 1);
    }
    int odd = 0;
    for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if((entry.getValue() & 1)== 1) {
        odd = entry.getKey();
        break;
      }
    }
    return odd;
  }
}

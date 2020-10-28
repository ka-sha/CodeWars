import java.util.Arrays;

public class Solution1 {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] time = new int[n];
        Arrays.fill(time, 0);

        for (int i = 0; i < customers.length; i++) {
            time[0] += customers[i];
            Arrays.sort(time);
        }
        
        return time[n - 1];
        }
}

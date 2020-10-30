import java.util.Arrays;

public class Solution {
    public static int[] distributionOf(int[] golds) {
        int sumA = 0;
        int sumB = 0;
        int[][] lookup = new int[golds.length][golds.length];

        sumA = smartChoice(golds, 0, golds.length - 1, lookup);
        sumB = Arrays.stream(golds).sum() - sumA;

        return new int[]{sumA, sumB};
    }

    private static int smartChoice(int[] golds, int i, int j, int[][] lookup) {
        if (i == j)
            return golds[i];

        if (i + 1 == j)
            return Math.max(golds[i], golds[j]);

        if (lookup[i][j] == 0) {
            int head = golds[i] + Math.min(smartChoice(golds, i + 2, j, lookup), smartChoice(golds, i + 1, j - 1, lookup));
            int tail = golds[j] + Math.min(smartChoice(golds, i + 1, j - 1, lookup), smartChoice(golds, i, j - 2, lookup));

            lookup[i][j] = Math.max(head, tail);
        }

        return lookup[i][j];
    }
}

package cw;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Interval {
    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        ArrayList<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0] && end <= intervals[i + 1][1])
                end = intervals[++i][1];
            int size = result.size() - 1;
            if (size == -1) {
                result.add(new Integer[]{start, end});
            }
            else if (end > result.get(size)[1] && start >= result.get(size)[0] && start <= result.get(size)[1]) {
                result.get(size)[1] = end;
            }
            else if (start > result.get(size)[1]) {
                result.add(new Integer[]{start, end});
            }
        }

        int sum = 0;
        for (Integer[] line : result)
            sum += line[1] - line[0];

        return sum;
    }
}

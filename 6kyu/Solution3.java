public class Solution3 {
    public int solution(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (i % 3 == 0) {
                sum += i;
                continue;
            }
            if (i % 5 == 0)
                sum += i;
        }

        return sum;
  }
}

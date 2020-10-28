public class Sum {
     public int GetSum(int a, int b)
     {
       int sum = 0;
       if (a == b) {
         return a;
       }
       if (b < a) {
         int t = a;
         a = b;
         b = t;
       }
       for (int i = a; i < b + 1; i++) {
          sum+=i;
       }
       return sum;
     }
  }

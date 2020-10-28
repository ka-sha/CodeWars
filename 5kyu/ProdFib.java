public class ProdFib { // must be public for codewars 
  
      public static long[] productFib(long prod) {
        if (prod < 0)
            return new long[]{0, 1, 0};
        if (prod == 0)
            return new long[]{0, 1, 1};

        long[] f = new long[0x09ffffff];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < 0x09ffffff; i++) {
            f[i] = f[i - 1] + f[i - 2];
            long first = f[i - 1];
            long second = f[i];
            if (first * second == prod)
                return new long[]{first, second, 1};

            if (f[i] * f[i - 1] > prod)
                return new long[]{first, second, 0};
        }

        return null;
    }
}

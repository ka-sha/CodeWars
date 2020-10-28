public class PrimeConsec {
    public static int consecKprimes(int k, long[] arr) {
        boolean prevKPrime = isKPrime(arr[0], k);
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            boolean currKPrime = isKPrime(arr[i], k);

            if (prevKPrime && currKPrime)
                count++;

            prevKPrime = currKPrime;
        }
      
        return count;
    }

    private static boolean isKPrime(long n, int k) {
        int count = 0;

        while (n % 2 == 0) {
            n /= 2;
            if (++count > k)
                return false;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2)
            while (n % i == 0) {
                n /= i;
                if (++count > k)
                    return false;
            }

        if (n > 2)
            count++;

        return k == count;
    }
}

import java.math.BigInteger;

public class ReverseEuclid {
    public static BigInteger[] findInitialNumbers(long divisor, long iterations) {

      BigInteger[] result = new BigInteger[]{new BigInteger(Long.toString(divisor)), BigInteger.ZERO};
      
      if (iterations == 0)
        return result;

        for (int i = 0; i < iterations + 1; i++)
            if (result[0].compareTo(result[1]) > 0)
                result[1] = result[0].add(result[1]);
            else
                result[0] = result[1].add(result[0]);

        return result;
    }
}

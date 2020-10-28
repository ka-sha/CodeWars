public class Kata1 {
    public static boolean isPronic(long n){
        long sqrt = (long) Math.sqrt(n);
        return sqrt * (sqrt + 1) == n;
    }
}

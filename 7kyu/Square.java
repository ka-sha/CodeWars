public class Square {    
    public static boolean isSquare(int n) {        
        if (n < 0)
          return false;
        double a = Math.sqrt(n);
        a %= 1;
        return (a == 0.0);
    }
}

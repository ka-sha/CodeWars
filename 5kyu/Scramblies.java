public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {
      if (str1.length() < str2.length()) return false;
      
      StringBuilder str = new StringBuilder(str1);
      
      for (int i = 0; i < str2.length(); i++) {
        for (int j = 0; j < str.length(); j++) {
          if (str2.charAt(i) == str.charAt(j)) {
              str.deleteCharAt(j);
              break;
          } else if (j == str.length() - 1) {
            return false;
          }
        }
      }
      return true;
    }
}

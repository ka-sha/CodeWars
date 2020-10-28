public class Kata {

  public static String encrypt(final String text, final int n) {
    if (n <= 0 || text == null || text.length() == 0)
      return text;
    StringBuilder start = new StringBuilder();
    StringBuilder end = new StringBuilder();
    StringBuilder encryptedText = new StringBuilder(text);
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < text.length(); j ++) {
        if (j % 2 == 1) start.append(encryptedText.charAt(j));
        else end.append(encryptedText.charAt(j));
      }
      encryptedText = new StringBuilder().append(start).append(end);
      start = start.delete(0, start.length());
      end = end.delete(0, end.length());
    }
    return encryptedText.toString();
  }
  
      public static String decrypt(final String encryptedText, final int n) {
        if (n <= 0 || encryptedText == null || encryptedText.length() == 0)
            return encryptedText;
        StringBuilder start = new StringBuilder(encryptedText.substring(0, encryptedText.length()/2));
        StringBuilder end = new StringBuilder(encryptedText.substring(encryptedText.length()/2));
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < encryptedText.length(); j++) {
                if (j % 2 == 0) decryptedText.append(end.charAt(j / 2));
                else decryptedText.append(start.charAt(j / 2));
            }
            if (i == n - 1)
                return decryptedText.toString();
            start = new StringBuilder(decryptedText.substring(0, decryptedText.length()/2));
            end = new StringBuilder(decryptedText.substring(decryptedText.length()/2));
            decryptedText = new StringBuilder();
        }
        return null;
    }
}

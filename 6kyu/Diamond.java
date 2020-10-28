class Diamond {
  public static String print(int n) {
    if (n < 0 || (n & 1) == 0) return null;
    
    StringBuilder diamond = new StringBuilder();
    char[][] c = new char[n][];
    
    for (int i = 0; i < n/2 + 1; i++)
      c[i] = c[n - i - 1] = new char[n/2 + 2 + i];
    
    for (int i = 0, k = 1; i < n/2 + 1; i++, k += 2) {
      int t = k;
      c[i][c[i].length - 1] = '\n';
      for (int j = c[i].length - 2; j >= 0; j--) {
        if (t != 0) {
          c[i][j] = '*';
          t--;
        } else c[i][j] = ' ';
      }
    }
    
    for (int i = 0; i < n; i++)
      diamond.append(c[i]);
    
    return diamond.toString();
  }
}

public class FindOutlier{
  static int find(int[] integers){
    int odd = 0, even = 0;
    for (int i = 0; i < 3; i++) {
      if ((integers[i] & 1) == 1) odd++;
      else even++;
    }
    if (odd >= 2) {
      for (int i = 0; i < integers.length; i++)
        if ((integers[i] & 1) == 0) return integers[i];
    } else {
        for (int i = 0; i < integers.length; i++)
          if ((integers[i] & 1) == 1) return integers[i];
    }
    return -1;
  }
}

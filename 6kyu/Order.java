public class Order {
  private static int findInt(String str) {
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i);
            if (a >= 49 && a <= 57) return a - 49;
        }

        return -1;
    }

    public static String order(String words) {
        if (words.isEmpty()) return words;

        String[] str = words.split(" ");
        String[] sortedStr = new String[str.length];

        for (String s : str)
            sortedStr[findInt(s)] = s;

        StringBuilder finaly = new StringBuilder().append(sortedStr[0]);

        for (int i = 1; i < sortedStr.length; i++)
            finaly.append(" ").append(sortedStr[i]);

        return finaly.toString();
    }
}

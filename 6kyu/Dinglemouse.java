public class Dinglemouse {
    public static String hungryFoxes(String farm) {
        boolean isEmptyEnd = false;
        if (farm.substring(farm.length() - 2).equals("[]"))
            isEmptyEnd = true;

        String[] s = farm.split("[\\[\\]]");

        for (int i = 1; i < s.length; i += 2)
            if (s[i].contains("F"))
                s[i] = s[i].replaceAll("C", ".");

        for (int i = 0; i < s.length; i += 2)
            if (s[i].contains("F")) {
                bigReplace(s);
                break;
            }

        StringBuilder farmResult = new StringBuilder();
        for (int i = 0; i < s.length; i++)
            if ((i & 1) == 0)
                farmResult.append(s[i]);
            else
                farmResult.append("[").append(s[i]).append("]");

        if (isEmptyEnd)
            farmResult.append("[]");

        return farmResult.toString();
    }

    private static void bigReplace(String[] s) {
        for (int i = 0; i < s.length; i += 2)
            s[i] = s[i].replaceAll("C", ".");
    }
}

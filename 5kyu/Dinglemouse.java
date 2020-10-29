import java.util.*;
import java.util.stream.*;

public class Dinglemouse {
    public static String hungryFoxes(String farm) {
        String[] s = mySplit(farm, true);
        StringBuilder outsideOfCages = new StringBuilder(s[0]);

        for (int i = 2; i < s.length; i += 2)
            outsideOfCages.append("|").append(s[i]);

        if ((s.length & 1) == 0)
            outsideOfCages.append("|");

        for (int i = 1; i < s.length; i += 2)
            s[i] = smartReplace(s[i]);

        String outsideOfCagesString = smartReplace(outsideOfCages.toString());

        int i = 1;
        while (outsideOfCagesString.contains("|")) {
            outsideOfCagesString = outsideOfCagesString.replaceFirst("[|]", "[" + s[i] + "]");
            i += 2;
        }

        return outsideOfCagesString;
    }

    private static String smartReplace(String s) {
        if (!s.contains("X"))
            return easyReplace(s);

        String[] microSubs = mySplit(s, false);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < microSubs.length; i++) {
            if (microSubs[i].contains("F"))
                microSubs[i] = microSubs[i].replaceAll("[CF]", ".");
            if (i == 0)
                result.append(microSubs[i]);
            else
                result.append("X").append(microSubs[i]);
        }

        return result.toString();
    }

    private static String easyReplace(String s) {
        return (s.contains("F")) ? s.replaceAll("C", ".") : s;
    }

    private static String[] mySplit(String s, boolean bracket) {
        List<List<Character>> seq = new ArrayList<>();
        char[] ch = s.toCharArray();

        seq.add(new LinkedList<>());

        if (bracket)
            foo1(seq, ch);
        else
            foo2(seq, ch);
        
        String[] result = new String[seq.size()];
        for (int i = 0; i < seq.size(); i++)
            if (!seq.get(i).isEmpty())
                result[i] = seq.get(i).stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
            else
                result[i] = "";

        return result;
    }

    private static void foo1(List<List<Character>> seq, char[] ch) {
        for (char c : ch)
            if (c == '[' || c == ']')
                seq.add(new LinkedList<>());
            else
                seq.get(seq.size() - 1).add(c);

        int size = seq.size() - 1;
        if (seq.get(size).isEmpty())
            seq.remove(size);
    }

    private static void foo2(List<List<Character>> seq, char[] ch) {
        for (char c : ch)
            if (c == 'X')
                seq.add(new LinkedList<>());
            else
                seq.get(seq.size() - 1).add(c);
    }
}

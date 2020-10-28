public class Troll {
    public static String disemvowel(String str) {
        char[] a = str.toCharArray();
        StringBuilder newStr = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++)
            if (a[i] != 'e' && a[i] != 'u' && a[i] != 'i' && a[i] != 'o' && a[i] != 'a' &&
            a[i] != 'E' && a[i] != 'U' && a[i] != 'I' && a[i] != 'O' && a[i] != 'A')
                newStr.append(a[i]);
        
        return newStr.toString();
    }
}

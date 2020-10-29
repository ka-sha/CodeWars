public class Kata {

    private static final String[] alphabet = {"qwertyuiop", "asdfghjkl", "zxcvbnm,.",
            "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM<>"};

    public static String encrypt(String text, int key) {
        int[] rotations = new int[]{key / 100, key % 100 / 10, key % 10};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            int currRaw = -1;

            for (int j = 0; j < alphabet.length; j++)
                if (alphabet[j].indexOf(currChar) != -1) {
                    currRaw = j;
                    break;
                }

            if (currRaw == -1)
                result.append(currChar);
            else
                result.append(alphabet[currRaw].charAt((alphabet[currRaw].indexOf(currChar) + rotations[currRaw % 3]) % alphabet[currRaw].length()));
        }

        return result.toString();
    }

    public static String decrypt(String encryptedText, int key) {
        int[] rotations = new int[]{key / 100, key % 100 / 10, key % 10};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char currChar = encryptedText.charAt(i);
            int currRaw = -1;

            for (int j = 0; j < alphabet.length; j++)
                if (alphabet[j].indexOf(currChar) != -1) {
                    currRaw = j;
                    break;
                }

            if (currRaw == -1)
                result.append(currChar);
            else {
                int rotation = alphabet[currRaw].indexOf(currChar) - rotations[currRaw % 3];
                if (rotation < 0)
                    rotation += alphabet[currRaw].length();
                result.append(alphabet[currRaw].charAt((rotation) % alphabet[currRaw].length()));
            }
        }

        return result.toString();
    }
}

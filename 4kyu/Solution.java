class Solution {
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < arr.length) {
            if (i < arr.length - 2 && arr[i] == (arr[i + 2] - 2)) {
                result.append(arr[i]).append("-");
                while (i < arr.length - 1 && arr[i] == arr[i + 1] - 1) i++;
            }
            result.append(arr[i++]).append(",");
        }
        return result.substring(0, result.length() - 1);
    }
}

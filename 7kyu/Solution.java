class Solution{
    public static int solve(int [] arr){
        int count = 0;
        int n = ((arr.length & 1) == 1) ? arr.length - 1 : arr.length;
        for (int i = 0; i < n; i += 2)
            if (arr[i] == arr[i + 1] - 1 || arr[i] == arr[i + 1] + 1)
                count++;

        return count;
    }
}

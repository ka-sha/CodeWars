import java.util.Arrays;

class Solution2 {
    public static int solve(int [] arr){
        int res = 1;
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length && arr[i] <= res; i++)
            res = res + arr[i];

        return res;
    }
}

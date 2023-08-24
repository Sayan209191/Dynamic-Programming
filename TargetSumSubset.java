public class TargetSumSubset {

    public static boolean isTargetSum(int arr[], int sum,int i) {
        if(sum == 0) {  // null set
            return true;
        }
        if(i < 0) { // 
            return false;
        }

        if(arr[i] <= sum) {
            return isTargetSum(arr, sum-arr[i], i-1) || isTargetSum(arr, sum, i-1);
        } else {
            return isTargetSum(arr, sum, i-1);
        }
    }
    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // base case
        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        // filling
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                int v = arr[i-1]; 
                // Valid + include
                if(v<=j && dp[i-1][j-v]) {
                    dp[i][j] = true;
                }
                if(dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int target = 10;
        System.out.println(isTargetSum(arr, target, arr.length-1));
        // System.out.println(targetSum(arr, target));
    }
}

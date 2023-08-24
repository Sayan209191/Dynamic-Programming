public class ClimbingStairs {

    // Basic Recursion 
    public static int totalWays(int n) {
        if(n < 0) {
            return 0;
        }
        if(n==0 || n==1) {
            return 1;
        }
        return totalWays(n-1) + totalWays(n-2);
    }

    // Memoization
    public static int countWays(int n, int dp[]) {
        if(n < 0) {
            return 0;
        }
        if(n==0 || n==1) {
            return dp[n] = 1;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = countWays(n-1, dp) + countWays(n-2, dp);
    }

    // Tabulization

    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
     public static void main(String[] args) {
        int n = 5;
        System.out.println(totalWays(n));
        System.out.println(countWays(n, new int[n+1]));
        System.out.println(countWaysTab(n));
    }
}

import java.util.*;

public class CatalanNumber {
    // recursion
    public static int catalanRec(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanRec(i) * catalanRec(n-i-1); 
        }
        return ans;
    }

    // memoization
    public static int catalanMemo(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }
        return dp[n] = ans % 1000000007;
    }
    public static void main(String[] args) {
        int n = 175;
        // System.out.println(catalanRec(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMemo(n, dp));
    }
}

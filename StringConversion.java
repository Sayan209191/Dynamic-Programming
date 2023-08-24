public class StringConversion {

    // Solve using lcs apply
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        // Intilizing
        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<m+1; j++) {
            dp[0][j] = 0;
        }
        // filling
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int strConversion(String str1, String str2) {
        int lcs = lcs(str1, str2);
        return (str1.length()-lcs) + (str2.length()- lcs);
    }

    // Solve using edit distance apply
    public static int totalConversion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        // Intilizing
        for(int i=0; i<n+1; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<m+1; j++) {
            dp[0][j] = j;
        }
        // filling
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    int ans1 = dp[i][j-1];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.min(ans1, ans2)+1;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "PEER";
        String str2 = "SEA";

        System.out.println(strConversion(str1, str2));

        System.out.println(totalConversion(str1, str2));
    }
}

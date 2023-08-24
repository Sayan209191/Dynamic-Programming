public class Fibonacci{

    public static int fibo(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    // Use Dp   ---> Memoization
    public static int fibonacci(int n, int fibo[]) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(fibo[n] != 0) {
            return fibo[n];
        }
        return fibo[n] = fibonacci(n-1, fibo) + fibonacci(n-2, fibo);
    }

    // Dp --> Tabulation

    public static int fib(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n+1];
        System.out.println(fibo(n));

        System.out.println(fibonacci(n, f));

        System.out.println(fib(n));
    }
}
package problems.dp;

public class FibonacciSequence {
    public static int fibonacci(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2;i<=N;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }

    public static int fibonacciRec(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        return fibonacciRec(N-1) + fibonacciRec(N-2);
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Movie {
    public static void lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        String[][] dp = new String[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = "";
        for (int j = 0; j <= n2; j++) dp[0][j] = "";

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                else dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }

        System.out.println(dp[n1][n2].trim().equals("sequence print"));
    }
}
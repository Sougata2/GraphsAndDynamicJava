import java.util.*;

public class DynamicProgramming {

    // ninja training
    public static int ninjaTrainingRec(int day, int last, int t, int[][] arr, int[][] dp) {
        if (day < 0) {
            return 0;
        }
        if (last > 0 && dp[day][last] != -1) {
            return dp[day][last];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            if (i != last) {
                max = Math.max(max, arr[day][i] + ninjaTrainingRec(day - 1, i, t, arr, dp));
            }
        }
        if (last > 0)
            dp[day][last] = max;
        return max;
    }

    public static int ninjaTraining() {
        int[][] arr = new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        arr = new int[][]{
                {7, 6, 1},
                {3, 9, 7},
                {1, 3, 5},
                {9, 7, 6},
                {1, 10, 1},
                {1, 7, 2},
                {4, 9, 10},
                {4, 5, 5},
                {7, 1, 7},
                {7, 2, 9},
        };


        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return ninjaTrainingRec(arr.length - 1, -1, 3, arr, dp);
    }

    public static int ninjaTrainingTabulation() {
        int[][] arr = new int[][]{
                {7, 6, 1},
                {3, 9, 7},
                {1, 3, 5},
                {9, 7, 6},
                {1, 10, 1},
                {1, 7, 2},
                {4, 9, 10},
                {4, 5, 5},
                {7, 1, 7},
                {7, 2, 9},
        };
//        arr = new int[][]{
//                {1, 2, 5},
//                {3, 1, 1},
//                {3, 3, 3}
//        };

        arr = new int[][]{
                {5, 10, 7},
                {4, 8, 9},
                {9, 3, 10},
                {2, 4, 6},
                {10, 9, 5},
                {1, 8, 7},
                {4, 7, 2},
                {6, 5, 3},
                {1, 10, 8},
                {4, 8, 3}};
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j)
                        max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] = arr[i][j] + max;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[m - 1][i]);
        }
        return res;
    }

    // jump game
    public static boolean jumpGameF(int pos, int[] arr, int[] dp) {
        if (pos == arr.length - 1) {
            return true;
        }
        if (dp[pos] != -1) return dp[pos] == 1;
        for (int i = 1; i <= arr[pos]; i++) {
            if (jumpGameF(pos + i, arr, dp)) {
                dp[pos + i] = 1;
                return true;
            }
        }
        dp[pos] = 0;
        return false;
    }

    public static boolean jumpGame() {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
//        arr = new int[]{3, 2, 1, 0, 4};
        return jumpGameF(0, arr, dp);
    }

    public static boolean jumpGameTabulation() {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        arr = new int[]{3, 2, 1, 0, 4};
        arr = new int[]{1, 0, 1, 0};
        int n = arr.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i > -1; i--) {
            int jumps = arr[i];
            for (int j = 1; j <= jumps; j++) {
                if (i + j < n && dp[i + j]) dp[i] = true;
            }
        }
        System.out.println(Arrays.toString(dp));

        boolean isReachable = false;
        for (int i = n - 1; i > -1; i--) {
            isReachable = dp[i];
        }
        return isReachable;
    }

    // unique paths
    public static int uniquePathsF(int x, int y, int m, int n) {
        if (x > m || y > n) return 0;
        if (x == m - 1 && y == n - 1) return 1;
        return uniquePathsF(x + 1, y, m, n) + uniquePathsF(x, y + 1, m, n);
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return uniquePathsF(0, 0, m, n);
    }

    public static int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                int down = i + 1 == m ? 0 : dp[i + 1][j];
                int right = j + 1 == n ? 0 : dp[i][j + 1];
                dp[i][j] += down + right;
            }
        }
        return dp[0][0];
    }

    public static int uniquePaths2Tabulation(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        obstacleGrid[m - 1][n - 1] = 1;
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (i == m - 1 && j == n - 1) continue;
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    int down = i + 1 == m ? 0 : obstacleGrid[i + 1][j];
                    int right = j + 1 == n ? 0 : obstacleGrid[i][j + 1];
                    obstacleGrid[i][j] += down + right;
                }
            }
        }
        return obstacleGrid[0][0];
    }

    // minimum path sum
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int top = i - 1 == -1 ? Integer.MAX_VALUE : dp[i - 1][j];
                    int left = j - 1 == -1 ? Integer.MAX_VALUE : dp[i][j - 1];
                    dp[i][j] = grid[i][j] + Integer.min(top, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //longest palindromic substring
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void longestPalindromicSubstringF(String s, Queue<String> q) {
        if (s.length() == 1) return;
        if (isPalindrome(s) && q.peek() != null && s.length() > q.peek().length()) {
            q.offer(s);
            q.poll();
        }
        longestPalindromicSubstringF(s.substring(0, s.length() - 1), q);
        longestPalindromicSubstringF(s.substring(1), q);
    }

    public static String longestPalindromicSubstring() {
        String s = "babad";
        Queue<String> q = new LinkedList<>();
        q.offer(s.substring(0, 1));
        longestPalindromicSubstringF(s, q);
        return q.poll();
    }

    // triangle
    public static int triangleTabulation() {
        List<List<Integer>> triangle = new ArrayList<>(Arrays.asList(List.of(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0 && j == 0) dp[i][j] = triangle.get(i).get(j);
                else {
                    int top = Integer.MAX_VALUE;
                    if (i != j) top = dp[i - 1][j];
                    int topLeft = Integer.MAX_VALUE;
                    if (j > 0) topLeft = dp[i - 1][j - 1];
                    dp[i][j] = triangle.get(i).get(j) + Math.min(topLeft, top);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp[n - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }

    // maximum path sum
    public static int maximumPathSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int top = dp[i - 1][j];
                    int topLeft = Integer.MIN_VALUE;
                    if (j > 0) topLeft = dp[i - 1][j - 1];
                    int topRight = Integer.MIN_VALUE;
                    if (j < n - 1) topRight = dp[i - 1][j + 1];
                    dp[i][j] = matrix[i][j] + Math.max(Math.max(top, topLeft), topRight);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i : dp[m - 1]) {
            res = Math.max(res, i);
        }
        return res;
    }

    // subset sum
    public static boolean subsetSumF(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;
        boolean notTake = subsetSumF(index - 1, target, arr);
        boolean take = false;
        if (arr[index] <= target) take = subsetSumF(index - 1, target - arr[index], arr);
        return take || notTake;
    }

    public static void subsetSum() {
        int[] arr = new int[]{1, 12, 3, 4, 4};
        System.out.println(subsetSumF(arr.length - 1, 6, arr));

    }

    public static boolean subsetSumTabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) dp[0][arr[0]] = true;

        for (int index = 1; index < n; index++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[index - 1][t];
                boolean take = false;
                if (arr[index] <= t) take = dp[index - 1][t - arr[index]];
                dp[index][t] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }

    // Partition Array Into Two Arrays to Minimize Sum Difference
    public static int minSubsetSumDifferenceTabulation(int[] arr, int n) {
        int sum = 0;
        for (int a : arr) sum += a;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if (arr[index] <= target) take = dp[index - 1][target - arr[index]];
                dp[index][target] = notTake || take;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sum; i++) {
            if (dp[n - 1][i]) {
                minDiff = Math.min(minDiff, Math.abs(sum - i - i));
            }
        }
        return minDiff;
    }

    // count number of subsets
    public static int findWays(int[] arr, int tar) {
        int n = arr.length;
        arr = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        int[][] dp = new int[n][tar + 1];
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        if (arr[0] <= tar) dp[0][arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= tar; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (arr[i] <= target) take = dp[i - 1][target - arr[i]];
                dp[i][target] = take + notTake;
            }
        }
        return dp[n - 1][tar];
    }

    // Partitions With Given Difference
    public static int countPartitions(int n, int d, int[] arr) {
        arr = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i];
        int k = (sum - d) / 2;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        dp[0][arr[0]] = 1;
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                int notTake = dp[index - 1][target];
                int take = 0;
                if (arr[index] <= target) take = dp[index - 1][target - arr[index]];
                dp[index][target] = notTake + take;
            }
        }

        return dp[n - 1][k] % (10 ^ 9 + 7);
    }

    // 0 1 knapsack problem
    public static int knapSackF(int index, int weight, int[] profit, int[] weights) {
        if (weight == 0) return 0;
        if (index == 0) {
            if (weights[0] <= weight) return profit[index];
            else return 0;
        }
        int notTake = knapSackF(index - 1, weight, profit, weights);
        int take = Integer.MIN_VALUE;
        if (weights[index] <= weight)
            take = profit[index] + knapSackF(index - 1, weight - weights[index], profit, weights);
        return Math.max(notTake, take);
    }

    public static int knapSack(int capacity, int[] profit, int[] weight) {
        int n = profit.length;
        return knapSackF(n - 1, capacity, profit, weight);
    }

    public static int knapSackTabulation(int capacity, int[] profits, int[] weights) {
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];
        for (int w = weights[0]; w <= capacity; w++) dp[0][w] = profits[0];
        for (int index = 1; index < n; index++) {
            for (int weight = 0; weight <= capacity; weight++) {
                int notTake = dp[index - 1][weight];
                int take = Integer.MIN_VALUE;
                if (weights[index] <= weight) take = profits[index] + dp[index - 1][weight - weights[index]];
                dp[index][weight] = Math.max(notTake, take);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][capacity];
    }

    // coin change
    public static int coinChangeF(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return (int) 1e9;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int notTake = coinChangeF(index - 1, amount, coins, dp);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take = 1 + coinChangeF(index, amount - coins[index], coins, dp);
        }
        return dp[index][amount] = Math.min(notTake, take);
    }

    public static int coinChange(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int res = coinChangeF(n - 1, amount, coins, dp);
        if (res == (int) 1e9) return -1;
        return res;
    }

    public static int coinChangeTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int a = 0; a <= amount; a++) {
            if (a % coins[0] == 0) dp[0][a] = a / coins[0];
            else dp[0][a] = (int) 1e9;
        }
        for (int i = 1; i < n; i++) {
            for (int a = 0; a <= amount; a++) {
                int notTake = dp[i - 1][a];
                int take = Integer.MAX_VALUE;
                if (coins[i] <= a) take = 1 + dp[i][a - coins[i]];
                dp[i][a] = Math.min(take, notTake);
            }
        }

        int res = dp[n - 1][amount];
        if (res == (int) 1e9) return -1;
        return res;
    }

    // target sum
    public static int targetSumF(int index, int val, int target, int[] nums) {
        if (index == 0) {
            int add = val + nums[0] == target ? 1 : 0;
            int sub = val - nums[0] == target ? 1 : 0;
            return add + sub;
        }

        return
                targetSumF(index - 1, val + nums[index], target, nums)
                        +
                        targetSumF(index - 1, val - nums[index], target, nums);
    }

    public static int targetSum(int[] nums, int target) {
        int n = nums.length;
        return targetSumF(n - 1, 0, target, nums);
    }

    public static int targetSumTabulation(int[] nums, int target) {
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        int n = nums.length;
        HashMap<Integer, int[]> dp = new HashMap<>();
        int sum = 0;
        for (int num : nums) sum += num;

        for (int i = sum * -1; i <= sum; i++) {
            dp.put(i, new int[n]);
        }

        // base case
        for (int val = sum * -1; val <= sum; val++) {
            if (val + nums[0] == target || val - nums[0] == target) dp.get(val)[0] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int val = sum * -1; val <= sum; val++) {
                int add = 0;
                if (val + nums[index] <= sum) add = dp.get(val + nums[index])[index - 1];
                int sub = 0;
                if (val - nums[index] >= sum * -1) sub = dp.get(val - nums[index])[index - 1];
                dp.get(val)[index] = add + sub;
            }
        }

//        for (int i = sum * -1; i <= sum; i++) {
//            System.out.println(i + " => " + Arrays.toString(dp.get(i)));
//        }

        if (sum == 0) return dp.get(0)[n - 1] * 2;

        return dp.get(0)[n - 1];
    }

    // coin change 2
    public static int coinChange2F(int index, int amount, int[] coins) {
        if (amount == 0) return 1;
        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int notTake = coinChange2F(index - 1, amount, coins);
        int take = 0;
        if (coins[index] <= amount) take = coinChange2F(index, amount - coins[index], coins);
        return notTake + take;
    }

    public static int coinChange2(int amount, int[] coins) {
        int n = coins.length;
        return coinChange2F(n - 1, amount, coins);
    }

    public static int coinChange2Tabulation(int amount, int[] coins) {
        int n = coins.length;
        // dp
        int[][] dp = new int[n][amount + 1];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int a = 1; a <= amount; a++) {
            dp[0][a] = a % coins[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int a = 1; a <= amount; a++) {
                int notTake = dp[i - 1][a];
                int take = 0;
                if (coins[i] <= a) take = dp[i][a - coins[i]];
                dp[i][a] = notTake + take;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][amount];
    }

    // unbounded knapsack
    public static int unboundedKnapsackF(int index, int w, int[] profit, int[] weight) {
        if (index == 0) {
            return w % weight[0] == 0 ? (w / weight[0]) * profit[0] : 0;
        }
        int notTake = unboundedKnapsackF(index - 1, w, profit, weight);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= w) take = profit[index] + unboundedKnapsackF(index, w - weight[index], profit, weight);
        return Math.max(notTake, take);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return unboundedKnapsackF(n - 1, w, profit, weight);
    }

    public static int unboundedKnapsackTabulation(int n, int w, int[] profit, int[] weight) {
        // dp
        int[][] dp = new int[n][w + 1];
        // base case
        for (int i = 0; i <= w; i++) {
            dp[0][i] = (i / weight[0]) * profit[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= j) take = profit[i] + dp[i][j - weight[i]];
                dp[i][j] = Math.max(take, notTake);
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][w];
    }

    // rod cutting problem
    public static int rodCuttingF(int index, int length, int[] prices) {
        if (length == 0) return 0;
        if (index == 0) {
            return length * prices[0];
        }
        int notTake = rodCuttingF(index - 1, length, prices);
        int take = Integer.MIN_VALUE;
        if (index + 1 <= length) take = prices[index] + rodCuttingF(index, length - (index + 1), prices);
        return Math.max(take, notTake);
    }

    public static int rodCutting(int[] prices, int n) {
        return rodCuttingF(n - 1, n, prices);
    }

    public static int rodCuttingTabulation(int[] prices, int n) {
        // dp
        int[][] dp = new int[n][n + 1];

        // base case
        for (int length = 0; length <= n; length++) {
            dp[0][length] = length * prices[0];
        }

        for (int index = 1; index < n; index++) {
            for (int length = 0; length <= n; length++) {
                int notTake = dp[index - 1][length];
                int take = Integer.MIN_VALUE;
                if (index + 1 <= length) take = prices[index] + dp[index][length - (index + 1)];
                dp[index][length] = Math.max(take, notTake);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][n];
    }

    //Longest common subsequence
    public static int longestCommonSubsequenceF(int index1, int index2, String text1, String text2) {
        if (index1 < 0 || index2 < 0) return 0;
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + longestCommonSubsequenceF(index1 - 1, index2 - 1, text1, text2);
        }
        return Math.max(
                longestCommonSubsequenceF(index1 - 1, index2, text1, text2),
                longestCommonSubsequenceF(index1, index2 - 1, text1, text2)
        );
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        return longestCommonSubsequenceF(n1 - 1, n2 - 1, text1, text2);
    }

    public static int longestCommonSubsequenceTabulation(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // dp
        int[][] dp = new int[n1 + 1][n2 + 1];
        // base case
//        for (int i = 0; i < n2; i++) dp[0][i] = text1.charAt(0) == text2.charAt(i) ? 1 : 0;
//        for (int i = 0; i < n1; i++) dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : 0;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // shifting of index saved us complicated calculation of 0 row and column
        System.out.println(Arrays.deepToString(dp));

        return dp[n1][n2];
    }

    // print the lcs
    public static String printLongestCommonSubsequenceTabulation(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        String[][] dp = new String[n1 + 1][n2 + 1];
        //base case
        for (int i = 0; i <= n2; i++) dp[0][i] = "";
        for (int i = 0; i <= n1; i++) dp[i][0] = "";

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + text1.charAt(i - 1);
                else dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        return dp[n1][n2];
    }

    // longest common substring
    public static int longestCommonSubstringF(int index1, int index2, int sub, String text1, String text2) {
        if (index1 < 0 || index2 < 0) return sub;

        if (text1.charAt(index1) == text2.charAt(index2))
            sub = longestCommonSubstringF(index1 - 1, index2 - 1, sub + 1, text1, text2);

        return Math.max(sub,
                Math.max(
                        longestCommonSubstringF(index1 - 1, index2, 0, text1, text2),
                        longestCommonSubstringF(index1, index2 - 1, 0, text1, text2)
                )
        );
    }

    public static int longestCommonSubstring(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        return longestCommonSubstringF(n1 - 1, n2 - 1, 0, text1, text2);
    }

    public static int longestCommonSubstringTabulation(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    //print longest common substring
    public static String printLongestCommonSubstringTabulation(String s1, String s2) {
        String res = "";
        int n1 = s1.length();
        int n2 = s2.length();
        String[][] dp = new String[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = "";
        for (int j = 0; j <= n2; j++) dp[0][j] = "";

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                    res = dp[i][j].length() > res.length() ? dp[i][j] : res;
                } else dp[i][j] = "";
            }
        }
        return res;
    }

    // longest palindrome subsequence
    public static int longestPalindromeSubsequence(String s) {
        int n = s.length();
        StringBuilder reverse = new StringBuilder();
        reverse.append(s);
        reverse.reverse();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reverse.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][n];
    }

    // minimum insertions to make a string palindrome
    public static int minimumInsertionToPalindrome(String s) {
        int n = s.length();
        StringBuilder reverse = new StringBuilder();
        reverse.append(s);
        reverse.reverse();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reverse.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[j - 1][i]);
            }
        }
        return n - dp[n][n];
    }

    // minimum insertions/deletions to convert String "a" to String "b"
    public static int minimumInsertionsDeletionsToCovertAStringToAnother(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        int deletions = n - dp[n][m];
        int insertions = m - dp[n][m];
        return deletions + insertions;
    }

    // Shortest Common SuperSequence
    public static String shortestCommonSuperSequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        int i = n;
        int j = m;
        String res = "";
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                res = a.charAt(i - 1) + res;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res = a.charAt(i - 1) + res;
                i--;
            } else {
                res = b.charAt(j - 1) + res;
                j--;
            }
        }
        while (i > 0) {
            res = a.charAt(i - 1) + res;
            i--;
        }
        while (j > 0) {
            res = b.charAt(j - 1) + res;
            j--;
        }

        return res;
    }

    // maximum even sum
    public static int maximumEvenSumF(int index, int sum, int[] nums, HashMap<List<Integer>, Integer> dp) {
        // base case
        if (index == 0) {
            int pick = nums[0] + sum;
            int notPick = sum;
            if (pick % 2 == 0 && notPick % 2 == 0) return Math.max(pick, notPick);
            if (pick % 2 == 0) return pick;
            if (notPick % 2 == 0) return notPick;
            return Integer.MIN_VALUE;
        }

        if (dp.containsKey(Arrays.asList(index, sum))) {
            return dp.get(Arrays.asList(index, sum));
        }


        int pick = maximumEvenSumF(index - 1, nums[index] + sum, nums, dp);
        int notPick = maximumEvenSumF(index - 1, sum, nums, dp);
        dp.put(
                Arrays.asList(index, sum),
                Math.max(pick, notPick)
        );
        return dp.get(Arrays.asList(index, sum));
    }

    public static int maximumEvenSum(int[] nums) {
        int n = nums.length;
        HashMap<List<Integer>, Integer> dp = new HashMap<>();
        return maximumEvenSumF(n - 1, 0, nums, dp);
    }

    // distinct subsequence
    public static int distinctSubsequencesF(int i, int j, String s1, String s2) {
        if (j == -1) return 1;
        if (i == -1) return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return distinctSubsequencesF(i - 1, j - 1, s1, s2) + distinctSubsequencesF(i - 1, j, s1, s2);
        return distinctSubsequencesF(i - 1, j, s1, s2);
    }

    public static int distinctSubsequences(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        return distinctSubsequencesF(n1 - 1, n2 - 1, s1, s2);
    }

    public static int distinctSubsequencesTabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = 1;
        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n1][n2];
    }

    // edit distance (Levenshtein distance)
    public static int editDistanceF(int i, int j, String word1, String word2) {
        if (j == -1) return i + 1;
        if (i == -1) return j + 1;
        if (word1.charAt(i) == word2.charAt(j)) return editDistanceF(i - 1, j - 1, word1, word2);
        int insert = 1 + editDistanceF(i, j - 1, word1, word2);
        int delete = 1 + editDistanceF(i - 1, j, word1, word2);
        int replace = 1 + editDistanceF(i - 1, j - 1, word1, word2);
        return Math.min(insert, Math.min(delete, replace));
    }

    public static int editDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        return editDistanceF(n1 - 1, n2 - 1, word1, word2);
    }

    public static int editDistanceTabulation(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // base case
        for (int i = 0; i <= n1; i++) dp[i][0] = i;
        for (int j = 0; j <= n2; j++) dp[0][j] = j;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int delete = 1 + dp[i - 1][j];
                    int insert = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[n1][n2];
    }

    // wild card matching
    public static boolean wildCardMatchingF(int i, int j, String s, String p) {
        if (j == -1 && i == -1) return true;
        if (j == -1) return false;
        if (i == -1) {
            for (int k = 0; k <= j; k++) if (p.charAt(k) != '*') return false;
            return true;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return wildCardMatchingF(i - 1, j - 1, s, p);
        }
        if (p.charAt(j) == '*') {
            return wildCardMatchingF(i - 1, j, s, p) || wildCardMatchingF(i, j - 1, s, p);
        }
        return false;
    }

    public static boolean wildCardMatching(String s, String p) {
        int ns = s.length();
        int ps = p.length();
        return wildCardMatchingF(ns - 1, ps - 1, s, p);
    }

    public static boolean wildCardMatchingTabulation(String s, String p) {
        int ns = s.length();
        int np = p.length();
        boolean[][] dp = new boolean[ns + 1][np + 1];

        // base case
        for (int i = 0; i <= ns; i++) dp[i][0] = false;
        for (int j = 0; j <= np; j++) {
            dp[0][j] = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') dp[0][j] = false;
            }
        }
        dp[0][0] = true;

        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= np; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[ns][np];
    }

    // longest palindromic substring
    public static String longestPalindromeSubstringTabulation(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        String[][] dp = new String[n + 1][n + 1];
        String res = "";

        for (int i = 0; i <= n; i++) dp[i][0] = "";
        for (int j = 0; j <= n; j++) dp[0][j] = "";

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s.charAt(i - 1);
                    res = dp[i][j].length() > res.length() ? dp[i][j] : res;
                } else dp[i][j] = "";
            }
        }
        return res;
    }

    public static int decodeWaysF(int index, String s) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        int res = decodeWaysF(index + 1, s);
        if (index + 1 < s.length() && (s.charAt(index) == '1' || (s.charAt(index) == '2' && Arrays.asList('0', '1', '2', '3', '4', '5', '6').contains(s.charAt(index + 1))))) {
            res += decodeWaysF(index + 2, s);
        }
        return res;
    }

    public static int decodeWays(String s) {
        return decodeWaysF(0, s);
    }

    public static int decodeWaysTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        // base case
        dp[n] = 1;
        for (int i = n - 1; i > -1; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {

                int res = dp[i + 1];
                if (i + 1 < n && (
                        (s.charAt(i) == '1') ||
                                (s.charAt(i) == '2' && Arrays.asList('0', '1', '2', '3', '4', '5', '6').contains(s.charAt(i + 1)))
                )
                ) {
                    res += dp[i + 2];
                }
                dp[i] = res;
            }
        }
        return dp[0];
    }

    public static boolean canForm(String a, String b) {
        int na = a.length();
        int nb = b.length();
        int[][] dp = new int[na + 1][nb + 1];
        for (int i = 1; i <= na; i++) {
            for (int j = 1; j <= nb; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int lcs = dp[na][nb];
        if (lcs == 0 && !a.isEmpty()) return false;
        else if (lcs == 0) return true;
        if (lcs < a.length()) return false;
        return true;
    }

    public static boolean interleaving(String s1, String s2, String s3) {
        boolean first = canForm(s1, s3);
        boolean second = canForm(s2, s3);
        return first && second;
    }

    public static int bestTimeToBuy(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}

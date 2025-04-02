import binaryTree.BinaryTree;
import binaryTree.TreeNode;
import graph.Graph;
import mapper.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Double[]> m = new HashMap<>();
        System.out.println(m);

        System.out.println(secondMax(Arrays.asList(12, 34, 2, 34, 33, 1)));
        System.out.println(moveZero(Arrays.asList(8, 1, 0, 2, 1, 0, 3)));
        System.out.println(moveZero(Arrays.asList(0, 1, 0, 3, 12)));
        System.out.println(nextGreater(Arrays.asList(4, 7, 3, 4, 8, 1)));
        System.out.println(validParentheses("{{{[]}}}"));
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
        System.out.println(g.bfs(0));

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 3);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        System.out.println(g2.bfs(0));

        Graph g3 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 3);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        System.out.println(g2.bfs(0));

        numberOfProvinces(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        numberOfProvinces(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
        validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
        floodFillAlgo(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        floodFillAlgo(new int[][]{{1}, {1}, {0}}, 2, 0, 1);
        System.out.println("======================================");
        System.out.println(
                rottenOranges(new int[][]{
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                }));
        System.out.println(
                rottenOranges(new int[][]{
                        {2, 1, 1},
                        {0, 1, 1},
                        {1, 0, 1}
                }));
        System.out.println(
                rottenOranges(new int[][]{{0, 2}}));
        System.out.println(
                rottenOranges(new int[][]{{1, 2}}));
        System.out.println(
                rottenOranges(new int[][]{{0, 1}}));
        System.out.println(
                rottenOranges(new int[][]{
                        {2, 1, 1},
                        {1, 1, 1},
                        {0, 1, 2}
                }));
        System.out.println(
                rottenOranges(new int[][]{{0}}));
        System.out.println("======================================");
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
        System.out.println("======================================");
        System.out.println(shortestPathInBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(shortestPathInBinaryMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        System.out.println(
                shortestPathInBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println("======================================");
        dfs(new int[][]{{2, 3, 1}, {0}, {0, 4}, {0}, {2}});
        System.out.println();
        System.out.println("======================================");
        System.out.println(Arrays.deepToString(zeroOneMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
        System.out.println();
        System.out.println(Arrays.deepToString(zeroOneMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
        System.out.println("======================================");
        surroundedRegions(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}});
        System.out.println();
        surroundedRegions(new char[][]{{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'O', 'X'}});
        System.out.println("======================================");
        System.out.println(
                numberOfEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println(
                numberOfEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
        System.out.println("======================================");
        System.out.println(distinctIslands(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}}));

        System.out.println(distinctIslands(
                new int[][]{{1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}}));
        System.out.println("======================================");
        System.out.println(assignCookies(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(assignCookies(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.ninjaTraining());
        System.out.println(DynamicProgramming.ninjaTrainingTabulation());
        System.out.println("======================================");
        System.out.println(DynamicProgramming.jumpGame());
        System.out.println(DynamicProgramming.jumpGameTabulation());
        System.out.println("======================================");
        System.out.println(DynamicProgramming.uniquePaths(3, 7));
        System.out.println(DynamicProgramming.uniquePaths(3, 3));
        System.out.println(DynamicProgramming.uniquePathsTabulation(3, 3));
        System.out.println(
                DynamicProgramming.uniquePaths2Tabulation(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println("======================================");
        // System.out.println(DynamicProgramming.longestPalindromicSubstring("10110"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.triangleTabulation());
        System.out.println("======================================");
        System.out.println(DynamicProgramming.maximumPathSum(new int[][]{
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        }));
        System.out.println("======================================");
        DynamicProgramming.subsetSum();
        System.out.println(DynamicProgramming.subsetSumTabulation(new int[]{1, 2, 3, 4, 5}, 8));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.minSubsetSumDifferenceTabulation(new int[]{1, 2, 3, 4}, 4));
        // System.out.println(DynamicProgramming.minSubsetSumDifference(new int[]{-36,
        // 36}, 2));
        System.out.println(
                DynamicProgramming.minSubsetSumDifferenceTabulation(new int[]{76, 8, 45, 20, 74, 84, 28, 1}, 8));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.findWays(new int[]{0, 1, 3}, 4));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.countPartitions(4, 3, new int[]{5, 2, 6, 4}));
        System.out.println(DynamicProgramming.countPartitions(4, 0, new int[]{1, 1, 1, 1}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.knapSack(5, new int[]{1, 7, 11}, new int[]{1, 2, 3}));
        System.out.println(DynamicProgramming.knapSackTabulation(5, new int[]{1, 7, 11}, new int[]{1, 2, 3}));
        System.out.println(DynamicProgramming.knapSackTabulation(4, new int[]{1, 2, 3}, new int[]{4, 5, 1}));
        System.out.println(DynamicProgramming.knapSackTabulation(7, new int[]{10, 8, 6}, new int[]{1, 7, 9}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.coinChange(11, new int[]{1, 2, 5}));
        System.out.println(DynamicProgramming.coinChange(27, new int[]{2, 5, 10, 1}));
        System.out.println(DynamicProgramming.coinChange(1, new int[]{2}));
        System.out.println(DynamicProgramming.coinChangeTabulation(11, new int[]{1, 2, 5}));
        System.out.println(DynamicProgramming.coinChangeTabulation(27, new int[]{2, 5, 10, 1}));
        System.out.println(DynamicProgramming.coinChangeTabulation(1, new int[]{2}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.targetSum(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(DynamicProgramming.targetSumTabulation(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(DynamicProgramming.targetSumTabulation(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
        System.out.println(DynamicProgramming.targetSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.coinChange2(5, new int[]{1, 2, 5}));
        System.out.println(DynamicProgramming.coinChange2Tabulation(5, new int[]{1, 2, 5}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.unboundedKnapsack(3, 10, new int[]{5, 11, 13}, new int[]{2, 4, 6}));
        System.out.println(
                DynamicProgramming.unboundedKnapsackTabulation(3, 10, new int[]{5, 11, 13}, new int[]{2, 4, 6}));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.rodCutting(new int[]{2, 5, 7, 8, 10}, 5));
        System.out.println(DynamicProgramming.rodCutting(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8));
        System.out.println(DynamicProgramming.rodCutting(new int[]{3, 5, 6, 7, 10, 12}, 6));
        System.out.println(DynamicProgramming.rodCuttingTabulation(new int[]{2, 5, 7, 8, 10}, 5));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.longestCommonSubsequence("abcde", "ace"));
        System.out.println(DynamicProgramming.longestCommonSubsequenceTabulation("abcde", "ace"));
        System.out.println(DynamicProgramming.printLongestCommonSubsequenceTabulation("abcde", "ace"));
        System.out.println(DynamicProgramming.printLongestCommonSubsequenceTabulation("abcde", "bdqek"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.longestCommonSubstring("abcde", "ace"));
        System.out.println(DynamicProgramming.longestCommonSubstring("abcde", "bcd"));
        System.out.println(DynamicProgramming.longestCommonSubstringTabulation("abcde", "bcd"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.longestPalindromeSubsequence("bbbab"));
        System.out.println(DynamicProgramming.longestPalindromeSubsequence("cbbd"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.minimumInsertionsDeletionsToCovertAStringToAnother("aaa", "aa"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.shortestCommonSuperSequence("brute", "groot"));
        System.out.println(DynamicProgramming.shortestCommonSuperSequence("bleed", "blue"));
        System.out.println(DynamicProgramming.shortestCommonSuperSequence("coding", "ninjas"));
        System.out.println(DynamicProgramming.shortestCommonSuperSequence("blinding", "lights"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.maximumEvenSum(new int[]{-1, -2, -3, 8, 7}));
        System.out.println(DynamicProgramming.maximumEvenSum(new int[]{3, 2, 7, 6, 1, 4}));
        System.out.println("======================================");
        System.out.println(Arrays.toString(batonPassing(new int[]{1, 2, 3, 4})));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.distinctSubsequences("babgbag", "bag"));
        System.out.println(DynamicProgramming.distinctSubsequences("rabbbit", "rabbit"));
        System.out.println(DynamicProgramming.distinctSubsequencesTabulation("babgbag", "bag"));
        System.out.println(DynamicProgramming.distinctSubsequencesTabulation("rabbbit", "rabbit"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.editDistance("horse", "ros"));
        System.out.println(DynamicProgramming.editDistance("intention", "execution"));
        System.out.println(DynamicProgramming.editDistanceTabulation("horse", "ros"));
        System.out.println(DynamicProgramming.editDistanceTabulation("intention", "execution"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.wildCardMatching("aa", "*"));
        System.out.println(DynamicProgramming.wildCardMatching("aa", "a"));
        System.out.println(DynamicProgramming.wildCardMatching("cb", "?a"));

        System.out.println(DynamicProgramming.wildCardMatchingTabulation("aa", "*"));
        System.out.println(DynamicProgramming.wildCardMatchingTabulation("aa", "a"));
        System.out.println(DynamicProgramming.wildCardMatchingTabulation("cb", "?a"));
        System.out.println(DynamicProgramming.wildCardMatchingTabulation("aab", "c*a*b"));
        System.out.println(DynamicProgramming.wildCardMatchingTabulation("zacabz", "*a?b*"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.longestPalindromeSubstringTabulation("10110"));
        System.out.println(DynamicProgramming.longestPalindromeSubstringTabulation("geeks"));
        System.out.println(DynamicProgramming.longestPalindromeSubstringTabulation("racecar"));

        System.out.println(longestPalindromicSubstring("10110"));
        System.out.println(longestPalindromicSubstring("geeks"));
        System.out.println(longestPalindromicSubstring("racecar"));
        System.out.println("======================================");
        List<Integer[]> list = new ArrayList<>();
        HashSet<Integer[]> set = new HashSet<>();
        List<Integer[]> arr = new ArrayList<>(set);
        arr.sort((a, b) -> {
            if (a[0].compareTo(b[0]) == 0) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        HashMap<String, Double[]> map = new HashMap<>();
        List<Map.Entry<String, Double[]>> entry = new ArrayList<>(map.entrySet());
        entry.sort((a, b) -> {
            if (a.getValue()[0].compareTo(b.getValue()[0]) == 0) {
                return a.getValue()[1].compareTo(b.getValue()[1]);
            }
            return a.getValue()[0].compareTo(b.getValue()[0]);
        });

        for (Map.Entry<String, Double[]> mp : map.entrySet()) {
            mp.getValue();
            mp.getKey();
        }

        for (Integer[] hs : set) {

        }
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNext()) {
        // String str = sc.nextLine();
        // }
        System.out.println("======================================");
        System.out.println(Arrays.toString(balancedBrackets(new String[]{")(", "(()", "()"})));
        System.out.println(Arrays.toString(balancedBrackets(new String[]{"((())", ")((())"})));
        System.out.println("======================================");
        Movie.lcs("there is a subsequence to print", "ly sequence print");
        System.out.println("======================================");
        System.out.println(DynamicProgramming.decodeWays("123"));
        System.out.println(DynamicProgramming.decodeWays("06"));
        System.out.println(DynamicProgramming.decodeWays("10"));
        System.out.println(DynamicProgramming.decodeWays("27"));

        System.out.println(DynamicProgramming.decodeWaysTabulation("123"));
        System.out.println(DynamicProgramming.decodeWaysTabulation("06"));
        System.out.println(DynamicProgramming.decodeWaysTabulation("10"));
        System.out.println(DynamicProgramming.decodeWaysTabulation("27"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.interleaving("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(DynamicProgramming.interleaving("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(DynamicProgramming.interleaving("", "", ""));
        System.out.println(DynamicProgramming.interleaving("a", "b", "a"));
        System.out.println(DynamicProgramming.interleaving("", "abc", "ab"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.printLongestCommonSubsequenceTabulation("To print subsequence",
                "fly print sequence"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.printLongestCommonSubstringTabulation("abcjklp", "acjkp"));
        System.out.println(DynamicProgramming.printLongestCommonSubstringTabulation("i love leetcode coding",
                "coding is my passion"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.longestPalindromeSubstringTabulation("Geeks"));
        System.out.println(DynamicProgramming.longestPalindromeSubstringTabulation("10110"));
        System.out.println(DynamicProgramming.longestPalindromeSubstringTabulation("1133345667"));
        System.out.println("======================================");
        System.out.println(DynamicProgramming.bestTimeToBuy(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("======================================");
        System.out.println(Arrays.toString(generateBinaryNumber1ToN(4)));
        System.out.println("======================================");
        BinaryTree tree = createBinaryTree();
        preOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println("======================================");
        iterativePreOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println("======================================");
        inOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println("======================================");
        iterativeInOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println("======================================");
        postOrderTraversal(tree.getRoot());
        System.out.println();
        iterativePostOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println("======================================");

        StateDto state1 = new StateDto(100, "s-1", true);
        DistrictDto district = new DistrictDto(11, "d-1", true);
        DistrictDto dist1 = new DistrictDto(12, "d-2", true);
        DistrictDto dist2 = new DistrictDto(13, "d-3", true);
        DistrictDto dist3 = new DistrictDto(14, "d-4", true);

        CityDto city1 = new CityDto(21, "c-1", true);
        CityDto city2 = new CityDto(22, "c-2", true);
        CityDto city3 = new CityDto(23, "c-3", true);
        CityDto city4 = new CityDto(24, "c-4", true);
        CityDto city5 = new CityDto(25, "c-5", true);
        CityDto city6 = new CityDto(26, "c-6", true);
        CityDto city7 = new CityDto(27, "c-7", true);
        CityDto city8 = new CityDto(28, "c-8", true);
        CityDto city9 = new CityDto(29, "c-9", true);
        CityDto city10 = new CityDto(30, "c-10", true);
        CityDto city11 = new CityDto(31, "c-11", true);
        CityDto city12 = new CityDto(32, "c-12", true);

        state1.addDistrict(district);
        state1.addDistrict(dist1);
        state1.addDistrict(dist2);
        state1.addDistrict(dist3);
        district.setState(state1);
        dist1.setState(state1);
        dist2.setState(state1);
        dist3.setState(state1);

        district.setCities(new ArrayList<>(List.of(city1, city2, city3)));
        city1.setDistrict(district);
        city2.setDistrict(district);
        city3.setDistrict(district);

        dist1.setCities(new ArrayList<>(List.of(city4, city5, city6)));
        city4.setDistrict(dist1);
        city5.setDistrict(dist1);
        city6.setDistrict(dist1);

        dist2.setCities(new ArrayList<>(List.of(city7, city8, city9)));
        city7.setDistrict(dist2);
        city8.setDistrict(dist2);
        city9.setDistrict(dist2);

        dist3.setCities(new ArrayList<>(List.of(city10, city11, city12)));
        city10.setDistrict(dist3);
        city11.setDistrict(dist3);
        city12.setDistrict(dist3);

        Map<Class<? extends MasterDto>, Class<? extends MasterEntity>> dtoEntityMap = Map.ofEntries(
                Map.entry(StateDto.class, StateEntity.class),
                Map.entry(DistrictDto.class, DistrictEntity.class),
                Map.entry(CityDto.class, CityEntity.class));

        Map<Class<? extends MasterEntity>, Class<? extends MasterDto>> entityDtoMap = Map.ofEntries(
                Map.entry(StateEntity.class, StateDto.class),
                Map.entry(DistrictEntity.class, DistrictDto.class),
                Map.entry(CityEntity.class, CityDto.class));

        StateEntity stateEntity = (StateEntity) EntityDtoMapper.mapToEntity(state1, dtoEntityMap);
        System.out.println(stateEntity);

        StateDto stateDto = (StateDto) EntityDtoMapper.mapToDto(stateEntity, entityDtoMap);
        System.out.println(stateDto);


    }

    public static void iterativePostOrderTraversal(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                TreeNode temp = stack.peek().getRight();
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.getData() + " ");
                    while (!stack.isEmpty() && temp == stack.peek().getRight()) {
                        temp = stack.pop();
                        System.out.print(temp.getData() + " ");
                    }
                } else {
                    current = temp;
                }

            }
        }
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public static void iterativeInOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            } else {
                temp = stack.pop();
                System.out.print(temp.getData() + " ");
                temp = temp.getRight();
            }
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRight());
    }

    public static void iterativePreOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public static BinaryTree createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        BinaryTree tree = new BinaryTree(first);
        first.setLeft(second);
        first.setRight(third);

        second.setLeft(fourth);
        second.setRight(fifth);

        third.setLeft(sixth);
        third.setRight(seventh);

        return tree;
    }

    public static String[] generateBinaryNumber1ToN(int n) {
        String[] res = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            res[i] = queue.poll();
            String binaryNumberOne = res[i] + "0";
            String binaryNumberTwo = res[i] + "1";
            queue.offer(binaryNumberOne);
            queue.offer(binaryNumberTwo);
        }
        return res;
    }

    public static int costToCorrect(String s) {
        // part of balancedBrackets()
        int n = s.length();
        int corrections = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    corrections++;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() != corrections) {
            return 0;
        }
        return stack.size() <= 1 ? 1 : 0;
    }

    public static int[] balancedBrackets(String[] str) {
        int n = str.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = costToCorrect(str[i]);
        }
        return res;
    }

    // largestPalindromic substring
    public static String longestPalindromicSubstring(String s) {
        int n = s.length();

        int maxLength = Integer.MIN_VALUE;
        int start = -1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int curLength = high - low;
                    if (curLength > maxLength) {
                        maxLength = curLength;
                        start = low;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start + maxLength + 1);
    }

    // baton passing
    public static int[] batonPassing(int[] arr) {
        int n = arr.length;

        int[] newArr = new int[n + (n - 2)];
        int revIndex = n - 2;
        for (int i = 0; i < newArr.length; i++) {
            if (i < n) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[revIndex];
                revIndex--;
            }
        }
        System.out.println(Arrays.toString(newArr));

        int index = 0;
        int[] res = new int[5 + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = newArr[index++];
            if (index > newArr.length - 1)
                index = 0;
        }
        System.out.println(Arrays.toString(res));
        return new int[]{res[0], res[res.length - 1]};
    }

    // assign cookies
    public static int assignCookies(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int satisfied = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[index]) {
                index++;
                satisfied++;
                if (index == g.length)
                    return satisfied;
            }
        }
        return satisfied;
    }

    // number of distinct islands
    public static int distinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Set<List<List<Integer>>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j, i, j});
                    List<List<Integer>> distance = new ArrayList<>();
                    while (!q.isEmpty()) {
                        int[] u = q.poll();
                        int x1 = u[0];
                        int y1 = u[1];
                        int px = u[2];
                        int py = u[3];
                        for (int[] dir : dirs) {
                            List<Integer> d = new ArrayList<>();
                            int x2 = dir[0];
                            int y2 = dir[1];
                            if (x1 + x2 > -1 && x1 + x2 < m && y1 + y2 > -1 && y1 + y2 < n) {
                                if (!visited[x1 + x2][y1 + y2] && grid[x1 + x2][y1 + y2] == 1) {
                                    visited[x1 + x2][y1 + y2] = true;
                                    q.offer(new int[]{x1 + x2, y1 + y2, px, py});
                                    d.add(px - (x1 + x2));
                                    d.add(py - (y1 + y2));
                                    distance.add(d);
                                }
                            }
                        }
                    }
                    set.add(distance);
                }
            }
        }
        return set.size();
    }

    // number of enclaves
    public static int numberOfEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int enclaves = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        // skip
                    } else if (grid[i][j] == 1) {
                        boolean isSurrounded = true;
                        int landCells = 0;
                        // do bfs
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] u = q.poll();
                            int x1 = u[0];
                            int y1 = u[1];
                            landCells++;
                            for (int[] dir : dirs) {
                                int x2 = dir[0];
                                int y2 = dir[1];
                                if ((x1 + x2 > -1 && x1 + x2 < m) && (y1 + y2 > -1 && y1 + y2 < n)) {
                                    if (!visited[x1 + x2][y1 + y2] && grid[x1 + x2][y1 + y2] == 1) {
                                        q.offer(new int[]{x1 + x2, y1 + y2});
                                        visited[x1 + x2][y1 + y2] = true;
                                        if (x1 + x2 == 0 || y1 + y2 == 0 || x1 + x2 == m - 1 || y1 + y2 == n - 1)
                                            isSurrounded = false;
                                    }
                                }
                            }
                        }
                        if (isSurrounded) {
                            enclaves += landCells;
                        }
                    }
                }
            }
        }
        return enclaves;
    }

    // surrounded regions
    public static void surroundedRegions(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        char[][] copy = new char[m][n];
        // make the board with only x
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = 'X';
            }
        }

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == m - 1 || j == n - 1 || i == 0 || j == 0)) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] u = q.poll();
            int x1 = u[0];
            int y1 = u[1];
            copy[x1][y1] = 'O';
            for (int[] dir : dirs) {
                int x2 = dir[0];
                int y2 = dir[1];
                if ((x1 + x2 > -1 && x1 + x2 < m) && (y1 + y2 > -1 && y1 + y2 < n)) {
                    if (!visited[x1 + x2][y1 + y2] && board[x1 + x2][y1 + y2] == 'O') {
                        visited[x1 + x2][y1 + y2] = true;
                        q.offer(new int[]{x1 + x2, y1 + y2});
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = copy[i][j];
            }
        }

        for (char[] i : board) {
            for (char j : i) {
                System.out.printf(j + ",");
            }
            System.out.println();
        }

    }

    // 0 1 matrix
    public static int[][] zeroOneMatrix(int[][] mat) {
        int[][] res = mat;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        // do the bfs
        while (!q.isEmpty()) {
            int[] u = q.poll();
            int pi = u[0];
            int py = u[1];
            int d = u[2];
            for (int[] dir : dirs) {
                int ci = dir[0];
                int cy = dir[1];
                if (pi + ci > -1 && pi + ci < m && py + cy > -1 && py + cy < n) {
                    if (!visited[pi + ci][py + cy] && res[pi + ci][py + cy] == 1) {
                        visited[pi + ci][py + cy] = true;
                        q.offer(new int[]{pi + ci, py + cy, d + 1});
                        res[pi + ci][py + cy] = d + 1;
                    }
                }
            }
        }
        for (int[] i : res) {
            for (int j : i) {
                System.out.printf(j + ",");
            }
            System.out.println();
        }
        return res;
    }

    // dfs using recursion
    public static void dfs(int u, boolean[] visited, int[][] adj) {
        visited[u] = true;
        System.out.printf(u + ", ");
        for (int j : adj[u]) {
            if (!visited[j]) {
                dfs(j, visited, adj);
            }
        }
    }

    // main function of dfs
    public static void dfs(int[][] adj) {
        boolean[] visited = new boolean[adj.length];
        dfs(0, visited, adj);
    }

    // shortest path in a binary matrix
    public static int shortestPathInBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = new int[][]{
                {1, 0}, {0, 1}, {-1, 0}, {0, -1},
                {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        };
        Queue<int[]> q = new LinkedList<>();

        // do bfs
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] u = q.poll();
            int x1 = u[0];
            int y1 = u[1];
            int l = u[2];
            if (x1 == n - 1 && y1 == n - 1)
                return l;
            for (int[] dir : dirs) {
                int x2 = dir[0];
                int y2 = dir[1];
                int x = x1 + x2;
                int y = y1 + y2;
                if (x > -1 && x < n && y > -1 && y < n) {
                    if (!visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        q.offer(new int[]{x, y, l + 1});
                    }
                }
            }
        }
        return -1;
    }

    // detect a cycle
    public static boolean isCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                q.offer(new int[]{i, -1});
                visited[i] = true;
                while (!q.isEmpty()) {
                    int[] u = q.poll();
                    if (q.peek() != null && q.peek()[1] == u[1])
                        return true;
                    for (int j : adj.get(u[0])) {
                        if (!visited[j]) {
                            visited[j] = true;
                            q.offer(new int[]{j, u[0]});
                        } else if (j != u[1]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // minimum height trees
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // brute force
        List<Integer> res = new ArrayList<>();
        List<int[]> pair = new ArrayList<>();
        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
        // make the adj
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{i, 0});
            visited[i] = true;
            int h = Integer.MIN_VALUE;
            while (!q.isEmpty()) {
                int[] u = q.poll();
                int node = u[0];
                int height = u[1];
                h = Math.max(h, height);
                for (int j : adj[node]) {
                    if (!visited[j]) {
                        visited[j] = true;
                        q.offer(new int[]{j, height + 1});
                    }
                }
            }
            pair.add(new int[]{i, h});
            minHeight = Math.min(minHeight, h);
        }
        for (int[] p : pair) {
            if (p[1] == minHeight)
                res.add(p[0]);
        }

        return res;
    }

    // rotten oranges
    public static int rottenOranges(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] u = q.poll();
            int x1 = u[0];
            int y1 = u[1];
            int t = u[2];
            for (int i = 0; i < 4; i++) {
                int x2 = dirs[i][0];
                int y2 = dirs[i][1];
                if ((x1 + x2 < grid.length && x1 + x2 > -1) && (y1 + y2 < grid[0].length && y1 + y2 > -1)) {
                    if (!visited[x1 + x2][y1 + y2] && grid[x1 + x2][y1 + y2] == 1) {
                        visited[x1 + x2][y1 + y2] = true;
                        grid[x1 + x2][y1 + y2] = 2;
                        q.offer(new int[]{x1 + x2, y1 + y2, t + 1});
                    }
                }
            }
            maxTime = Math.max(maxTime, t);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxTime == Integer.MIN_VALUE ? 0 : maxTime;
    }

    // flood fill algo
    public static void floodFillAlgo(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] u = q.poll();
            for (int[] dir : dirs) {
                int x1 = u[0];
                int y1 = u[1];
                int x2 = dir[0];
                int y2 = dir[1];

                if ((x1 + x2 < image.length && x1 + x2 > -1) && (y1 + y2 < image[0].length && y1 + y2 > -1)) {
                    if (!visited[x1 + x2][y1 + y2] && image[x1 + x2][y1 + y2] == color) {
                        visited[x1 + x2][y1 + y2] = true;
                        q.offer(new int[]{x1 + x2, y1 + y2});
                        image[x1 + x2][y1 + y2] = newColor;
                    }
                }
            }
        }
        for (int[] im : image) {
            for (int i : im) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }

    }

    // valid path
    public static void validPath(int n, int[][] edges, int source, int destination) {
        // make adjacency array
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                for (int j : adj[u]) {
                    if (!visited[j]) {
                        stack.push(j);
                    }
                }
            }
        }
        System.out.println(visited[destination]);
    }

    // find the second max value
    public static int secondMax(List<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max)
                secondMax = num;
        }
        return secondMax;
    }

    // move all zeros to the end
    public static List<Integer> moveZero(List<Integer> nums) {
        int j = 0; // for zero values
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != 0 && nums.get(j) == 0) {
                int temp = nums.get(i);
                nums.set(i, nums.get(j));
                nums.set(j, temp);
            }
            if (nums.get(j) != 0)
                j++;
        }
        return nums;
    }

    // next greater element
    public static List<Integer> nextGreater(List<Integer> nums) {
        List<Integer> res = new ArrayList<>(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.size() - 1; i > -1; i--) {
            if (!stack.empty()) {
                while (!stack.empty() && stack.peek() <= nums.get(i)) {
                    stack.pop();
                }
            }
            if (stack.empty()) {
                res.set(i, -1);
            } else {
                res.set(i, stack.peek());
            }
            stack.push(nums.get(i));
        }
        return res;
    }

    // valid parentheses
    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    // number of provinces
    // [
    // [1,1,0],
    // [1,1,0],
    // [0,0,1]
    // ]

    // [
    // [1,0,0,1],
    // [0,1,1,0],
    // [0,1,1,1],
    // [1,0,1,1]
    // ]

    public static void numberOfProvinces(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                stack.push(i);
                while (!stack.isEmpty()) {
                    int u = stack.pop();
                    if (!visited[u]) {
                        visited[u] = true;
                        for (int j = 0; j < isConnected[u].length; j++) {
                            if (isConnected[u][j] == 1 && !visited[j])
                                stack.push(j);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}

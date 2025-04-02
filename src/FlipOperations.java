import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipOperations {
    static List<Integer>[] tree;
    static int[] initial, expected;
    static List<Integer> flips;

    public static int getMinimumOperations(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo,
            List<Integer> initialList, List<Integer> expectedList) {
        // Convert List to Array for Faster Access
        initial = initialList.stream().mapToInt(Integer::intValue).toArray();
        expected = expectedList.stream().mapToInt(Integer::intValue).toArray();

        // Build Tree Adjacency List
        tree = new ArrayList[treeNodes];
        for (int i = 0; i < treeNodes; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < treeFrom.size(); i++) {
            int u = treeFrom.get(i); // Convert to 0-based index
            int v = treeTo.get(i); // Convert to 0-based index
            tree[u].add(v);
            tree[v].add(u);
        }

        flips = new ArrayList<>();

        // Start DFS from root (node 0), assuming it is the root
        dfs(0, -1, 0, 0);

        return flips.size();
    }

    static void dfs(int node, int parent, int flipEven, int flipOdd) {
        // Determine effective value after applying flips
        int effectiveValue = initial[node];
        if (flipEven % 2 == 1 && node % 2 == 0)
            effectiveValue ^= 1;
        if (flipOdd % 2 == 1 && node % 2 == 1)
            effectiveValue ^= 1;

        // If effective value does not match expected, flip
        int newFlipEven = flipEven, newFlipOdd = flipOdd;
        if (effectiveValue != expected[node]) {
            flips.add(node + 1); // Convert back to 1-based index
            if (node % 2 == 0)
                newFlipEven++;
            else
                newFlipOdd++;
        }

        // Recur for children
        for (int child : tree[node]) {
            if (child != parent) { // Avoid revisiting parent
                dfs(child, node, newFlipEven, newFlipOdd);
            }
        }
    }

    public static void main(String[] args) {
        // Sample Test
        int treeNodes = 5;
        List<Integer> treeFrom = Arrays.asList(1, 1, 2, 3);
        List<Integer> treeTo = Arrays.asList(2, 3, 4, 5);
        List<Integer> initial = Arrays.asList(1, 0, 1, 1, 0);
        List<Integer> expected = Arrays.asList(1, 1, 1, 0, 1);

        int result = getMinimumOperations(treeNodes, treeFrom, treeTo, initial, expected);
        System.out.println("Minimum flips: " + result);
    }
}

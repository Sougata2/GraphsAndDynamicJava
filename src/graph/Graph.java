package graph;


import java.util.*;

public class Graph {
    private LinkedList<Integer>[] adj;
    private int v; // number of vertices
    private int e; // number of edges

    public Graph(int nodes) {
        this.v = nodes;
        this.e = 0;
        this.adj = new LinkedList[nodes];
        for (int v = 0; v < this.v; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[v].add(u);
        adj[u].add(v);
        this.e++;
    }

    public String bfs(int s) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[this.v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            sb.append(u).append(" ");
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return sb.toString();
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[this.v];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.println(u + " ");
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public List<Integer> dfs() {
        boolean[] visited = new boolean[this.v];
        List<Integer> ls = new ArrayList<>();
        visited[0] = true;
        dfs(0, visited, adj, ls);
        return ls;
    }

    private void dfs(int node, boolean[] visited, LinkedList<Integer>[] adj, List<Integer> ls) {
        visited[node] = true;
        ls.add(node);
        for (int j : adj[node]) {
            System.out.println(j);
            if (!visited[j]) {
                dfs(j, visited, adj, ls);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.v).append(" vertices, ").append(this.e).append(" edges").append("\n");
        for (int v = 0; v < this.v; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}

import java.util.*;

public class CycleDetectionBFS {
    public static boolean hasCycle(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected graph
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(int start, boolean[] visited, List<List<Integer>> graph) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new int[]{start, -1}); // {node, parent}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], parent = current[1];

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // Found a back edge -> cycle
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V1 = 5;
        int[][] edges1 = {{0,1},{1,2},{2,3},{3,4},{4,0}};
        System.out.println(hasCycle(V1, edges1)); // true

        int V2 = 3;
        int[][] edges2 = {{0,1},{1,2}};
        System.out.println(hasCycle(V2, edges2)); // false

        int V3 = 4;
        int[][] edges3 = {{0,1},{1,2},{2,0}};
        System.out.println(hasCycle(V3, edges3)); // true
    }
}

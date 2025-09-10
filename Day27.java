import java.util.*;

public class ShortestPathUnweighted {
    public static List<Integer> shortestPath(int V, int[][] edges, int start, int end) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        // Step 2: BFS setup
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V]; // store parent for path reconstruction
        Arrays.fill(parent, -1);

        queue.add(start);
        visited[start] = true;

        // Step 3: BFS loop
        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end) {
                break; // reached destination
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node; // track parent
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Reconstruct path if reachable
        List<Integer> path = new ArrayList<>();
        if (!visited[end]) {
            return path; // empty list → no path found
        }

        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    // 🔎 Test cases
    public static void main(String[] args) {
        int[][] edges1 = {{0,1}, {0,2}, {1,3}, {2,3}, {3,4}};
        System.out.println(shortestPath(5, edges1, 0, 4)); // [0, 2, 3, 4]

        int[][] edges2 = {{0,1}, {1,2}};
        System.out.println(shortestPath(3, edges2, 0, 2)); // [0, 1, 2]

        int[][] edges3 = {{0,1}, {1,2}};
        System.out.println(shortestPath(4, edges3, 2, 3)); // []

        int[][] edges4 = {};
        System.out.println(shortestPath(1, edges4, 0, 0)); // [0]
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // if n is not a valid number
        if (n == 0) {
            return false;
        }

        // assigning each index to an arraylist as its value, basically like a hashmap
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // we are adding the neighbors and creating the undirected edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>(); // tracks all nodes we visited
        
        return dfs(0, -1, visit, adj) && visit.size() == n;
    }

    private boolean dfs(int node, int prev, Set<Integer> visit, List<List<Integer>> adj) {
        if (visit.contains(node)) {
            return false;
        }

        visit.add(node);
        for (int nei : adj.get(node)) {
            if (nei == prev) { // we skip to the next neighbor, prevent false positives
                continue;
            }

            if (!dfs(nei, node, visit, adj)) {
                return false;
            }
        }
        return true;
    }
}

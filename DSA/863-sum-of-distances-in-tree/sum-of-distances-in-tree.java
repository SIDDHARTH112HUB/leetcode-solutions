
class Solution {
    
    public Map<Integer, List<Integer>> buildTree(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // add u → v
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            // add v → u (to-and-fro relation)
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return adj;
    }

    public int getDFSTreeSum (Map<Integer, List<Integer>> adj, int parent, int node, int sum){
        int ans =sum;
        for (int child : adj.get(node)) {
            if (child != parent) { // avoid going back to parent
                ans+=getDFSTreeSum(adj, node, child,sum+1);
            }
        }

        return ans;
    }
    public int getTreeSum(int parent, Map<Integer, List<Integer>> adj) {
        int ans = 0;
        for (int child : adj.getOrDefault(parent, Collections.emptyList())) {
            ans += getDFSTreeSum(adj, parent, child, 1);
        }
        return ans;
    }
    public int[] sumOfDistancesInTree1(int n, int[][] edges) {
        Map<Integer, List<Integer>> tree = buildTree(edges);
        int []ans = new int [n];
        for(int i=0;i<n;i++){
            ans[i] = getTreeSum(i,tree);
        }
        return ans;
    }
    int[] res, count;
    List<List<Integer>> graph;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        res = new int[n];
        count = new int[n];

        // First DFS: returns subtree size and accumulates res[0]
        dfs(0, -1);

        // Second DFS: reroot to compute res[i] for all nodes
        finalDfs(0, -1);

        return res;
    }

    // dfs returns the size of the subtree rooted at 'node'
    private int dfs(int node, int parent) {
        int subtreeSize = 1; // count itself
        for (int child : graph.get(node)) {
            if (child == parent) continue;
            int childSize = dfs(child, node);
            subtreeSize += childSize;
            res[node] += res[child] + childSize;
        }
        count[node] = subtreeSize;
        return subtreeSize;
    }

    // finalDfs propagates the reroot formula
    private void finalDfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) continue;
            // reroot formula
            res[child] = res[node] - count[child] + (N - count[child]);
            finalDfs(child, node);
        }
    }
}
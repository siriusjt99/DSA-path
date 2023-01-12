class Solution {
    private int[] res;
    public int[] dfs(Map<Integer,List<Integer>> adjList, String label, int curr, boolean[] visited)
    {
        visited[curr] = true;
        int[] count = new int[26];
        for(int neighbour : adjList.get(curr)){
            if(!visited[neighbour])
            {
                int[] c = dfs(adjList,label,neighbour,visited);
                for(int i = 0; i<26; i++)
                    count[i] += c[i];
            }
        }
        count[label.charAt(curr) - 'a']++;
        res[curr] = count[label.charAt(curr) - 'a'];
        return count;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i<n; i++)
            adjList.put(i,new ArrayList<>());
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        res = new int[n];
        boolean[] visited = new boolean[n];
        dfs(adjList,labels,0,visited);
        return res;
    }
}
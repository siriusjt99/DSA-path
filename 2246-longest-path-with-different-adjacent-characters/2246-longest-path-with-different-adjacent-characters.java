class Solution {
    class R {
        char last;
        int count;
        int counthru;
        R(char l, int c, int ct){
            last = l;
            count = c;
            counthru = ct;
        }
        
        @Override
        public String toString(){
            return last + " " + count + " " + counthru;
        }
    }
    int[] visited;
    int MAX_NODE;
    HashMap<Integer, List<Integer>> tre;
    String str;
    int ret;
    
    public void pair(int a, int b){
        List<Integer> list = tre.getOrDefault(a, new ArrayList<>());
        list.add(b);
        tre.put(a, list);
    }
    
    R recurlong(int n){
        if(n > MAX_NODE) return new R('-', 0, 0);
        if(visited[n] == 1) return new R('-', 0, 0);
        visited[n] = 1;

        List<Integer> list = tre.getOrDefault(n, new ArrayList<>());
        R ans = new R(str.charAt(n), 1, 1);
        for(Integer ig : list){
            R next = recurlong(ig);
            
            if(next.last == str.charAt(n)){
                // Ignore this :)
            } else {
                ans.counthru = Math.max(ans.counthru, ans.count + next.count);
                ans.count = Math.max(ans.count, next.count+1);
                ret = Math.max(ret, Math.max(ans.counthru, ans.count));
            }
        }
        
        // System.out.println("At "+n+" val:"+ans);
        return ans;
    }
    
    public int longestPath(int[] parent, String s) {
        visited = new int[parent.length];
        MAX_NODE = parent.length;
        tre = new HashMap<>();
        str = s;
        
        for(int i=0; i<parent.length; i++){
            if(parent[i] == -1) continue;
            pair(i, parent[i]);
            pair(parent[i], i);
        }
        
        ret = 1;
       
        recurlong(0);
        
        return ret;
    }
    
    
}
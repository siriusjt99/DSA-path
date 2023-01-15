class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        List<Integer> l[]=new ArrayList[vals.length];
        int[] v=new int[vals.length];
        int[] parent=new int[vals.length];
        for(int i=0;i<vals.length;i++){
            parent[i]=i;
        }
        int ans=vals.length;
        TreeMap<Integer,List<Integer>> hm=new TreeMap<>();
       for(int i=0;i<vals.length;i++){
          l[i]=new ArrayList();
          List<Integer> k;
          k=hm.getOrDefault(vals[i],new ArrayList<Integer>());
          k.add(i);
          hm.put(vals[i],k);
       }
       for(int edge[]:edges){
          l[edge[0]].add(edge[1]);
          l[edge[1]].add(edge[0]);
        }

       // System.out.println(hm);

        for (Map.Entry<Integer,List<Integer>> entry: hm.entrySet()){
            List<Integer> k=entry.getValue();
            HashMap<Integer,Integer> h=new HashMap<>();
            
            for(int i=0;i<k.size();i++){
                int a=k.get(i);
                v[a]=1;
                
                for(int j=0;j<l[a].size();j++){
                    if(v[l[a].get(j)]==1)
                        union(a,l[a].get(j),parent);
                }
            }
            for(int i=0;i<k.size();i++){
                int a=k.get(i);
                int b=findpar(a,parent);
                h.put(b,h.getOrDefault(b,0)+1);
            }
            for(Map.Entry<Integer,Integer> e: h.entrySet()){
                     if(e.getValue()>1){
                        ans+=(e.getValue()*(e.getValue()-1))/2;
                    }
            }
        }
        return ans;  
    }

    public int findpar(int a,int[] parent){
        if(parent[a]==a)
            return a;
        return parent[a]=findpar(parent[a],parent);

    }

    public void union(int u,int v,int[] parent){
        int a=findpar(u,parent);
        int b=findpar(v,parent);
        if(a<b)
            parent[b]=parent[a];
        else
            parent[a]=parent[b];

    }
}
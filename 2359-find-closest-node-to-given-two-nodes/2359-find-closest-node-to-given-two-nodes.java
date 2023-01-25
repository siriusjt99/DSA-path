class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer,Integer> adjList=new HashMap<>();
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<edges.length;i++) adjList.put(i,edges[i]); 
        int c=0;
        int temp1=node1;
        while(temp1!=-1&&!map1.containsKey(temp1)){ 
          map1.put(temp1,c);
          c++;
          temp1=adjList.get(temp1);
        }
        int temp2=node2;
        c=0;
        while(temp2!=-1&&!map2.containsKey(temp2)){ 
          map2.put(temp2,c);
          c++;
          temp2=adjList.get(temp2);
        }
         for (Map.Entry<Integer,Integer> i : map1.entrySet()){       if(map2.containsKey(i.getKey())){
             if(Math.max(map1.get(i.getKey()),map2.get(i.getKey()))<=min){   
               if(min==Math.max(map1.get(i.getKey()),map2.get(i.getKey()))){ 
                   ans=Math.min(i.getKey(),ans);  
               }else{
                    ans=i.getKey();
               }
               min=Math.max(map1.get(i.getKey()),map2.get(i.getKey())); 
             }
            } 
        }
        return ans;
    }
}
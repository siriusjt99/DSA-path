class SummaryRanges {
    TreeMap<Integer, int[]>map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if (map.containsKey(value)) return ;
        Integer low = map.lowerKey(value);
        Integer high = map.higherKey(value);
        if(low !=null && high != null && map.get(low)[1]+1 == value && high == value+1){
            map.get(low)[1]= map.get(high)[1];
            map.remove(high);
        }
        else if(low != null && map.get(low)[1]+1>=value){
            map.get(low)[1] = Math.max(map.get(low)[1],value);
        }
        else if(high != null && high == value+1){
            map.put(value, new int[] {value, map.get(high)[1]});
            map.remove(high);
        }
        else{
            map.put(value, new int[] {value,value});
        }
    }
    
    public int[][] getIntervals() {
        int [][] res = new int[map.size()][2];
        int i=0;
        for(int [] m:map.values()){
            res[i++]=m;
        }
        return res;
    }
}
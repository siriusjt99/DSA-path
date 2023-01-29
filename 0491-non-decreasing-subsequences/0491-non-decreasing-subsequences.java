class Solution {
public void getSet(int[] nums,int idx,List<Integer>list,HashSet<List<Integer>>sets){
        if(idx==nums.length){
            if(list.size()>1) sets.add(list);
            return;
        }
        getSet(nums,idx+1,new ArrayList<Integer>(list),sets);
        if(list.size()==0 || list.get(list.size()-1)<=nums[idx])list.add(nums[idx]);
        getSet(nums,idx+1,new ArrayList<Integer>(list),sets);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer>list=new ArrayList<>();
        HashSet<List<Integer>>set=new HashSet<>();
        List<List<Integer>>sets= new ArrayList<>();
        getSet(nums,0,list,set);
        for(List l : set) sets.add(l);
        return sets;
    }
}

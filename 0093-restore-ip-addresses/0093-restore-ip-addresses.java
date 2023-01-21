class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ansList=new ArrayList<>();
        helper(s, 0, 0, "", ansList);
        return ansList;
    }

    public void helper(String s, int i, int par, String ans, List<String>resList){
        if(i==s.length() || par==4){
            if(s.length()==i && par==4){
                resList.add(ans.substring(0, ans.length()-1));
            }
            return;
        }

        helper(s, i+1, par+1, ans+s.charAt(i)+".", resList);
        if(i+2<=s.length() && isValid(s.substring(i, i+2))){
            helper(s, i+2, par+1, ans+s.substring(i, i+2)+".", resList);
        }
        if(i+3<=s.length() && isValid(s.substring(i, i+3))){
            helper(s, i+3, par+1, ans+s.substring(i, i+3)+".", resList);
        }
    }

    public boolean isValid(String s){
        if(s.charAt(0)=='0'){
            return false;
        }
        int val=Integer.parseInt(s);
        if(val<=255){
            return true;
        }
        return false;
    }
}
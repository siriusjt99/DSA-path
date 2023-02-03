class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        if(numRows == s.length()) return s;

        ArrayList<ArrayList<Character>> store = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {

            ArrayList<Character> temp = new ArrayList<>();
            store.add(temp);
        }

        String ans = "";
        int row = 0, vary = 0; 

        for(int i = 0; i < s.length(); i++) {

            store.get(row).add(s.charAt(i));
            if(vary%2 == 0) row++;
            else row--;

            if(row == -1) {
                vary++;
                row += 2;
            }

            if(row == numRows) {
                
                vary++;
                row -= 2;
            }

        }
        
        for(ArrayList<Character> c : store) {

            for(int i = 0; i < c.size(); i++) ans += c.get(i);
        }
        return ans;
    }
}
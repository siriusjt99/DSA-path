
class Solution {
    public int totalFruit(int[] fruits){
        int res = 0;  // variable to store the result
        int i = 0;  // variable to store the start index of the window
        int j = 0;  // variable to store the end index of the window
        int n = fruits.length;  // variable to store the length of the vector tree
        HashMap<Integer, Integer> m = new HashMap<>();  // unordered map to store the type of the fruit and the frequency of the fruit
        while(j < n){  // while the end index of the window is less than the length of the vector tree
            m.put(fruits[j], m.getOrDefault(fruits[j], 0) + 1);  // update the frequency of the fruit
            while(m.size() > 2){  // while the size of the unordered map is greater than 2
                m.put(fruits[i], m.get(fruits[i]) - 1);  // decrement the frequency of the fruit
                if(m.get(fruits[i]) == 0){  // if the frequency of the fruit is 0
                    m.remove(fruits[i]);  // erase the fruit from the unordered map
                }
                i++;  // increment the start index of the window
            }
            res = Math.max(res, j - i + 1);  // update the result
            j++;  // increment the end index of the window
        }
        return res;  // return the result
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distances = new int[n];
        int[] tempValues = new int[n];

        // see how to fill max value
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(tempValues, Integer.MAX_VALUE);

        distances[src] = 0;
        tempValues[src] = 0;

        for (int i = 0; i <= k; ++i) {
            for (int[] flight : flights) {
                if (distances[flight[0]] == Integer.MAX_VALUE) continue;

                if (distances[flight[0]] + flight[2] < tempValues[flight[1]]) {
                    tempValues[flight[1]] = distances[flight[0]] + flight[2];
                }
            }
            System.arraycopy(tempValues, 0, distances, 0, n);
        }
        return (distances[dst] == Integer.MAX_VALUE)?-1:distances[dst];
    }
}
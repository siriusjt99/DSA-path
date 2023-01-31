class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        int[][] values = new int[n][2];

        for (int i = 0; i < n; ++i) {
            values[i][0] = scores[i];
            values[i][1] = ages[i];
        }

        Arrays.sort(values, (a,b)-> a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);

        int[] dp = new int[n];

        int maxscore = 0;

        for (int i = 0; i < n; ++i) {
            dp[i] = values[i][0];
            for (int j = i-1; j>=0; --j) {
                if ((values[i][1]==values[j][1]) || (values[i][1] > values[j][1] && values[j][0] <= values[i][0])) {
                    dp[i] = Math.max(dp[i], dp[j]+values[i][0]);
                }
            }
            maxscore = Math.max(maxscore, dp[i]);
        }

        return maxscore;
    }
}
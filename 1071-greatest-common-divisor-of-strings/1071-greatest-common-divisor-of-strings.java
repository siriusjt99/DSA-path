class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        String baseString;
        if (str1.length() < str2.length()) {
            baseString = str1;
        } else {
            baseString = str2;
        }

        int lenOfBaseString = gcd(str1.length(), str2.length());

        return baseString.substring(0, lenOfBaseString);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }

}

class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // odd
            String odd = expand(s, i, i);
            if (odd.length() > result.length()) result = odd;
            // even
            String even = expand(s, i, i + 1);
            if (even.length() > result.length()) result = even;
        }
        return result;
    }

    private String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l + 1, r);
    }
}

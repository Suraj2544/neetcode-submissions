class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left=0;
        int maxfreq=0;
        int maxlength=0;
        int n=s.length();
        for(int right=0;right<n;right++){
            int index=s.charAt(right)-'A';
            freq[index]++;
            maxfreq=Math.max(freq[index],maxfreq);

            while((right-left+1)-maxfreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}

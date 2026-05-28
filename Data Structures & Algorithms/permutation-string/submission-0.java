class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int n=s1.length();
       int[] s1Count =new int [26];
       int[] windowCount =new int[26];

       for(char ch : s1.toCharArray()){
        s1Count[ch -'a']++;
       } 

       int left=0;
       for(int right=0;right<s2.length();right++){
        windowCount[s2.charAt(right) - 'a']++;
        if(right-left+1 > n) {
            windowCount[s2.charAt(left) - 'a']--;
            left++;
        }
        if(Arrays.equals(s1Count,windowCount)){
            return true;
        }
       }
        return false;
    }
}

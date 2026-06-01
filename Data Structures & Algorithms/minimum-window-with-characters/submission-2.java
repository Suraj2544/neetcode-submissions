class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        int[] tMap =new int[128];
        int[] sMap =new int[128];

        for(char ch : t.toCharArray()){
            tMap[ch]++;
        }

        int left=0;
        int minStart=0;
        int minLen=Integer.MAX_VALUE;
        for(int right=0;right <s.length();right++){
            char rightVal=s.charAt(right);
            sMap[rightVal]++;

            while(areEqual(tMap,sMap)){
                if(right-left+1 < minLen){
                    minLen=right-left+1;
                    minStart=left;
                }
                char leftVal=s.charAt(left);
                sMap[leftVal]--;
                left++;
            }
        }
         if(minLen==Integer.MAX_VALUE){
                return "";
            }
            return s.substring(minStart,minStart+minLen);
    }

    private boolean areEqual(int[] tMap,int[] sMap){
        for(int i=0;i<128;i++){
            if(tMap[i] > sMap[i]){
            return false;}
        }
        return true;
    }
}

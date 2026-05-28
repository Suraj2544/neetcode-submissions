class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] mapT=new int[128];
        int[] mapS=new int[128];

        for(char ch : t.toCharArray()){
        mapT[ch]++;
        }

        int left=0;
        int minstart=0;
        int minlen=Integer.MAX_VALUE;

        for(int right=0;right<s.length();right++){
            char rightChar =s.charAt(right);
            mapS[rightChar]++;

            while(areEqual(mapT,mapS)){
                if(right-left+1 < minlen){
                    minlen=right-left+1;
                    minstart=left;
                }
                char leftChar=s.charAt(left);
                mapS[leftChar]--;
                left++;
            }
        }
        if(minlen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minstart,minstart+minlen);
    }
    private boolean areEqual(int[] mapT,int[] mapS){
        for(int i=0;i<128;i++){
            if(mapT[i] > mapS[i]){
                return false;
            }
        }
        return true;
    }
}

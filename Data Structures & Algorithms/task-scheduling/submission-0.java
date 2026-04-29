class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] -'A']++;
        }

        int Maxval=0;
        for(int f : freq){
            Maxval=Math.max(Maxval,f);
        }

        int MaxCount=0;
        for(int f:freq){
            if(f==Maxval){
                MaxCount++;
            }
        }

        int slots=(Maxval-1) *(n+1) + MaxCount;
        return Math.max(slots,tasks.length);
    }
}

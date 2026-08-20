class Solution {
    public int tribonacci(int n) {
        if(n==0 ){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int[] val=new int[n+1];
        val[0]=0;
        val[1]=1;
        val[2]=1;
        for(int i=3;i<=n;i++){
            val[i]=val[i-1]+val[i-2]+val[i-3];
        }
        return val[n];
    }
}
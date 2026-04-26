class Solution {
    public int maxProfit(int[] prices) {
        int current=0;
        int min=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<prices.length;i++){
            current=prices[i];
            min=Math.min(current,min);
            result=Math.max(result,current-min);
        }
        return result;
    }
}

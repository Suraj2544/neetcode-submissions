class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minval=0;
        int maxval=0;
        for(int weight : weights){
            minval=Math.max(minval,weight);
            maxval += weight;
        }
        while(minval < maxval){
            int mid=minval+(maxval-minval)/2;
            if(canLoad(weights,days,mid)){
                maxval=mid;
            }
            else{
                minval=mid+1;
            }
        }
        return minval;
    }
    private boolean canLoad(int[] weights, int days,int capacity){
        int daysNeeded=1;
        int currentLoad=0;
        for(int weight :weights){
            if(currentLoad+weight > capacity){
                daysNeeded++;
                currentLoad=0;
            }
            currentLoad += weight;
        }
        return daysNeeded <= days;
    }
}
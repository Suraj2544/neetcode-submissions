class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minval=0;
        int maxval=0;
        for(int weight : weights){
            minval =Math.max(minval,weight);
            maxval += weight;
        }
        while(minval < maxval){
            int mid =minval + (maxval-minval)/2;
            if(canload(weights,days,mid)){
                maxval=mid;
            }
            else {
                minval=mid+1;
            }
        }
        return minval;
        
    }
    private boolean canload(int[] weights, int days,int capacity){
        int daysneeded=1;
        int currentload=0;
        for(int weight : weights){
            if(currentload+weight > capacity){
                daysneeded++;
                currentload=0;
            }
            currentload +=weight;
        }
        return daysneeded <= days;
    }
}
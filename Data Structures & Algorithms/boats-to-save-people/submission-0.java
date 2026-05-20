class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int boat=0;
        int left=0;
        int right=n-1;
        while(left <= right){
            if(people[left]+people[right] <= limit){
                left++;
            }
            right--;
            boat++;
        }
        return boat;
    }
}
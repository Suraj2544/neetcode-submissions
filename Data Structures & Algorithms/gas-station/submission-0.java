class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        int costSum=0;
        for(int g : gas){
            gasSum += g;
        }
        for(int c : cost){
            costSum += c;
        }
        if(costSum > gasSum){
            return -1;
        }

        int tank=0;
        int start=0;
        for(int i=0;i< gas.length;i++){
            tank += gas[i] - cost[i];

            if(tank < 0){
                tank=0;
                start = i +1;
            }

        }
        return start;
        
    }
}

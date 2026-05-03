class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List <Integer>>result =new ArrayList <>();
        backtrack(0,candidates,target,new ArrayList <>(),result);
        return result;
    }
    private void backtrack(int start,int[] candidates, int remaining,List<Integer> current,List<List <Integer>> result){
        if(remaining ==0){
            result.add(new ArrayList <>(current));
            return;
        }
        if(remaining < 0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i > start && candidates[i]==candidates[i-1]) continue;
            current.add(candidates[i]);
            backtrack(i+1,candidates,remaining - candidates[i],current,result);
            current.remove(current.size()-1);
        }
    }
}

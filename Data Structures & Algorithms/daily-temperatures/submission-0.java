class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack <Integer> stack=new Stack <>();
        int [] result=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int previndex=stack.pop();
                result[previndex]=i-previndex;
            }
            stack.push(i);
        }
        return result;

    }
}

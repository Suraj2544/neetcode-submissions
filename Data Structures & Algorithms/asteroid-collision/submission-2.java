class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            }
            else {

                while (!stack.isEmpty()) {

                    int top = stack.peek();

                    if (top < 0) {
                        stack.push(asteroid);
                        break;
                    }

                    int modval = Math.abs(asteroid);

                    if (modval == top) {
                        stack.pop();
                        break;
                    }
                    else if (modval < top) {
                        break;
                    }
                    else {

                        stack.pop();

                        if (stack.isEmpty()) {
                            stack.push(asteroid);
                            break;
                        }
                    }
                }
            }
        }

        int len = stack.size();
        int[] result = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
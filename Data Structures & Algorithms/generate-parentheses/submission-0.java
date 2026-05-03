class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int open, int close, int n, StringBuilder current, List<String> result) {
        if (current.length() == n * 2) {
            result.add(current.toString());            // complete combination found
            return;
        }

        if (open < n) {
            current.append('(');                       // choose open
            backtrack(open + 1, close, n, current, result);
            current.deleteCharAt(current.length() - 1); // undo
        }

        if (close < open) {
            current.append(')');                       // choose close
            backtrack(open, close + 1, n, current, result);
            current.deleteCharAt(current.length() - 1); // undo
        }
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);  // O(1) lookup
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        q.offer(null);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);                             // ✅ capital W

        int level = 1;

        while (!q.isEmpty()) {
            String word = q.poll();

            if (word == null) {                             // ✅ actual null check
                level++;
                if (!q.isEmpty()) q.add(null);
                continue;
            }

            if (word.equals(endWord)) return level;

            for (int i = 0; i < word.length(); i++) {      // ✅ length()
                char[] chars = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {     // ✅ ch++
                    chars[i] = ch;
                    String nextWord = new String(chars);    // ✅ inside inner loop

                    if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                        visited.add(nextWord);
                        q.offer(nextWord);
                    }
                }
            }
        }
        return 0;
    }
}
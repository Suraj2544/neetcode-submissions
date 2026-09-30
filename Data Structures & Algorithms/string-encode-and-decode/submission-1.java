class Solution {

    public String encode(List<String> strs) {
        StringBuilder s =new StringBuilder ();
        for(String word :strs){
            s.append(word.length()).append('#').append(word);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // find delimiter '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            j++; // move past '#'

            String word = str.substring(j, j + length);
            res.add(word);

            i = j + length; // move to next encoded part
        }

        return res;
    }
}

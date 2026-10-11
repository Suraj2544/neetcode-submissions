class Solution {

    public String encode(List<String> strs) {
        StringBuilder s=new StringBuilder ();
        for(String word: strs){
            s.append(word.length()).append('#').append(word);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        ArrayList <String> result =new ArrayList <>();
        int i=0;
        while(i < str.length()){
           int j=i;
           while(str.charAt(j) != '#'){
            j++;
           }
           int length= Integer.parseInt(str.substring(i,j));
           j++;
           String word=str.substring(j,j+length);
           result.add(word);
           i=j+length;
        }
        return result;
    }
}

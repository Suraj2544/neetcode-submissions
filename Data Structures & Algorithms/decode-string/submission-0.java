class Solution {
    public String decodeString(String s) {
        Stack <Integer> counterStack =new Stack <>();
        Stack <StringBuilder> stringStack =new Stack <>();

        StringBuilder currentString =new StringBuilder ();
        int currentCounter=0;

        for(char ch :s.toCharArray()){
            if(Character.isDigit(ch)){
                currentCounter = currentCounter * 10 + (ch - '0');
            }
            else if(ch == '['){
                counterStack.push(currentCounter);
                stringStack.push(currentString);

                currentCounter=0;
                currentString =new StringBuilder();
            }
            else if(ch==']'){
                int prevCounter=counterStack.pop();
                StringBuilder prevString=stringStack.pop();
                for(int i=0;i<prevCounter;i++){
                    prevString.append(currentString);
                }
                currentString=prevString;
            }
            else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}
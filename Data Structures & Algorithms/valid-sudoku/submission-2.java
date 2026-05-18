class Solution {
    public boolean isValidSudoku(char[][] board) {
       int m= board.length;
       int n=board[0].length;
        HashSet <String> set=new HashSet <>();
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            char ch=board[i][j];
            if(ch =='.') continue;
            String row="ROW"+i+ch;
            String col="COL"+j+ch;
            String box="BOX"+i/3+j/3+ch;

            if(!set.add(row) || !set.add(col) || !set.add(box)){
                return false;
            }
        }
       } 
       return true;
    }
}

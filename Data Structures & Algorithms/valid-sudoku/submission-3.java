class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        HashSet <String> set =new HashSet <>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch=board[i][j];
                if(ch =='.') continue;
                String row ="ROW" + i + board[i][j];
                String col="COL" +j + board[i][j];
                String box="BOX" +i/3+j/3+board[i][j];

                if(!set.add(row) || !set.add(col) || !set.add(box)){
                    return false;
                }

            }
        }
        return true;
        
    }
}

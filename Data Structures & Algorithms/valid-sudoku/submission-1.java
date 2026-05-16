class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet <String> set=new HashSet <>();
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c=board[i][j];
                if (c =='.') continue;

                String row="ROW" + i + c;
                String col="COLUMN" + j + c;
                String box="BOX"+ i/3 + j/3 + c;

                if(!set.add(row) || !set.add(col) || !set.add(box)){
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               if( backtrack(board,word,0,i,j,visited)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word,int index,int i,int j,boolean[][] visited){
         int row=board.length;
        int col=board[0].length;
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i>= row || j >=col){
            return false;
        }
        if(board [i] [j] != word.charAt(index)){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        visited[i][j]=true;

        boolean found= backtrack(board,word,index+1,i+1,j,visited) ||backtrack(board,word,index+1,i-1,j,visited) ||backtrack(board,word,index+1,i,j+1,visited) ||backtrack(board,word,index+1,i,j-1,visited);

        visited[i][j]=false;
        return found;
    }
}

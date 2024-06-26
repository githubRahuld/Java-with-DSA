public class NQueen1Sol {

    public static boolean isSafe(char board[][],int row,int col) {
        //vertically up
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //left daigonal up
        for(int i = row-1,j=col-1;i>=0 && j>=0 ;i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //right diagonal up
        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static boolean nQueen(char board[][],int row) {

        if(row == board.length){
            return true;
        }
        
        for(int j = 0; j < board.length; j++){
            if(isSafe(board,row, j)){
                board[row][j] = 'Q';

                if(nQueen(board, row+1)){ //check for next row
                    return true;
                }
                board[row][j] = 'x'; //backtrack step
            }
        }

        return false ; //if no soln found

    }


    public static void print(char board[][]) {
        
        System.out.println("----N Queen's Board---- ");

        for(int i = 0 ;i<board.length;i++){
            for(int j = 0 ;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 2;

        char board[][] = new char[n][n];

        //initialise empty board
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ;j<n;j++){
                board[i][j] = 'x';
            }
        }

        int row = 0;
        if(nQueen(board,row) == true){
            print(board);
        }else{
            System.out.println("No solution found!");
        }

    }    
}

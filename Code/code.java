package Code;

public class code {
   //###########################################################################
   static char[][] board = {
    {'.', '3', '4', '5', '7', '8', '9', '1', '2'},
    {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
    {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
    {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
    {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
    {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
    {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
    {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
    {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
};
public static void solveSudoku(char[][] board) {
    solve(board);
}
public static boolean solve(char[][]board){
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){

            if(board[i][j]=='.'){

                for(char num='1';num<='9';num++){
                    if(isPossible(board,i,j,num)){
                        board[i][j]=num;
                        if(solve(board)){
                            return true;
                        }
                        //if the solve function return false then the prev num must be in wrong pos so then backtrack
                        //and fill that with '.'. 
                        else{
                            board[i][j]='.';
                        }
                    }
                }

                //if it is not possible to select a number from 1 to 9 the solve function return false;
                return false;
            }
        }
    }
    return true;
}

    

    public static boolean isPossible(char[][]board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c) return false;//col check

            if(board[row][i]==c) return false; //row check

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;//checking in each 3 x 3 matrix
        }
        return true;

    }

    public static void main(String[] args){
       
        solveSudoku(board);
       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print( board[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}

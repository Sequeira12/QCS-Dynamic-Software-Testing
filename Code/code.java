package Code;

public class code {
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
        solve(board,0);
    }
    public static boolean solve(char[][]board,int level){
        if(level==0) System.out.print("  2");
        for(int i=0;i<9;i++){
            
            if(level==0) System.out.print( "  3");
            if(level==0) System.out.print( "  4");
            if(level==0) System.out.print( "  5");
            for(int j=0;j<9;j++){
                if(level==0 && j > 0) System.out.print( "  5");
                if(level==0) System.out.print( "  7");
                if(board[i][j]=='.'){
                    if(level==0) System.out.print( "  9");
                    if(level==0) System.out.print( "  11");
                        
                    for(char num='1';num<='9';num++){
                        
                        if(level==0 && num!='1') System.out.print( "  11");
                        if(level==0) System.out.print( "  14");
                        if(isPossible(board,i,j,num)){
                            
                           
                            if(level==0) System.out.print( "  15");
                            board[i][j]=num;
                            
                            if(level==0)  System.out.print( "  16");
                            if(solve(board,level++)){
                                
                                if(level==0)  System.out.print( "  17");
                                if(level==0)  System.out.print( "  19");
                                return true;
                            }
                            //if the solve function return false then the prev num must be in wrong pos so then backtrack
                            //and fill that wibth '.'. 
                            else{
                                
                                if(level==0) System.out.print( "  18");
                                board[i][j]='.';
                            }
                        }
                        
                        if(level==0)  System.out.print( "  13");
                    }

                    
                    if(level==0)  System.out.print( "  12");
                    if(level==0)  System.out.print( "  19");
                    //if it is not possible to select a number from 1 to 9 the solve function return false;
                    return false;
                }
                if(level==0) System.out.print( "  10");

            }
            
            if(level==0) System.out.print( "  6");
        }
        
        if(level==0)   System.out.print( "  8");
        if(level==0)   System.out.print( "  19");
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
        System.out.print( "  1");
        solveSudoku(board);
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print( board[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}

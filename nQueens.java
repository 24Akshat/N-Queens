import java.util.ArrayList;
import java.util.List;

public class nQueens {
    public static void saveBoard(char[][] board, List<List<String>> allBoards){
        String row = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            row="";
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='Q'){
                    row+='Q';
                }else{
                    row+='.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
        return;
    }
    public static boolean isSafe(char[][] board, int row, int col) {
        // vertically
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // horizontally
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = col + 1; i < board.length; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // upper right
        int r = row;
        for (int i = col; i < board.length && r >= 0; r--, i++) {
            if (board[r][i] == 'Q') {
                return false;
            }
        }

        // upper left
        r = row;
        for (int i = col; i >= 0 && r >= 0; r--, i--) {
            if (board[r][i] == 'Q') {
                return false;
            }
        }

        // lower right
        r = row;
        for (int i = col; i < board.length && r < board.length; r++, i++) {
            if (board[r][i] == 'Q') {
                return false;
            }
        }

        // lower left
        r = row;
        for (int i = col; i >= 0 && r < board.length; r++, i--) {
            if (board[r][i] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void solver(char[][] board, List<List<String>> allBoards, int col) {
        if(col==board.length){
            saveBoard(board,allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solver(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> creatingBoard(int n) {
        char[][] board = new char[n][n];
        List<List<String>> allBoards = new ArrayList<>();
        solver(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String args[]) {
        List<List<String>> allBoards = creatingBoard(4);
        for(int i=0;i<allBoards.size();i++){
            List<String> element = allBoards.get(i);
            System.out.println("Solution :");
            for(int j=0; j<element.size();j++){
                System.out.println(element.get(j));
            }
            System.out.println();
        }
    }
}
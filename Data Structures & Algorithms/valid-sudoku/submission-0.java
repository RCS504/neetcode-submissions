class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] != '.') {
                    if (rows[row].contains(board[row][column])) {
                        return false;
                    } else {
                        rows[row].add(board[row][column]);
                    }
                    if (columns[column].contains(board[row][column])) {
                        return false;
                    } else {
                        columns[column].add(board[row][column]);
                    }
                    if (boxes[3 * (row / 3) + (column / 3)].contains(board[row][column])) {
                        return false;
                    } else {
                        boxes[3 * (row / 3) + (column / 3)].add(board[row][column]);
                    }
                }
            }
        }
        return true;
    }
}

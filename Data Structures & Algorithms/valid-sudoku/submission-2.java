class Solution {
    public boolean isValidSudoku(char[][] board) {
                var row = new HashSet<Character>();
        var col = new HashSet<Character>();
        var box = new HashMap<String, HashSet<Character>>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                var key = (i/3)+","+(j/3);
                if (board[i][j] != '.' ) {
                    if (box.computeIfAbsent(key, k -> new HashSet<>()).contains(board[i][j])) {
                        return false;
                    }
                    box.get(key).add(board[i][j]);
                }
            }
            row.clear();
            col.clear();
        }
        return true;
    }
}

public class GameLogic {
    int[][] occupiedSpaces = new int[4][4];

    
    public void updateSpace(int row, int col, int value) {
        occupiedSpaces[row][col] = value;
    }
    
    
    public boolean playerLoses() {
        for (int[] row: occupiedSpaces) {
            for (int piece: row) {
                if (piece == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean playerWin() {
        for (int[] row: occupiedSpaces) {
            for (int piece: row) {
                if (piece == 2048) {
                    return true;
                }
            }
        }
        return false;
    }


}


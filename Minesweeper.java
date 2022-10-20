public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] board = new String[m][n];
        String MINE = "*";

        // Mines Random Spread
        for (int i = 0; i < k;) {
            int rm = (int) (Math.random() * m);
            int rn = (int) (Math.random() * n);
            if (board[rm][rn] == null) {
                board[rm][rn] = MINE;
                i++;
            }
        }

        // putting the numbers between the mines
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int counter = 0;
                if (board[i][j].equals(MINE)) {  //board[i][j].equals(MINE) - in Strings you CAN'T do board[i][j] == MINE
                    System.out.print(MINE + "  ");
                } else {
                    if (i != 0 && board[i - 1][j].equals(MINE)) {
                        counter++;
                    }
                    if (i != 0 && j != n-1 && board[i - 1][j + 1].equals(MINE)) {
                        counter++;
                    }
                    if (j != n-1 && board[i][j + 1].equals(MINE)) {
                        counter++;
                    }
                    if (i != m-1 && j != n-1 && board[i + 1][j + 1].equals(MINE)) {
                        counter++;
                    }
                    if (i != m-1 && board[i + 1][j].equals(MINE)) {
                        counter++;
                    }
                    if (i != m-1 && j != 0 && board[i + 1][j - 1].equals(MINE)) {
                        counter++;
                    }
                    if (j != 0 && board[i][j - 1].equals(MINE)) {
                        counter++;
                    }
                    if (i != 0 && j != 0 && board[i - 1][j - 1].equals(MINE)) {
                        counter++;
                    }
                    System.out.print(counter + "  ");
                }
            }
            System.out.println();
        }
    }
}

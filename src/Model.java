public class Model{
    private int[][] board; // ボード上の駒情報を管理(０：駒なし、１：黒、２：白)
    private boolean[][] whitePositionable; // 白い駒が置ける場所を管理
    private boolean[][] blackPositionable; // 黒い駒が置ける場所を管理
    private double timelimit; // 制限時間を管理
    private int countWhite; // 白駒の数を管理
    private int countBlack; // 黒駒の数を管理


    /* getter */
    // ボード全体の情報を取得
    public int[][] getBoard(){
        return board;
    }

    // ボードの情報を場所を指定して取得
    public int getBoard(int line, int row){
        return board[line][row];
    }

    // 白駒が置ける場所の情報を取得
    public boolean[][] getWhitePositionable(){
        return whitePositionable;
    }

    // 白駒の置けるかを場所を指定して取得
    public boolean getWhitePositionable(int line, int row){
        return whitePositionable[line][row];
    }

    // 黒駒が置ける場所の情報を取得
    public boolean[][] getBlackPositionable(){
        return blackPositionable;
    }

    // 黒駒の置けるかを場所を指定して取得
    public boolean getBlackPositionable(int line, int row){
        return blackPositionable[line][row];
    }

    // 白駒の数を取得
    public int getCountWhite(){
        return countWhite;
    }

    // 黒駒の数を取得
    public int getCountBlack(){
        return countBlack;
    }

    // 制限時間を取得
    public double getTimeLimit(){
        return timelimit;
    }


    /* setter */
    // ボード全体の情報を変更
    public void setBoard(int[][] board){
        this.board = board;
    }

    // ボードの情報を場所を指定して変更
    public void setBoard(int line, int row, int info){
        board[line][row] = info;
    }

    // 白駒が置ける場所の情報を変更
    public void setWhitePositionable(boolean[][] whitePositionable){
        this.whitePositionable = whitePositionable;
    }

    // 白駒の置けるかを場所を指定して変更
    public void setWhitePositionable(int line, int row, boolean info){
        whitePositionable[line][row] = info;
    }

    // 黒駒が置ける場所の情報を変更
    public void setBlackPositionable(boolean[][] blackPositionable){
        this.blackPositionable = blackPositionable;
    }

    // 黒駒の置けるかを場所を指定して変更
    public void setBlackPositionable(int line, int row, boolean info){
        blackPositionable[line][row] = info;
    }

    // 白駒の数を変更
    public void setCountWhite(int count){
        countWhite = count;
    }

    // 黒駒の数を変更
    public void setCountBlack(int count){
        countBlack = count;
    }

    // 制限時間を変更
    public void setTimeLimit(double timelimit){
        this.timelimit = timelimit;
    }
}
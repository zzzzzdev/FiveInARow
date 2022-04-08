/**
 * 封装对上下左右斜线位置相同类型棋子数量的数数
 */
public class CountPiece {

    public static int countNumber_left(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_left(chessboard,x, y - 1, piece);
        return number + 1;
    }

    public static int countNumber_right(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_right(chessboard,x, y + 1, piece);
        return number + 1;
    }

    public static int countNumber_up(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_up(chessboard,x - 1, y, piece);
        return number + 1;
    }

    public static int countNumber_down(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_down(chessboard,x + 1, y, piece);
        return number + 1;
    }

    public static int countNumber_leftup(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_leftup(chessboard,x - 1, y - 1, piece);
        return number + 1;
    }

    public static int countNumber_leftdown(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_leftdown(chessboard,x - 1, y + 1, piece);
        return number + 1;
    }

    public static int countNumber_rightdown(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_rightdown(chessboard,x + 1, y + 1, piece);
        return number + 1;
    }

    public static int countNumber_rightup(ChessBoard chessboard,int x, int y, Piece piece) {
        if (x < 0 || x >= ChessBoard.DEFAULTWIDTH || y < 0 || y >= ChessBoard.DEFAULTHEIGTH || chessboard.getBoardstate()[x][y] != piece.getType()) {
            return 0;
        }
        int number = countNumber_rightup(chessboard,x + 1, y - 1, piece);
        return number + 1;
    }
}

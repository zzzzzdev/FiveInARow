import java.awt.*;

public class ChessBoard {
    public static final int DEFAULTWIDTH = 18;
    public static final int DEFAULTHEIGTH = 18;
    //用于存储当前棋局的状态
    private int[][] boardstate;
    //记录当前棋局有效棋子的数量
    public int piecenumber = 0;

    /**
     * 构造器
     */
    public ChessBoard(){
        boardstate = new int[DEFAULTWIDTH][];
        for (int i = 0;i < DEFAULTWIDTH ;i ++){
            boardstate[i] = new int[DEFAULTHEIGTH];
        }
    }

    public int[][] getBoardstate() {
        return boardstate;
    }

    /**
     * 玩家在指定的位置进行下棋
     * @param x 横坐标
     * @param y 纵坐标
     * @param player 玩家
     */
    public void bePlayed(int x,int y,Player player){
        boardstate[x][y] = player.getPiecetype();
        //每次都调用一次之后将棋子数量自增
        piecenumber ++;
    }

    /**
     * 绘画当前棋盘的网格线
     * @param g 绘图对象
     */
    public void paintLines(Graphics g){
        for(int i = 0; i <= ChessBoard.DEFAULTHEIGTH ;i ++){
            g.drawLine(i * Piece.DEFAULTSIZE,0,i * Piece.DEFAULTSIZE,ChessBoard.DEFAULTWIDTH * Piece.DEFAULTSIZE);
        }
        for(int i = 0; i <= ChessBoard.DEFAULTHEIGTH ;i ++){
            g.drawLine(0,i * Piece.DEFAULTSIZE,ChessBoard.DEFAULTWIDTH * Piece.DEFAULTSIZE,i * Piece.DEFAULTSIZE);
        }
        //这里是绘画棋盘上预先存在的九个点
        g.fillArc(2 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,2 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(8 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,2 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(14 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,2 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(2 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,8 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(2 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,14 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(8 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,8 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(8 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,14 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(14 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,14 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
        g.fillArc(14 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,8 * Piece.DEFAULTSIZE + 3 * Piece.DEFAULTSIZE / 4,Piece.DEFAULTSIZE / 2,Piece.DEFAULTSIZE / 2 ,0,360);
    }

    /**
     * 对棋盘中已经存在的棋子进行绘画
     * @param g 绘图对象
     */
    public void paintPiece(Graphics g){
        //遍历数组将已经下过的棋子进行绘画。
        for (int i = 0 ;i < DEFAULTWIDTH;i ++){
            for (int j = 0 ; j < DEFAULTHEIGTH ; j++){
                if(boardstate[i][j] == Piece.BLACK){
                    g.setColor(Color.BLACK);
                    new Piece(boardstate[i][j]).paint(i,j,g);
                }
                else if (boardstate[i][j] == Piece.WHITE){
                    g.setColor(Color.WHITE);
                    new Piece(boardstate[i][j]).paint(i,j,g);
                }
            }
        }
    }
}

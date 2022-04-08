import java.awt.*;

public class Piece {
    public static final int DEFAULTSIZE = 40;
    public static final int BLACK = -1;
    public static final int WHITE= 1;
    private int type;

    /**
     * 构造器，构造一颗棋子，但缺少位置信息
     * @param type 棋子的类型（白棋、黑棋）
     */
    public Piece(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 在指定位置绘画棋子，因为棋子对象本身没有位置信息。
     * @param x 横坐标
     * @param y 纵坐标
     * @param g 绘图对象
     */
    public void paint(int x,int y,Graphics g){
        //绘画圆形棋子
        g.fillArc(x * DEFAULTSIZE + Piece.DEFAULTSIZE / 2,y * DEFAULTSIZE + Piece.DEFAULTSIZE / 2,DEFAULTSIZE,DEFAULTSIZE,0,360);
        //绘画矩形棋子
        //g.fillRect(x * DEFAULTSIZE + Piece.DEFAULTSIZE / 2 ,y * DEFAULTSIZE + Piece.DEFAULTSIZE / 2,DEFAULTSIZE,DEFAULTSIZE);
    }
}

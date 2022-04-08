import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowStage extends JPanel {
    private Player player;
    private Piece blackpiece;
    private Piece whitepiece;
    private ChessBoard chessboard;
    private MouseControl mouselistner;
    //初始默认1号玩家先下棋
    public static int currentplayer = -1;
    //初始默认游戏状态为进行中
    public static boolean gamestatus = false;


    /**
     * 构造器
     */
    public WindowStage(){
        //设置Jpanel的大小
        setPreferredSize(new Dimension(ChessBoard.DEFAULTWIDTH * Piece.DEFAULTSIZE, ChessBoard.DEFAULTHEIGTH * Piece.DEFAULTSIZE));
        /*
        重构之后将两者玩家进行融合，两者玩家的区别仅在于下棋棋子不同
        棋子类型可以根据currentplayer与当前棋盘棋子数量进行计算
        */
        player = new Player(Piece.BLACK);

        //创造可以进行游戏的棋子
        blackpiece = new Piece(Piece.BLACK);
        whitepiece = new Piece(Piece.WHITE);

        //创造进行游戏的棋盘
        chessboard = new ChessBoard();

        //创造接受鼠标事件的监听器
        mouselistner = new MouseControl();
    }

    public MouseControl getMouselistner() {
        return mouselistner;
    }

    /**
     * 从四个数中选出最大的数
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public int pickMax(int a,int b,int c,int d){
        int maxnumber = 0;
        if (maxnumber < a){
            maxnumber = a;
        }
        if(maxnumber < b){
            maxnumber = b;
        }
        if(maxnumber < c){
            maxnumber = c;
        }
        if(maxnumber < d){
            maxnumber = d;
        }
        return maxnumber;
    }

    /**
     * 检测算法，用于检测游戏是否结束
     * @param x 当前下棋横坐标
     * @param y 当前下棋纵坐标
     * @param piece 当前下棋的棋子
     * @return
     */
    public boolean detect(int x,int y,Piece piece){
        //下面分别检测各个方向的最大同线棋子数量
        //减1的目的在于，当前x，y位置的棋子重复计算了
        int up_down = CountPiece.countNumber_up(chessboard,x,y,piece) + CountPiece.countNumber_down(chessboard,x,y,piece) - 1;
        int left_right = CountPiece.countNumber_left(chessboard,x,y,piece) + CountPiece.countNumber_right(chessboard,x,y,piece) - 1;
        int leftup_rightdown = CountPiece.countNumber_leftup(chessboard,x,y,piece) + CountPiece.countNumber_rightdown(chessboard,x,y,piece) - 1;
        int leftdown_rightup = CountPiece.countNumber_leftdown(chessboard,x,y,piece) + CountPiece.countNumber_rightup(chessboard,x,y,piece) - 1;
        //四个数中找最大的数，直接手写冒泡排序
        if(pickMax(up_down, left_right,leftup_rightdown,leftdown_rightup) < 5){
            return false;
        }
        return true;
    }

    /**
     * 获取当前鼠标点击的位置，转化成JFrame窗口的相对位置信息
     * @param absolutePosition 绝对位置point对象
     * @return 相对位置point对象
     */
    public Point clickPosition(Point absolutePosition){
        //
        int x = (int)absolutePosition.getX() - 300;
        int y = (int)absolutePosition.getY() - 8;
        //之所以要-4，-3是因为debug之后得到的坐标偏差。
        return new Point(x / Piece.DEFAULTSIZE,y / Piece.DEFAULTSIZE);
    }

    /**
     * 内部类，重写MouseDapter的mouseClicked方法
     */
    private class MouseControl extends MouseAdapter{
        //重写鼠标点击释放之后的方法，由鼠标事件触发
        @Override
        public void mouseClicked(MouseEvent e) {
            //如果监听到鼠标点击，那么进行下一步判断
            if(e.getID() == MouseEvent.MOUSE_CLICKED){
                //获取当前鼠标相对于source的位置。
                Point absolute_point = e.getPoint();
                //将绝对位置转化成相对于棋盘的位置。
                Point relative_point = clickPosition(absolute_point);
                int x = (int)relative_point.getX();
                int y = (int)relative_point.getY();
                //在棋盘上记录下好的棋子,这里先默认全部都下黑棋
                player.setPiecetype((int) Math.pow((double)-1,(double)chessboard.piecenumber + 1));
                chessboard.bePlayed(x,y,player);
                //下完一步之后立即执行检测算法，观察是否结束。
                gamestatus = detect(x,y,new Piece(player.getPiecetype()));
                //如果胜利了，则清洗棋盘并结束游戏
                if(gamestatus){
                    //在这里也添加repaint操作是为了在弹出对话框之前也能看到下出的棋子
                    repaint();
                    gamestatus = false;
                    //检测一下谁获胜了,使用-1的幂次方进行交换当前下棋权。
                    JOptionPane.showMessageDialog(null,"恭喜" + (Piece.BLACK != (int)Math.pow((double) -1,(double)chessboard.piecenumber + 1)?"黑棋":"白棋") + "胜利！");
                    //在游戏结束之后直接重新建立一张新的棋盘
                    chessboard = new ChessBoard();
                }
                //无论鼠标点击是否游戏结束都进行repanit操作。
                repaint();
            }
        }
    }

    /**
     * 绘画整个可视化界面
     * @param g 绘图对象
     */
    @Override
    //绘制棋盘和棋子
    public void paint(Graphics g){
        //绘画棋盘
        Image backgroud = new ImageIcon("picture/background.png").getImage();
        g.drawImage(backgroud,0,0,null);

        g.setColor(Color.BLACK);
        chessboard.paintLines(g);

        //绘画棋子
        chessboard.paintPiece(g);
    }
}

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private WindowStage ws;
    private JLabel label;

    public Window(){
        setTitle("五子棋");
        //设置窗口关闭的操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        setSize(new Dimension(ChessBoard.DEFAULTWIDTH * Piece.DEFAULTSIZE,ChessBoard.DEFAULTHEIGTH * Piece.DEFAULTSIZE));
        //设置窗口位置
        setLocationRelativeTo(null);
        //设置窗口布局管理器
        setLayout(new FlowLayout());
        //设置窗口可缩放
        setResizable(true);
        //在窗口新建中新建下棋逻辑和标签提示信息
        ws = new WindowStage();
        label = new JLabel("点击鼠标开始下棋！");
        add(ws);
        add(label);

        //添加鼠标监听事件
        addMouseListener(ws.getMouselistner());

        //设置窗口可见性
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}

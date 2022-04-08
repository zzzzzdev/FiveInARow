
public class Player {
    //该玩家持有什么类型的棋子
    private int piecetype;

    //在构造器中就将玩家和棋子绑定。

    /**
     * 构造器，绑定玩家和其棋子，本游戏默认玩家1为黑棋，玩家2为白棋
     * @param Piecetype
     */
    public Player(int Piecetype){
        this.piecetype = Piecetype;
    }

    public int getPiecetype() {
        return piecetype;
    }

    public void setPiecetype(int piecetype) {
        this.piecetype = piecetype;
    }
}

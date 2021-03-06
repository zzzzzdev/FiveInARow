### 游戏名称：五子棋

### 开发语言：Java

### 启动游戏的方式：运行源文件：`src/Window.java`

### 开发关键点：

#### 1）五子棋胜利的判断算法

##### 本游戏采取的是递归算法，分别递归寻找当前位置上下左右斜线位置与之同类型棋子的数量。



#### 2）鼠标事件的监听处理，鼠标精确点击对应GUI界面中相同位置棋子的生成。

##### 采取Graphics类的drawLines方法，生成标准棋盘网格。通过重写MouseAdapter类中MouseClicked方法，捕捉鼠标的绝对坐标，通过数学换算成相对于棋盘的相对坐标，再更新棋盘对应的状态。



#### 3）棋局中，黑棋、白棋轮换下棋的简易算法设计

##### 设置了全局当前棋盘中棋子总数量变量，并设置玩家类型为1、-1，通过棋子总数量的自增与-1的幂即可得到当前持有下棋权的玩家。



#### 后续可以新增的功能：

##### 1）悔棋功能，能够记录下棋日志。

##### 2）当前下棋位置的高亮显示，方便棋手观察。

##### 3）背景音乐与下棋的音效。

##### 4）UI美化

##### 4）棋手持有下棋权的倒计时。

##### 5）使用强化学习，训练AI选手。




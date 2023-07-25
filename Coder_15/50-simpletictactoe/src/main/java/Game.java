public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){
        Referee referee = new Referee();
        Board board = new Board();
        board.Drawing(s);
		return referee.Ruling(s);
    }

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("A1,B1,B2,B3,C3");
        System.out.println(result);
    }
}

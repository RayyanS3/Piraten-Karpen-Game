package pk;

public class Player {
    public String name;
    public int points;
    public int wins;
    public boolean turn;

    public boolean comboPlayer;
    public Player(String name, int points, int wins, boolean turn, boolean comboPlayer){
        this.name = name;
        this.points = points;
        this.wins = wins;
        this.turn = turn;
        this.comboPlayer = comboPlayer;
    }
}

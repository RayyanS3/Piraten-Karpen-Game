package pk;

import java.security.PublicKey;

public class Card {
    public String fortune;
    public int value;
    public int swordNum;
    public Card(String fortune, int value, int swordNum){
        this.fortune = fortune;
        this.value = value;
        this.swordNum=swordNum;
    }

    public Card(String fortune){
        this.fortune=fortune;
    }
}

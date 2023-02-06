package pk;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck {

    public ArrayList<Card> create(){
        ArrayList<Card> cardDeck = new ArrayList<>(35);
        for(int i=0;i<2;i++){cardDeck.add(new Card("SEA BATTLE",300,2));}
        for(int i=0;i<2;i++){cardDeck.add(new Card("SEA BATTLE",500,3));}
        for(int i=0;i<2;i++){cardDeck.add(new Card("SEA BATTLE",1000,4));}
        for(int j=0;j<4;j++){cardDeck.add(new Card("MONKEY BUSINESS"));}
        for(int j=0;j<25;j++){cardDeck.add(new Card("NOP"));}
        return cardDeck;
    }

    public Card getCard(ArrayList<Card> cardDeck){
        Random rand = new Random();
        int bound = 35;
        int randomNum = rand.nextInt(bound);
        bound--;
        return cardDeck.get(randomNum);
    }
}

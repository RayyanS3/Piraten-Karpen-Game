import org.apache.logging.log4j.*;
import pk.*;
import java.util.*;

public class PiratenKarpen {

    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static String[] roll(int num_dice) {
        String[] roll = new String[8];
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        String face = String.valueOf(Faces.values()[bag.nextInt(howManyFaces)]);
        for(int dice=0; dice<num_dice; dice++){
            roll[dice] = face;
            face = String.valueOf(Faces.values()[bag.nextInt(howManyFaces)]);
        }
        return roll;
    }

    public static String[] comboStratergy(String[] myRoll, int num_dice){
        String[] newRoll = myRoll.clone();
        int coin_points = itemCount(newRoll,"DIAMONDS")+itemCount(newRoll,"GOLD");
        while(coin_points<num_dice-1){
            newRoll = roll(num_dice);
            coin_points = itemCount(newRoll,"DIAMONDS")+itemCount(newRoll,"GOLD");
        }


        return newRoll;
    }
    public static int itemCount(String[] list, String target){
        int items=0;
        for(String s:list){if(s==target){items++;}}
        return items;
    }

    public static void main(String[] args) {

        //Trace mode prompt and activator
        boolean trace = false;
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Would you like to run the program in trace mode?");
            String ans = input.next();
            if(ans.toLowerCase().equals("yes")){trace=true;valid=true;break;}
            else if(ans.toLowerCase().equals("no")){trace=false;valid=true;break;}
            else{System.out.println("Please enter either yes or no");}
        }while(valid=true);

        //Player initialization and starter variable declarations
        Player player1 = new Player("Player1",0,0, true,false);
        Player player2 = new Player("Player2",0,0, false,false);
        String[] Faces = {"MONKEY", "PARROT", "GOLD", "DIAMOND", "SABER", "SKULL"};


        for(int num_games=0;num_games<42;num_games++){
            player1.points = 0;
            player2.points = 0;

            //Card-deck initialization
            CardDeck cardDeck = new CardDeck();
            ArrayList<Card> currentDeck = cardDeck.create();

            while(player1.points<6000 && player2.points<6000){
                String[] roll=new String[8];
                Player activePlayer = player1.turn ? player1 : player2;

                //Input of command line arguments
                try {
                    player1.comboPlayer = args[0].toLowerCase().equals("combo") ? true : false;
                    player2.comboPlayer = args[1].toLowerCase().equals("combo") ? true : false;
                }catch(Exception e){}

                //Implementation of picking sea-battle and monkey-business cards
                boolean seaBattle = false;
                boolean monkeyBusiness = false;
                int cardValue = 0;
                Card currentCard = cardDeck.getCard(currentDeck);
                if(currentCard.fortune.equals("SEA BATTLE")){seaBattle=true; if(trace){System.out.println("SEA BATTLE CARD");}}
                if(currentCard.fortune.equals("MONKEY BUSINESS")){monkeyBusiness=true;if(trace){System.out.println("MONKEY BUSINESS CARD");}}

                //Random number of dices rolled and kept by player; Makes sure atleast two dice are rolled
                int num_dice = (int)(Math.random()*8)+1;
                while(num_dice<2){num_dice=(int)(Math.random()*8)+1;}
                roll = roll(num_dice);
                if(activePlayer.comboPlayer && seaBattle==false){roll = comboStratergy(roll,num_dice).clone();}
                int num_skulls = itemCount(roll, "SKULL");
                if(trace&&num_skulls<3){System.out.println(Arrays.toString(roll));}

                //Check to see if sea-battle is the fortune picked and number of swords is equal to dice roll
                if(seaBattle){
                    int num_saber = itemCount(roll, "SABER");
                    if(num_saber== currentCard.swordNum){activePlayer.points+=currentCard.value;}
                }

                //Number of skulls rolled
                if(num_skulls>=3){player1.turn = !player1.turn; player2.turn = !player2.turn; continue;}

                //Check to see if monkey business is the fortune picked
                if(monkeyBusiness){
                    for(int i=0;i<roll.length;i++){if(roll[i]=="PARROT"){roll[i]="MONKEY";}}
                }

                //Check to see dice combos and assign points
                int multiple_points = 0;
                for (int i = 0; i < Faces.length; i++) {
                    if (itemCount(roll, Faces[i]) == 3) {multiple_points += 100;}
                    else if (itemCount(roll, Faces[i]) == 4) {multiple_points += 200;}
                    else if (itemCount(roll, Faces[i]) == 5) {multiple_points += 500;}
                    else if (itemCount(roll, Faces[i]) == 6) {multiple_points += 1000;}
                    else if (itemCount(roll, Faces[i]) == 7) {multiple_points += 2000;}
                    else if (itemCount(roll, Faces[i]) == 8) {multiple_points += 4000;}
                }

                //Points obtained from gold and diamond items
                int coin_points = 100*(itemCount(roll,"DIAMOND")+itemCount(roll,"GOLD"));
                if(itemCount(roll,"DIAMOND")+itemCount(roll,"GOLD")==8){coin_points+=500;}
                int total_points = coin_points+multiple_points;
                activePlayer.points += total_points;

                if(trace){
                    System.out.printf("Player 1 points: %d and Player 1 wins: %d: \n",player1.points,player1.wins);
                    System.out.printf("Player 2 points: %d and Player 2 wins: %d: \n",player2.points,player2.wins);
                    System.out.println("-----------------------------------------------------------------------------------");
                }
            }

            //Incrementing the wins for active player
            if(player1.points>=6000){player1.wins++;}
            else{player2.wins++;}
            player1.turn = !player1.turn;
            player2.turn = !player2.turn;
        }

        //Logger messages and implementation
        int p1_percent = Math.round(100*player1.wins/42);
        int p2_percent = 100-p1_percent;
        if(trace)
        {
            System.out.println("Welcome to the Piraten Karpen Simulator");
            logger.info("Player 1: " + player1.wins + " wins | win percent " + p1_percent+ "%");
            logger.info("Player 2: " + player2.wins + " wins | win percent " + p2_percent+ "%");
        }
    }
    
}

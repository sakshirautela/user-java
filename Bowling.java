import java.util.HashMap;
import java.util.Scanner;


public class Bowling {
    HashMap<String, Integer> players;
    Bowling() {
        players = new HashMap<String, Integer>();
    }
    public void addPlayer(String name, int p) {
        players.put(name, p);
    }
    //your code goes here
    public void getWinner(){
        String winner="";
        String[] nameArr = new String[players.size()];
         nameArr = players.keySet().toArray(nameArr);
         int max=0;
         for(String em:nameArr){
             if(players.get(em)>max){
                 winner=em;
                max=players.get(em);
             }
         }
         System.out.println(winner);
    } 
    
}

class Program {
    public static void main(String[ ] args) {
        Bowling game = new Bowling();
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<3;i++) {
            String input = sc.nextLine();
            String[] values = input.split(" ");
            String name = values[0];
            int points = Integer.parseInt(values[1]);
            game.addPlayer(name, points);
        }
        game.getWinner();
    }
}
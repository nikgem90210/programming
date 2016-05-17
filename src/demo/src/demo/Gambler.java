package demo.src.demo;



public class Gambler { 

    public static void main(String[] args) {
    	
        int stake = Integer.parseInt(args[0]);   
        int goal  = Integer.parseInt(args[1]);    
        int T     = Integer.parseInt(args[2]);    

        int bets = 0;       
        int wins = 0;       

        // repeat N times
        for (int t = 0; t < T; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) cash++;     
                else                     cash--;     
            }
            if (cash == goal) wins++;                
        }

        // print results
        System.out.println(wins + " wins of " + T);
        System.out.println("Percent of games won = " + 100.0 * wins / T);
        System.out.println("Avg # bets           = " + 1.0 * bets / T);
    }

}
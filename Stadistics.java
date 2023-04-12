import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Stadistics {
    public Stadistics(){

    }

    public void countVotes(FileReader file){
        Timer timer = new Timer();
        int delay = 10000 / 3; 
        String [] options = {"Valor1", "Valor2", "Valor3", "Valor4", "Valor5", "Valor6"};
        TimerTask printVotes = new TimerTask() {
            int valor1Counter = 0, valor2Counter = 0, valor3Counter = 0, valor4Counter = 0, valor5Counter = 0, valor6Counter = 0;
            public void run(){
                
                try {
                    Scanner sc = new Scanner(file);
                    while (sc.hasNextLine()){
                        String curp_vote = sc.nextLine();
                        switch (curp_vote.split(" ")[1]) {
                            case "Valor1": 
                                valor1Counter ++;
                                break;
                            case "Valor2": 
                                valor2Counter ++;
                                break;
                            case "Valor3": 
                                valor3Counter ++;
                                break;
                            case "Valor4":
                                valor4Counter ++;
                                break;
                            case "Valor5":
                                valor5Counter ++;
                                break;
                            case "Valor6":
                                valor6Counter ++;
                                break;
                        }
                    }
                    for(String option : options){
                        switch (option){
                            case "Valor1": 
                                System.out.println(option + " " + getStringVotes(valor1Counter));
                            break;
                            case "Valor2": 
                                System.out.println(option + " " + getStringVotes(valor2Counter));
                                break;
                            case "Valor3": 
                                System.out.println(option + " " + getStringVotes(valor3Counter));
                                break;
                            case "Valor4":
                                System.out.println(option + " " + getStringVotes(valor4Counter));
                                break;
                            case "Valor5":
                                System.out.println(option + " " + getStringVotes(valor5Counter));
                                break;
                            case "Valor6":
                                System.out.println(option + " " + getStringVotes(valor6Counter));
                                break;
                        }
                    }
                    System.out.println("\n");

                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };

        timer.scheduleAtFixedRate(printVotes, 0, delay);
    }
    
    public static String getStringVotes(int numberVotes){
        String votesPrinter = "*";
        for(int i = 0; i < numberVotes ; i++ ){
            votesPrinter = votesPrinter + "*";
        }
        return votesPrinter;
    }

    public static void main(String [] args) {
        Stadistics stadistics = new Stadistics();
        try {
            FileReader file = new FileReader("Curps.txt");
            stadistics.countVotes(file);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

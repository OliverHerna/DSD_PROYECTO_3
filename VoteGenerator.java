import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


class VoteGenerator{
    private Timer time;

    public void VoteGenerator(){

    }
    
    public void generate_each_second(int curps_per_second){
        time = new Timer();
        //Delay of the generation of curps
        int delay = 1000 / curps_per_second;
        TimerTask generate_curp = new TimerTask() {
            //Function to generate curps
            public void run(){
                System.out.print("HEMO010923HDFRNLA8 " + selectOptionRandom() + "\n"); 
            }
        };
                                
        time.scheduleAtFixedRate(generate_curp, 0, delay);

    }

    private static String selectOptionRandom(){
        //List of options
        String[] options = {"PRI", "PAN", "PRD", "MORENA"};
        Random random = new Random();
        int index_options = random.nextInt(options.length);
        //We return the aleatory option
        return options[index_options];
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        VoteGenerator votes = new VoteGenerator();
        int curps_per_second = 0;
        System.out.print("Please enter the number of votes per second: ");
        curps_per_second = sc.nextInt();
        votes.generate_each_second(curps_per_second);
        sc.close();
    }
}
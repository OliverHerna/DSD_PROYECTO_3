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
    
    public void generate_each_second(int curps_per_second, FileWriter writer){
        time = new Timer();
        //Delay of the generation of curps
        int delay = 1000 / curps_per_second;
        TimerTask generate_curp = new TimerTask() {
            //Function to generate curps
            public void run(){
                try {
                    //write 
                    writer.write(getCURP() + " " + selectOptionRandom() + "\n");
                    //To see inmediately the output
                    writer.flush();
                } catch (IOException e) {
                    // TODO: handle exception
                }
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

    static String getCURP()

    {

        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String Numero = "0123456789";

        String Sexo = "HM";

        String Entidad[] = {"AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS"};

        int indice;

        

        StringBuilder sb = new StringBuilder(18);

        

        for (int i = 1; i < 5; i++) {

            indice = (int) (Letra.length()* Math.random());

            sb.append(Letra.charAt(indice));        

        }

        

        for (int i = 5; i < 11; i++) {

            indice = (int) (Numero.length()* Math.random());

            sb.append(Numero.charAt(indice));        

        }

 

        indice = (int) (Sexo.length()* Math.random());

        sb.append(Sexo.charAt(indice));        

        

        sb.append(Entidad[(int)(Math.random()*32)]);

 

        for (int i = 14; i < 17; i++) {

            indice = (int) (Letra.length()* Math.random());

            sb.append(Letra.charAt(indice));        

        }
        for (int i = 17; i < 19; i++) {

            indice = (int) (Numero.length()* Math.random());

            sb.append(Numero.charAt(indice));        

        }
        return sb.toString();
    } 

    public static void main(String [] args){ 
        Scanner sc = new Scanner(System.in);
        VoteGenerator votes = new VoteGenerator();
        int curps_per_second = 0;
        System.out.print("Please enter the number of votes per second: ");
        curps_per_second = sc.nextInt();
        try {
            FileWriter writer = new FileWriter("Curps.txt");
            votes.generate_each_second(curps_per_second, writer);
            
        } catch (IOException e) {
            // TODO: handle exception
        }
        
        sc.close();
    }
}
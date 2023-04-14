import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class ConsultVotes {
    public static FileReader file;
    //Function to read the file 
    public static void readFIle(){
        try {
            file = new FileReader("Curps.txt");
        } catch (IOException e) {
            System.out.println("");
        }
               
    }

    //Function to get the votes per Sex
    public static String votesPerSex(){
        String data = "";
        int male_counter = 0, female_counter = 0;

        //Read the file
        readFIle();
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String curp = sc.nextLine().split(" ")[0];
            char sexo = curp.charAt(10);
            if(sexo == 'M'){
                female_counter ++;
            }else if(sexo == 'H'){
                male_counter ++;
            }
            

        }
        data =  "Hombres: " + male_counter + "\n" + "Mujeres " + female_counter + "\n";

        sc.close();

        return data;
    }
    public static void main(String [] args) {
        Boolean continue_consult = true;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        //Iterated menu
        while(continue_consult){
            System.out.println("Please Select an Option\n 1. Votos totales por Sexo");
            System.out.println(" 2. Votos por cada estado");
            System.out.println(" 3. Votos por edad");
            System.out.println(" 4. Votos por partido");
            System.out.println(" 5. Salir");
            option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.println(votesPerSex());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    continue_consult = false;
                    break;
            }
        }   


        sc.close(); 
    }
}

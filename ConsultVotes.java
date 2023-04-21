//Oliver Manuel Hernandez Mendez
//PROYECTO 3
//4CM14

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

    public static String votesPerState(){
        String data = "";
        Map<String, Integer> state_counter = new HashMap<String, Integer>();
        readFIle();
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String curp = sc.nextLine().split(" ")[0];
            //Obtenemos la abreviacion de estado HEMO010923HDFRNLA8
            String state = curp.substring(11, 13);
            if(!state_counter.containsKey(state)){
                state_counter.put(state, 1);
            }else{
                int counter = state_counter.getOrDefault(state, null);
                int actualized_counter = counter + 1;
                state_counter.replace(state, counter, actualized_counter);
            }
        }
        for (Map.Entry<String, Integer> me : state_counter.entrySet()) {
            // Printing keys
            data =  data + " " + me.getKey() + ": " + me.getValue() + "  ";
        }  
        
        return data;
    }

    public static String votesPerAge(){
        String data = "";
        //Actual date to get the age 
        LocalDate current_date = LocalDate.now();
        Map<Integer, Integer> age_counter = new HashMap<Integer, Integer>();
        readFIle();
        Scanner sc = new Scanner(file);
        //Read each line of the file 
        while(sc.hasNextLine()){
            //Get the age 
            String current_curp = sc.nextLine().split(" ")[0];
            String year = current_curp.substring(4, 6);
            String month = current_curp.substring(6, 8);
            String day = current_curp.substring(8, 10);
            String formattedYear = "";
            //Parsing the date 
            //LocalDate curp_date = LocalDate.parse("01/01/" + year, DateTimeFormatter.ofPattern("dd/MM/yy"));;
            //If the year is minor than the actual year +20
            //else + 19
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            if(current_date.getYear() >= 2000 + Integer.parseInt(year)){
                try {
                    date = sdf.parse("20" + year); 
                } catch (Exception e) {
                    // TODO: handle exception
                }
                formattedYear = sdf.format(date);
            }else{
                try {
                    date = sdf.parse("19" + year);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                 
            formattedYear = sdf.format(date);
            }

            LocalDate curp_date = LocalDate.of(Integer.parseInt(formattedYear), 01, 01);


            Period period = Period.between(curp_date, current_date);
        
            // Get the years, months, and days
            int years = period.getYears();
            //Counting the number of votes 
            if(!age_counter.containsKey(years)){
                age_counter.put(years, 1);
            }else{
                int counter = age_counter.getOrDefault(years, null);
                int actualized_counter = counter + 1;
                age_counter.replace(years, counter, actualized_counter);
            }
            

        }
        for (Map.Entry<Integer, Integer> me : age_counter.entrySet()) {
            // Printing keys
            data =  data + " " + me.getKey() + ": " + me.getValue() + "  ";
        }  

        return data;        
    }

    public static String votesPerOption(){
        String data = "";
        Map<String, Integer> option_vote_counter = new HashMap<String, Integer>();
        readFIle();
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String option = sc.nextLine().split(" ")[1];
            if(!option_vote_counter.containsKey(option)){
                option_vote_counter.put(option, 1);
            }else{
                int counter = option_vote_counter.getOrDefault(option, null);
                int actualized_counter  = counter + 1;
                option_vote_counter.replace(option, counter, actualized_counter);
            }
        }
        for (Map.Entry<String, Integer> me : option_vote_counter.entrySet()) {
            // Printing keys
            data =  data + " " + me.getKey() + ": " + me.getValue() + "  ";
        }  

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
                    System.out.println(votesPerSex() + "\n");
                    break;
                case 2:
                    System.out.println(votesPerState() + "\n");
                    break;
                case 3:
                    System.out.println(votesPerAge() + "\n");
                    break;
                case 4:
                    System.out.println(votesPerOption()+ "\n");
                    break;
                case 5:
                    continue_consult = false;
                    break;
            }
        }   


        sc.close(); 
    }
}

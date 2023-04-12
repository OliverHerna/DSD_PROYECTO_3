class ExamplePrintVotes{
    public static void main(String [] args) {
    
        int priCounter = 15;
        String votesPrinter = "*";
        for(int i = 0; i < priCounter ; i++ ){
            votesPrinter = votesPrinter + "*";
        }
        

        System.out.println("PRI " + votesPrinter);
    } 

}
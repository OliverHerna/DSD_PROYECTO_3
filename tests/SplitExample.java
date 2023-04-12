//CHAT GPT EXAMPLE
class SplitExample{
    public static void main(String [] args){
        String str = "GRGE411901MSPFRI12 PRI";

        // Split the string into an array of words
        String[] words = str.split(" ");

        // Print each word to the console
        for (String word : words) {
            System.out.println(word);
        }       

        //print only the second part of the word
        System.out.println(words[1]);
    }
}
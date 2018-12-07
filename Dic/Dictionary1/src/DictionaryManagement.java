import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline(){
    	
        System.out.println("Nhap so luong tu: ");
        Scanner input = new Scanner(System.in);                 
        String w_Target, w_Explain;
        //nhap so luong tu
        int numberOfWords = input.nextInt();                   
        input.nextLine();
        
        for(int i = 0; i < numberOfWords; i ++) {
            Word word = new Word();                           
            //nhap tu moi
            System.out.println("Word " + (i+1) +":");
            w_Target = input.nextLine();
            word.setWord_Taget(w_Target);
            //nhap nghia
            System.out.println("Explain");
            w_Explain = input.nextLine();
            word.setWord_Explain(w_Explain);

            Word newWord = new Word(w_Target, w_Explain);
            Dictionary.dictionary.add(newWord);
        }
    }

}

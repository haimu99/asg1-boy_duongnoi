import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {



    public void insertFromCommandline(){
        System.out.println("Nhap so luong tu ");                    
        Scanner input = new Scanner(System.in);                         
        int numberOfWords = input.nextInt();                            
        input.nextLine();

        for(int i = 0; i < numberOfWords; i ++) {
            Word newWord = new Word();                                  
            System.out.println("Tu: " + (i+1) + ":");
            newWord.setWord_target(input.nextLine());                   
            System.out.println("Dich nghia:" + (i+1) + ":");
            newWord.setWord_explain(input.nextLine());                 


            Dictionary.dictionary.add(newWord);                         
        }
    }


    //Insert from file

    public void insertFromFile(){
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader("F:\\GitHub\\asg1-boy_duongnoi\\Dictionary2\\src\\dictionaries.txt");
            br = new BufferedReader(fr);                                    

            String contentLine = br.readLine();                             
            while (contentLine != null) {
                if(contentLine.indexOf("\t") == -1){                       
                    contentLine = br.readLine();
                    continue;
                }

                Word newWord = new Word(contentLine);                       
                (Dictionary.dictionary).add(newWord);
                contentLine = br.readLine();                               
            }
        }catch (IOException e){                                             
            e.printStackTrace();
        }finally{
            try{
                br.close();                                                
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    //Dictionary Look Up

    public void dictionaryLookup(){
        Scanner input = new Scanner(System.in);                             
        System.out.print("\nNhap tu can tiem kiem: ");
        String wordLookup = input.nextLine();                              

        for(Word w: Dictionary.dictionary){
            if(wordLookup.equals(w.getWord_target())){                      
                System.out.println("Tu can tim la : " + wordLookup);
                System.out.println("Dich nghia la : "+ w.getWord_explain());
                return;
            }
        }
        System.out.println("Khong tim thay tu!");                 
    }

}

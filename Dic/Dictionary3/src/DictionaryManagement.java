import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    public final String fileReader = "dictionaries.txt";         
    private Scanner input = new Scanner(System.in);                   

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
            word.setWord_target(w_Target);
            //nhap nghia
            System.out.println("Explain");
            w_Explain = input.nextLine();
            word.setWord_explain(w_Explain);

            Word newWord = new Word(w_Target, w_Explain);
            Dictionary.dictionary.add(newWord);
        }
    }


    /**
     * nhap tu file
     */

    public void insertFromFile(){
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader("F:\\GitHub\\asg1-boy_duongnoi\\Dictionary3\\src\\dictionaries.txt");
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



    /**
     * Edit word by new word
     */

    public void editAnyWord() {

        System.out.print("Nhap tu muon chinh sua: ");
        String needEditing = input.nextLine();                                         

        for (int i = 0; i < Dictionary.dictionary.size(); i ++) {
            if(Dictionary.dictionary.get(i).getWord_target(). equals(needEditing)) {     
                System.out.print("Nhap tu moi: ");
                String new_target = input.nextLine();                                   
                System.out.print("Nhap dich nghia: ");
                String new_explain = input.nextLine();                                  

                Dictionary.dictionary.set(i, new Word(new_target, new_explain));        

                System.out.println("Sua thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay tu!");                                         
    }


    /**
     * Delete word
     */

    public void deleteAnyWord() {
        System.out.print("Nhap tu ban muon xoa: ");
        String needDeleting = input.nextLine();                                          
     

        for (int i = 0; i < Dictionary.dictionary.size(); i ++) {
            if (Dictionary.dictionary.get(i).getWord_target(). equals(needDeleting)) {     
                Dictionary.dictionary.remove(i);                                          
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay!");                                             
    }

    public void addWord() {
        System.out.print("Nhap tu muon them: ");
        String newWord = input.nextLine();
        System.out.print("Nhap nghia: ");
        String mean = input.nextLine();                

        Dictionary.dictionary.add(new Word(newWord, mean));

        System.out.println("Them tu thanh cong!");
    }

}

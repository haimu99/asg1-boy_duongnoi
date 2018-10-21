import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();             
    Scanner input = new Scanner(System.in);                           

    /**
     * Basic dictionary
     */

   /* public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();                        
        showAllWords();
        dictionaryManagement.dictionaryLookup();                                            
        dictionaryManagement.editAnyWord();                                                
        dictionaryManagement.deleteAnyWord();                                              
        dictionarySearcher();
        showAllWords();
        dictionaryExportToFile();                                                           
    }*/


    /**
     * Advanced dictionay
     */

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();                                   
        System.out.println("0. Thoat\n1. Hien thi ca tu\n2. Sua tu\n3. Xoa tu\n4. Tim kiem\n5. Tra tu\n6. Them tu moi");
        int chooseFunction = input.nextInt();

        switch (chooseFunction) {
            case 0: {
                System.out.println("Hen gap lai.");
                break;
            }
            case 1: {
                showAllWords();
                break;
            }
            case 2: {
                dictionaryManagement.editAnyWord();                                                 
                dictionaryExportToFile();
                break;
            }
            case 3: {
                dictionaryManagement.deleteAnyWord();                                               
                dictionaryExportToFile();
                break;
            }
            case 4: {
                dictionarySearcher();
                break;
            }
            case 5: {
                dictionaryManagement.dictionaryLookup();                                            //Look up word
                break;
            }
            case 6: {
                dictionaryManagement.addWord();
                dictionaryExportToFile();
                break;
            }
            default:
                System.out.println("Khong hop le!");
        }

    }


    /**
     * Show list words
     */

    public void showAllWords() {
        if (Dictionary.dictionary.size() == 0) System.out.println("Khong tim thay du lieu trong file!");
        else {
            System.out.println("\n---Danh sach gom " + Dictionary.dictionary. size() + " tu---");

            for (int i = 0; i < Dictionary.dictionary.size(); i++) {
                String w_target  = (Dictionary.dictionary).get(i). getWord_target();             
                String w_explain = (Dictionary.dictionary).get(i). getWord_explain();           
                System.out.printf("%-15s %s %n", w_target, w_explain);
            }
        }
    }


    /**
     * Tim kiem tu hop le
     */

    public void dictionarySearcher() {
        System.out.print("Nhap tu: ");
        String stringGroup = input.nextLine();                                          
        DictionaryManagement call = new DictionaryManagement();
        boolean checkExist = false;                                                     
        System.out.println("Cac tu hop le: " + stringGroup);

        for (Word w : Dictionary.dictionary) {
            if (w.getWord_target().indexOf(stringGroup) == 0) {
                System.out.printf("%-15s %s %n", w.getWord_target(), w.getWord_explain());     
                checkExist = true;
            }
        }

        if (!checkExist)
            System.out.println("Khong tim thay!");                          
    }

    /**
     * Xuat du lieu ra file
     */

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;

        try{
            FileWriter fw = new FileWriter(dictionaryManagement.fileReader);
            bw = new BufferedWriter(fw);                               

            for (Word w : Dictionary.dictionary) {                     
                bw.write(w.getWord_target() + "\t" + w.getWord_explain());  
                bw.newLine();
            }

            bw.close();                                                     
        }catch (IOException e){                                             
            e.printStackTrace();
        }
        System.out.println("\nGhi ra file thanh cong!");                   

    }
}

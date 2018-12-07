public class DictionaryCommandline {



    public void showAllWords(){
        if(Dictionary.dictionary.size() == 0) System.out.println("Khong co du lieu!");
        else {
            System.out.println("Danh sach tu : ");

            for (int i = 0; i < Dictionary.dictionary.size(); i++){
                String w_target = (Dictionary.dictionary).get(i).getWord_target();              
                String w_explain = (Dictionary.dictionary).get(i).getWord_explain();            
                System.out.printf("%-15s %s %n", w_target, w_explain);
            }
        }
    }



    public void dictionaryBasic(){
        DictionaryManagement dictionaryManagement = new DictionaryManagement();           
        dictionaryManagement.insertFromCommandline();                                       
        showAllWords();                                                                     
    }



    public void dictionaryAdvanced(){
        DictionaryManagement dictionaryManagement = new DictionaryManagement();            
        dictionaryManagement.insertFromFile();                                              
        showAllWords();
        dictionaryManagement.dictionaryLookup();                                            
    }

}

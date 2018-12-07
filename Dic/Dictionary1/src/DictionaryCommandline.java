public class DictionaryCommandline {
    public void showAllWords(){
        if(Dictionary.dictionary.size() == 0) System.out.println("Khong co du lieu");
        else
            for(int i = 0; i < Dictionary.dictionary.size(); i ++)
                System.out.printf("%-10s %s %n", (Dictionary.dictionary).get(i).getWord_Taget(), (Dictionary.dictionary).get(i).getWord_Explain());
    }


    public void dictionaryBasic(){
        DictionaryManagement cmd = new DictionaryManagement();
        cmd.insertFromCommandline();
        showAllWords();
    }

}

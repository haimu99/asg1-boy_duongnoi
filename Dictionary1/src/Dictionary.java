import java.util.ArrayList;

public class Dictionary {
	public ArrayList<Word> listWord(){
		DictionaryManagement dicManagement=new DictionaryManagement();
		ArrayList<Word> word=dicManagement.insertFrotmCommandline();
		return word;
	}
}

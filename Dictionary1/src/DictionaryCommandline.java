

public class DictionaryCommandline {
	DictionaryManagement dicMana=new DictionaryManagement();
	Dictionary listword=new Dictionary();
	Word word=new Word();
	public void showAllWord() {
		for (int i=0;i<listword.listWord().size();i++) {
			System.out.printf("%-3s %12s %12s%n",i+1,word.getWord_target(),word.getWord_explain());
		}
	}
	public void dictionaryBasic() {
		dicMana.insertFrotmCommandline();
		showAllWord();
	}
}

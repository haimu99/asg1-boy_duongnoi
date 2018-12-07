import java.util.ArrayList;

public class Dictionary {
	
    static ArrayList<Word> dictionary = new ArrayList<Word>();

    public ArrayList<Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Word e) {
        (this.dictionary).add(e);
    }
}

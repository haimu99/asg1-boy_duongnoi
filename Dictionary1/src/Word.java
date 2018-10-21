public class Word {
    private String word_Target ;
    private String word_Explain ;

    public Word() { 	
    }
    
    public Word(String word_Target, String word_Explain) {
        this.word_Target = word_Target;
        this.word_Explain = word_Explain;
    }

    
    public String getWord_Taget() {
        return word_Target;
    }

    public void setWord_Taget(String word_Taget) {
        this.word_Target = word_Target;
    }

    public String getWord_Explain() {
        return word_Explain;
    }

    public void setWord_Explain(String word_Explain) {
        this.word_Explain = word_Explain;
    }
    
}

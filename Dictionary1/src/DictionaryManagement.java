import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
	public ArrayList<Word> listWord= new ArrayList<Word>();
	int n=10000;
	public void insertFromCommandline(){

		Scanner sc=new Scanner(System.in);
		for (int i=0;i<listWord.size();i++) {
			System.out.println("Nhap tu");
			String word_target=sc.nextLine();
			System.out.println("Nhap nghia");
			String word_explain=sc.nextLine();
			Word newWord=new Word();
			listWord.add(newWord);
		}
		
	}
	
}

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

	public ArrayList<Word> insertFrotmCommandline(){
		ArrayList<Word> listWord= new ArrayList<Word>();
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap so luong tu: ");
		n=Integer.parseInt(sc.nextLine());
		for (int i=0;i<n;i++) {
			System.out.println("Nhap tu");
			String word_target=sc.nextLine();
			System.out.println("Nhap nghia");
			String word_explain=sc.nextLine();
			Word newWord=new Word();
			listWord.add(newWord);
		}
		return listWord;
	}
	
}

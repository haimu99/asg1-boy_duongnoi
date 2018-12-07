/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

//import static Dictionary.DictionaryManagement.dictionaryLookup;
//import static Dictionary.DictionaryManagement.insertFromFile;
import static Dictionary.DictionaryManagement.listWord;
//import static Dictionary.DictionaryManagement.readFromFile;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author huybq
 */
public class DictionaryCommandline {
    static public void showAllWords()
    {
        System.out.println("Number       |"+"English              |"+"Vietnamese");
        int i = 1;
       for (Word show:listWord)
        {
           
            System.out.print( " "+i+ "           |"+ show.word_target);
            for (int j = 0 ; j < 20-show.word_target.length(); j ++)
            {
                System.out.print(" ");
            }
            System.out.print(" |"+show.word_explain);
            System.out.println("");
            i++;
        }
    }
    static public void dictionaryAdvanced() throws IOException
    {
        
    }
    public void dictionalBasic()
    {
        // call insertCommandline , showAllWords function
    }
}
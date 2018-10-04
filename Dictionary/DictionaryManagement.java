/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import static Dictionary.DictionaryCommandline.showAllWords;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author huybq
 */
public class DictionaryManagement {
   static Scanner cin = new Scanner(System.in);
   static int value_word;
 static ArrayList<Word> listWord = new ArrayList<Word>();
static String word_target;  
    static String word_explain;
 static public void insertFromCommandline()
    {
        value_word = cin.nextInt();
        for (int i = 0 ; i < value_word ; i ++)
        {
            Word newWord = new Word();
            newWord.word_target = cin.next();
            newWord.word_explain = cin.nextLine();
            listWord.add(newWord);
        }
    }   
     static public void readFromFile() throws FileNotFoundException
       {
        FileReader  file = new FileReader("Dictionary.txt");
         int i = 0;
      //   int count = value_word;
       try(Scanner sc = new Scanner(file))
       {
           String str1,str2;
           while(sc.hasNext() )
           {
               Word readWord = new Word();
               str1 = sc.next();// read target
               str2 = sc.nextLine();// read explain
               readWord.word_target = str1;
               readWord.word_explain = str2;
               listWord.add(readWord);
//              System.out.print(str1);
//               System.out.print(str2);
//              System.out.println();
          //     count--;
               i++;
           }
            
       }catch (Exception e)
       {
           System.out.println(e.getMessage());
       }
       
      }
     static public void insertFromFile() throws IOException
     {
         File open_file = new File("Dictionary.txt");
         // append file
        FileWriter writer_file = new FileWriter(open_file.getAbsoluteFile(),true);
         System.out.println("Please Input the number word to insert ");
         int number_insert = cin.nextInt();
       try (BufferedWriter file = new BufferedWriter(writer_file)) {
           for (int i = 0 ; i < number_insert ; i ++)
           {
               Word writeWord = new Word();
               writeWord.word_target = cin.next();
               writeWord.word_explain = cin.nextLine();
               file.write(writeWord.word_target);
               file.write(writeWord.word_explain);
               file.newLine();
           }
           file.close();
       }
     }
     static public void delete_Word()
     {
         System.out.println("Please input the word to remove ");
         String remove_word = cin.next();
         Iterator<Word> iterator = listWord.iterator();
         while(iterator.hasNext())
         {
             Word result = iterator.next();
             if (result.word_target.equals(remove_word))
             {
                 iterator.remove();
             }
         }
         
        
     }
     static public void insert_Word()
     {
         System.out.println("Please input the word to add ");
          Word insert_word  = new Word();
         insert_word.word_target = cin.next();
         insert_word.word_explain = cin.nextLine();
         listWord.add(insert_word);         
     }
       static public void dictionaryLookup()
       {
           System.out.println("Please input the word to search ");
           String find_word = cin.nextLine();
           boolean check = true;
           for (Word b:listWord)
           {
               if (b.word_target.equals(find_word))
               {
                   System.out.println(b.word_explain);
                   check = false;
                   break;
               }
           }
           if (check) System.out.println("the Word not found");
        }
       static public void dictionarySearcher()
       {
           System.out.println("please input substring in a word ");
           String sub_word = cin.next();
            for(Word search:listWord)
            {
                if (search.word_target.indexOf(sub_word) == 0)
                {
                    System.out.println(search.word_target) ;
                }
            }
       }
    public static void main(String args[]) throws IOException
    {

     readFromFile();
        //delete_Word();
//        insert_Word();
        showAllWords();
        dictionarySearcher();
       // insertFromFile();
       // readFromFile();
      //  showAllWords();
        //dictionaryLookup();
    }
}

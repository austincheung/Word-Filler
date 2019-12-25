/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordfiller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Austin
 */
public class WordFiller {

   public static String getAuthorName(){return ("Cheung, Austin");}
    
   public static String getRyersonID(){return ("500810580");}
   
   private static List<String> str;
   
   public static void processWordList(List<String> words)
   {
       str = new ArrayList <String> (words.size());
       str=words;
   }
   
   public static String fillPattern(String pattern)
   {   
       int beg=0;
       int end=5;
       char [] arr = pattern.toCharArray();
       String word = pattern.substring(beg,end);
       String result=pattern;
       String match=""; 
       
       while (end < pattern.length())
       {
         word = result.substring(beg,end);

       for(int i = 0; i < str.size(); i++)
       {
           match = str.get(i);
           
           for(int j=0; j<word.length(); j++)
       {
           if(word.charAt(j) == '*')
           {
               match=match.replace(match.charAt(j), '*');
           }
       }
           
           if(word.equals(match))
           {
               int loc=0;
               for(int j = beg; j<end; j++)
               {
               arr[j] = str.get(i).charAt(loc);
               loc++;
               }
               break;
           }
       }
       beg++;
       end++;
       }
       
        for(int i =0; i < arr.length; i++)
       {
           if(arr[i] == '*')
           {
               arr[i] = 's';
           }
       }
       
       String newpattern = Arrays.toString(arr);
       newpattern = newpattern.replace(",", "");
       newpattern = newpattern.replace(" ", "");
       newpattern = newpattern.replace("[", "");
       newpattern = newpattern.replace("]", "");
       
       return newpattern;
   }
}



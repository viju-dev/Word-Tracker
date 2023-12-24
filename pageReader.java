import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class pageReader {
    static List<String> excludeWords = new ArrayList<>(); // to words which need to exclude
    static Map<String,List<Integer>> stringIndexMap = new TreeMap<>(); // used treeMap to store words with their page indexes and to maintain alphabetical orders of word while storing
    final int index; // to store page indexes

     Scanner sc ;
    public pageReader(String path,int index) throws FileNotFoundException {
        sc = new Scanner(new File(path));
        sc.useDelimiter("[\\s0-9:,.(){}/-]+"); // used to exclude numbers and symbols/chars
        this.index=index;
    }

    public void searchText()
    {
        String str;
        while (sc.hasNext()) { //will run until another token is vailable
            str = sc.next();
            str = str.toLowerCase();
            str = str.replaceAll("\"", "");

            if(stringIndexMap.containsKey(str)){ // checking if word is already present in stringIndexMap
                if (!stringIndexMap.get(str).contains(index)){ // checking if repeated word from same page
                    stringIndexMap.get(str).add(index);// if not from same page then added index
                }
            }
            else if (!excludeWords.contains(str)){
                stringIndexMap.put(str,new ArrayList<>());// if new word then initialize arraylist in stringIndexMap  with given key
                stringIndexMap.get(str).add(index); // added page index in arraylist
            }

        }

    }

    public void addExcludeWords(){
        String str ;
        while(sc.hasNext()){ // created list of excluded words
            str = sc.next();
            excludeWords.add(str);
        }

    }

    public static String printOutput(){
        StringBuilder sb =new StringBuilder("");

        sb.append("Word : Page Numbers\n");
        sb.append("-------------------\n");
        for (String s: stringIndexMap.keySet()){ // iterating over stringIndexMap to add all keys and values inside string builder in custom format
            sb.append(s+" : ");
            for (int x: stringIndexMap.get(s)){
                sb.append(x+",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
        return sb.toString(); // converted string builder to string and return
    }

    public void write(String path,String data) throws IOException {
        FileWriter myWriter;// created FileWriter to right content inside file
        myWriter = new FileWriter(path); // pass path where we have to write content

        myWriter.write(data);//wrote data into file
        myWriter.close(); // close FileWriter
    }
    public  void closeScanner(){
        sc.close(); //close scanner
    }
}

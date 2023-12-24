import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Initialized 4 pageReader Objects beacuse we have 4 files to read
        pageReader excludefile;
        pageReader page1;
        pageReader page2;
        pageReader page3;

        // use try-catch to handle exception if occur
        try {
            excludefile = new pageReader("BookPages\\exclude-words.txt", 0);
            page1 = new pageReader("BookPages\\Page1.txt", 1);
            page2 = new pageReader("BookPages\\Page2.txt", 2);
            page3 = new pageReader("BookPages\\Page3.txt", 3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        excludefile.addExcludeWords(); //call this method to add words from exclude-words File to add in excludeWords list

        page1.searchText(); // call this method to search for words in page and add them in stringIndexMap with their page indexes
        page2.searchText();
        page3.searchText();


        String data = pageReader.printOutput(); // call to store stringIndexMap data in data

        try {
            page3.write("BookPages\\index.txt", data); // passed path of file where we have to write our output
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //close scanner for all instances
        excludefile.closeScanner();
        page1.closeScanner();
        page2.closeScanner();
        page3.closeScanner();

    }
}

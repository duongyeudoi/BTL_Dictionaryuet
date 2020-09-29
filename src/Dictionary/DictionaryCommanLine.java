package Dictionary;
import java.util.*;
public class DictionaryCommanLine extends DictionaryManagement{
    public void showAllWords() {
        sortDictionary();
        System.out.printf("%-15s %-20s %-15s%n", "No", "English", "Vietnamese");
        for(int i = 0; i < allWords.size(); i++) {
            System.out.printf("%-15d %-20s %-15s%n", (i + 1), allWords.get(i).word_target, allWords.get(i).word_explain);
        }
          }

    public void dictionaryBasic() {
        //insertFromCommandline();
        insertFromCommandline();
        Collections.sort(allWords);
        showAllWords();

    }
    public void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryExportToFile();
        dictionarySearcher();

    }


    public static void main(String[] args) {
        DictionaryCommanLine testDictionary = new DictionaryCommanLine();
        testDictionary.dictionaryAdvanced();
    }
}


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.*;
public class DictionaryManagement extends Dictionary {

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        while (size != 0) {
            String engWord = scanner.nextLine();
            String vieWord = scanner.nextLine();
            Word word = new Word(engWord, vieWord);
            if (!allWords.contains(word)) {
                allWords.add(word);
            }
            size--;
        }
    }


    public void sortDictionary() {
        Collections.sort(allWords);
    }

    public static void insertFromFile() {
        try {
            File file = new File("dictionaries.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line= reader.readLine()) != null) {
                String[] wordline = line.split("\\:", 2);
                if (wordline.length == 1) continue;
                Word word = new Word(wordline[1], wordline[0]);
                if (!allWords.contains(word)) {
                    allWords.add(word);
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    String dictionaryLookup(String word_target) {
        sortDictionary();
        String result ="";
        for (Word word: allWords) {
            if (word.getWord_target().equals(word_target)) {
                return word.getWord_explain();
            }
        }
//        int start = 0;
//        int end  = allWords.size() - 1;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            Word check = allWords.get(mid);
//            String current = check.getWord_target();
//            int res = current.compareTo(word_target);
//            if (res == 0) {
//                result = check.getWord_explain();
//                break;
//            } else if (res < 0) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        System.out.println(result);
        return result;
    }


    public void addWord() {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String[] wordLine = word.split(" ");
        Word newWord = new Word(wordLine[0], wordLine[1]);
        if (allWords.contains(newWord) == false) {
            allWords.add(newWord);
        }
    }

    public void deleteWord(String wordDelete) {
        for (int i = 0; i < allWords.size(); i++) {
            if (allWords.get(i).getWord_target().equals(wordDelete)) {
                allWords.remove(allWords.get(i));
            }
        }
    }

    public void dictionarySearcher() {
        ArrayList<Word> res = new ArrayList<Word>();
        Scanner sc = new Scanner(System.in);
        String wordSearch = sc.next();
        for (int i = 0; i < allWords.size(); i++) {
            if (allWords.get(i).getWord_target().startsWith(wordSearch) == true) {
                Word word = new Word (allWords.get(i).getWord_target(), allWords.get(i). getWord_explain());
                if (res.contains(word) != true) {
                    res.add(word);
                }
            }
        }
        Collections.sort(res);
        for ( int i = 0; i < res.size(); i++) {
            System.out.printf("%-15d %-20s %-15s%n", (i + 1), res.get(i).word_target, res.get(i).word_explain);

        }
    }


    public void dictionaryExportToFile() {

        try {
            FileOutputStream fo = new FileOutputStream("finaldictionary.txt");
            PrintWriter writer = new PrintWriter(fo);
            writer.printf("%-15s %-20s %-15s%n", "No", "English", "Vietnamese");
            for(int i = 0; i < allWords.size(); i++) {
                writer.printf("%-15d %-20s %-15s%n", (i + 1), allWords.get(i).word_target, allWords.get(i).word_explain);

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

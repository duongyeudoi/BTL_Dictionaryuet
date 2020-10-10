

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.util.ArrayList;

public class Controller extends SQLite {

    @FXML
    private Button searchButton;

    @FXML
    private TextField wordInput;

    @FXML
    private TextField addVie;

    @FXML
    private TextField addEng;

    @FXML
    private WebView wordMeaning;

    @FXML
    private Button addButton;


    @FXML
    private ListView<String> listWord;


    @FXML
    private ListView<String> historyList;
    @FXML
    private Button Viepronounce;


    @FXML
    private TextArea historyMean;

    @FXML
    private Button historyButton;

    @FXML
    private Button soundButton;

    @FXML
    private Button playingSound;


    @FXML
    private TextArea engEssay;

    @FXML
    private TextArea vieEssay;

    @FXML
    private Button translateButton;


    @FXML
    void handleSearch() {
        System.out.println(readSpecificRow(wordInput.getText()));
        wordMeaning.getEngine().loadContent(readSpecificRow(wordInput.getText()));
        historyList.getItems().add(wordInput.getText());
        wordInput.clear();
    }

    @FXML
    void addButtonClicked() {
        insert(addEng.getText(),addVie.getText());
        addEng.clear();
        addVie.clear();

    }
    @FXML
    void playSound(String text) {
       GoogleAPITextToSpeech play = new GoogleAPITextToSpeech(wordInput.getText());

    }

    @FXML
    void handleTranslate() {
        GoogleTranslateAPI newT = new GoogleTranslateAPI();
        vieEssay.setText(newT.translate(engEssay.getText()));

    }
    @FXML
    void playingSoundEssay() {
        GoogleAPITextToSpeech play = new GoogleAPITextToSpeech(engEssay.getText());

    }
    @FXML
    void playingSoundVie() {
        GoogleAPITextToSpeech play = new GoogleAPITextToSpeech(vieEssay.getText());

    }

    @FXML
    void showAllWord() {
        listWord.getItems().clear();
        ArrayList<String> result = SQLite.showWordList(wordInput.getText());
        for (String word: result) {
            listWord.getItems().add(word);
        }
    }

    @FXML
    void getChosenWord() {
        ObservableList observableList = listWord.getSelectionModel().getSelectedItems();
        wordInput.setText((String) observableList.get(0));
        handleSearch();
    }


}

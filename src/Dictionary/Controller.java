package Dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller extends DictionaryManagement {
    public Button searchButton;
    public Button addButton;
    public Button deleteButton;
    public ListView ListWord;
    public TextArea VieTranslate;
    public TextField wordInput;

    public void handleSearch() {
        VieTranslate.setText(dictionaryLookup(wordInput.getText()));
    }

}

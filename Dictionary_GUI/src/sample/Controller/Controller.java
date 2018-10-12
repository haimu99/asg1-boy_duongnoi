package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import  javafx.scene.control.TextField;
public class Controller  {

    @FXML
    private TextField Word;
    public void Search()
    {
        String word = Word.getText();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("the word is " + word);
        alert.show();
    }
    @FXML
    private TextArea listWord;
    public void list()
    {
        String list = listWord.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(list);
        alert.show();
    }

}

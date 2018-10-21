package sample.Dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.HTMLEditor;
import javafx.scene.control.TextArea;
import java.io.IOException;

public class ControllerAddWord extends ControllerGeneral {
    @FXML
    private TextArea Word;
    @FXML
    private HTMLEditor Explain;
    @FXML
    void add() {
        addWord(Word.getText(), Explain.getHtmlText());
        Word.setText("");
        Explain.setHtmlText("");
    }
    public void clickBackHome1(ActionEvent e) throws IOException
    {
        changeScene(e,"../Fxml/sample.fxml");
    }
}

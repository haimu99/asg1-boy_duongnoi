package sample.Dictionary;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import com.darkprograms.speech.translator.GoogleTranslate;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllerGoogleTranslate extends ControllerGeneral implements Initializable {
    @FXML
    private TextArea sourceText;

    @FXML
    private TextArea targetText;

    @FXML
    private ComboBox<String> SourceLanguage;

    @FXML
    private ComboBox<String> TargetLanguage;
    ObservableList<String> listSearch = FXCollections.observableArrayList("English", "Japanese", "Vietnamese","Chinese");
    ObservableList<String> listExplain = FXCollections.observableArrayList("English", "Japanese", "Vietnamese","Chinese");
    HashMap<String, String > LanguageCode = new HashMap<String, String>();
    //LangueCode
    private String SourceLanguageCode ;
    private String TargetLanguageCode ;
    @FXML
    void chooseSourceLanguage() throws IOException {
        SourceLanguageCode = LanguageCode.get(SourceLanguage.getValue());
        sourceText.setText(GoogleTranslate.translate(SourceLanguageCode,sourceText.getText()));
    }

    @FXML
    void chooseTargetLanguage() throws IOException {
        TargetLanguageCode = LanguageCode.get(TargetLanguage.getValue());
        targetText.setText(GoogleTranslate.translate(TargetLanguageCode,targetText.getText()));
    }
    @FXML
    void chooseSourceSpeech() {
        TextToSpeak.playSound(sourceText.getText());
    }

    @FXML
    void chooseTargetSpeech() {
        TextToSpeak.playSound(targetText.getText());
    }
    public void getSourceText()  {
        SourceLanguageCode = LanguageCode.get(SourceLanguage.getValue());
        TargetLanguageCode = LanguageCode.get(TargetLanguage.getValue());
            try{
                targetText.setText(GoogleTranslate.translate(LanguageCode.get(TargetLanguageCode),sourceText.getText()));
            }catch(IOException ex){
                ex.getStackTrace();
            }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        LanguageCode.put("English", "en");
        LanguageCode.put("Vietnamese", "vi");
        LanguageCode.put("Japanese", "ja");
        LanguageCode.put("Chinese", "zh");
        SourceLanguage.setValue("English");
        //TargetLanguage.setValue("Vietnamese");
        SourceLanguage.setItems(listSearch);
        TargetLanguage.setItems(listExplain);
    }

    public void clickBackHome(ActionEvent e) throws IOException
    {
        changeScene(e,"../Fxml/sample.fxml");
    }
}

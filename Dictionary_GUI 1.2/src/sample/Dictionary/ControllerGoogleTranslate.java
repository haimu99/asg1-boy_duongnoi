package sample.Dictionary;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGoogleTranslate extends ControllerGeneral implements Initializable {


    @FXML
    private ComboBox<String> searchLanguage;

    @FXML
    private ComboBox<String> explainLanguage;
    ObservableList<String> listSearch = FXCollections.observableArrayList("English", "Japanese", "Vietnam");
    ObservableList<String> listExplain = FXCollections.observableArrayList("English", "Japanese", "Vietnam");
    @FXML
    void choooseTargetLanguage(ActionEvent event) {

    }

    @FXML
    void chooseSearchLanguage(ActionEvent event) {

    }
    @Override
    public void initialize(URL lacation, ResourceBundle resources)
    {
        searchLanguage.setItems(listSearch);
        explainLanguage.setItems(listExplain);
    }

    public void clickBackHome(ActionEvent e) throws IOException
    {
        changeScene(e,"../Fxml/sample.fxml");
    }
}

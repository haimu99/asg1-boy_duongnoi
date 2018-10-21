package sample.Dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.Sql.ConnectionDatabase;
public class ControllerInterface extends ControllerGeneral implements Initializable {
    @FXML
   private ListView<String> listview;
    @FXML
   private WebEngine webEngine;
    @FXML
    private WebView webview;
    @FXML
    private  TextField search ;

    @FXML
    public void showListView(){
        try {
            Statement stm = connection.prepareStatement("select word from av");
            result = ((PreparedStatement) stm).executeQuery();
            while (result.next()) {

                observablelist.add( result.getString(1));
            }
        }catch ( SQLException ex) {
            Logger.getLogger(ControllerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        listview.setItems(observablelist);
    }
    @FXML
    public void filterWord(){
        listview.setItems(filteredData);
        search.textProperty().addListener((observableValue, oldValue, newValue) -> {  // To catch event When textfield changed
            filteredData.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {  // If textfield is empty
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.toLowerCase().startsWith(lowerCaseFilter)) { // filter with list
                    return true;
                }

                return false;
            });
            listview.setItems(filteredData);  // update listview after filtering
        });
    }

    @FXML

    public void getSelectedList() {

        listview.setOnMouseClicked(e -> {
            try {
                String query = "select * from av where word = ?";
                preparedStatement = ConnectionDatabase.getConnection().prepareStatement(query);
                preparedStatement.setString(1,(String)listview.getSelectionModel().getSelectedItem());
                result = preparedStatement.executeQuery();
                while(result.next()){
                    webEngine.loadContent(result.getString("html"));
                }
                preparedStatement.close();
                result.close();
            } catch ( SQLException ee) {
                System.out.println(ee.getMessage());
            }
        });
    }
    private void handleSelectEvent() {
        listview.setOnMouseClicked(e -> {
            getSelectedList();
        });

        listview.setOnKeyPressed(e -> {
            KeyCode keyCode = e.getCode();
            if (keyCode == KeyCode.ENTER) {// error
                getSelectedList();
            }
        });
    }
    //Speak
    public void TextToSpeak(){
        String Text = listview.getSelectionModel().getSelectedItem();
        TextToSpeak.playSound(Text);
    }
    public void clickEditWord(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Fxml/htmlEditor.fxml"));
        Parent SceneChange = loader.load();
        Scene scene = new Scene(SceneChange);

        ControllerEditor controllerEditor = loader.getController();
        if(listview.getSelectionModel().getSelectedItem() != null){
            controllerEditor.setWord(listview.getSelectionModel().getSelectedItem());
            stage.setScene(scene);
        }
        else{
            showAlert.AlertInfo("Please choose a word which you want to edit!!");
        }
    }
    @FXML
    void handleDeleteEvent() {
        deleteWord(listview, webEngine);
    }
    public void clickGoogleTranslate(ActionEvent e) throws IOException {
        changeScene(e,"../Fxml/GoogleTranslate.fxml");
    }
    public void clickAddWord(ActionEvent e) throws IOException {
        changeScene(e,"../Fxml/addWord.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webEngine = webview.getEngine();
        showListView();
        handleSelectEvent();    }

}

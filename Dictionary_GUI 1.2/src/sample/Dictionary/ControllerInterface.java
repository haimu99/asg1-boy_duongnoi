package sample.Dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.Sql.ConnectionDatabase;

public class ControllerInterface extends ControllerGeneral implements Initializable {
    @FXML
    ListView listview;
    @FXML
    ObservableList<String> obserlist = FXCollections.observableArrayList();
    @FXML
    FilteredList<String> filteredData = new FilteredList<>(obserlist, e -> true);
    @FXML
    TextField search ;

    @FXML
    private WebView webview;
    private WebEngine webEngine;
    private ResultSet result;
    private PreparedStatement preparedStatement = null;
    @FXML
    public void showListView(){
        try {
            Statement stm = ConnectionDatabase.getConnection().createStatement();
            result = stm.executeQuery("select word from av");
            while (result.next()) {

                obserlist.add( result.getString(1));
            }
        }catch ( SQLException ex) {
            Logger.getLogger(ControllerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        listview.setItems(obserlist);
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
    //    getSelectedList();
    }

}

package sample.Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.Sql.ConnectionDatabase;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerGeneral {

    @FXML
    ObservableList<String> observablelist = FXCollections.observableArrayList();
    @FXML
    FilteredList<String> filteredData = new FilteredList<>(observablelist, e -> true);
   protected ResultSet result;
   protected PreparedStatement preparedStatement = null;
   protected Connection connection = ConnectionDatabase.getConnection();
   protected void refreshDatabase() {
        String query = "SELECT word FROM av";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            observablelist.clear();
            while (result.next()) {
                observablelist.add(result.getString(1));
            }
            preparedStatement.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void deleteWord(ListView<String> listview, WebEngine webEngine){
        try {
            String selected = listview.getSelectionModel().getSelectedItem();
            System.out.println(selected);

            if (selected != null) {
                String query = "DELETE FROM av WHERE word=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, selected);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                result.close();

                refreshDatabase();
                webEngine.loadContent("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void addWord(String Word, String Explain){
        String existQuery = "SELECT word FROM av WHERE word=?";
        String query = "INSERT INTO av (word, html) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(existQuery);
            preparedStatement.setString(1, Word);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                showAlert.AlertInfo("This word has already existed in the database!");

            } else {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, Word);
                preparedStatement.setString(2, Explain);
                preparedStatement.execute();
                refreshDatabase();
                showAlert.AlertInfo("Successful!");
              //  System.out.println("Successful");
        }
            preparedStatement.close();
            result.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    protected void changeScene(ActionEvent e, String url) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        Parent SceneChange = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(SceneChange);
        stage.setScene(scene);
        stage.show();
    }
}

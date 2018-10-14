package sample.Dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerGeneral {
    protected void changeScene(ActionEvent e, String url) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        Parent SceneChange = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(SceneChange);
        stage.setScene(scene);
        stage.show();
    }
}

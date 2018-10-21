package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.Sql.ConnectionDatabase;

import java.sql.Connection;

public class Main extends Application {
    Connection con;
    public static void main(String[] args) { launch(args);    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("/sample/images/icon_Dictionary.png"));
        primaryStage.setTitle("Hx2_Dictionary");
        CheckConnection();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    void CheckConnection()
    {
        con = ConnectionDatabase.getConnection();
        if (con != null) System.out.println("success");
        else System.out.println("not success");
    }

}


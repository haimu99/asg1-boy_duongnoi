package sample.Dictionary;

import javafx.scene.control.Alert;

public class showAlert {
    public static void AlertInfo(String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(info);
        alert.setTitle("Information");
        alert.show();
    }
}

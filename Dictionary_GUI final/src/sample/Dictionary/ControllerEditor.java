package sample.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;
import java.sql.SQLException;
import java.io.IOException;
public class ControllerEditor extends ControllerGeneral{
    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private TextArea Word;
    private int id;
    public void setWord(String word){
        Word.setText(word);
        String query = "SELECT id,html FROM av WHERE word = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,word);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                htmlEditor.setHtmlText(result.getString(2));
                id = Integer.parseInt(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void updateWord(ActionEvent e) throws IOException {
        String word = Word.getText();
        String html = htmlEditor.getHtmlText();
        String query = "UPDATE av SET word = ? , html = ? WHERE id = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,word);
            preparedStatement.setString(2,html);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        refreshDatabase();
        showAlert.AlertInfo("Your word has been edited!");
        changeScene(e, "../Fxml/sample.fxml");
    }
    @FXML
    void cancel(ActionEvent e) throws IOException {
        changeScene(e, "../Fxml/sample.fxml");
    }

}

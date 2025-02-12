package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.input.KeyEvent;

public class loginController extends commonController{
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;
    @FXML
    private Label LoadingLabel;
    @FXML
    private void loginAction(ActionEvent event)  {
        if (validasi() == true) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage)  source.getScene().getWindow();
            stage.close();
            changeScene("home.fxml");
        } else {
            errorLabel.setVisible(true);
        }
    }
    
    @FXML
    private void toRegister(javafx.scene.input.MouseEvent event)  {
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();
        changeScene("register.fxml");
    }
    
    private boolean validasi() {
    boolean key = false;
    String username = usernameField.getText();
    String password = passwordField.getText();

    dataController DB = new dataController();
    DB.config();

    con = DB.conn;
    stat = DB.stmt;

    if (con == null) {
        System.out.println("Koneksi ke database gagal!");
        return false;
    }

    try {
        String sql = "SELECT * FROM admin WHERE username=? AND password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            key = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        DB.closeConnection(); // Tutup koneksi setelah selesai
    }
    return key;
}
    
    private void changeScene(String page) {
        try {     
            FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);


            root.setOnMousePressed(event -> {
                x = event.getX();
                y = event.getY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.show();
        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }
}

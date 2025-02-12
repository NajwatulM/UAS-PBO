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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.input.KeyEvent;

public class registerController extends commonController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;
   
    @FXML
    private void registerAction(ActionEvent event) {
        if (validasi()) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            changeScene("login.fxml");
        }
    }
    
    @FXML
    private void toLogin(javafx.scene.input.MouseEvent event)  {
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();
        changeScene("login.fxml");
    }

    private boolean validasi() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Username dan password tidak boleh kosong!");
            errorLabel.setVisible(true);
            return false;
        }

        dataController DB = new dataController();
        DB.config();

        Connection conn = DB.conn;
        if (conn == null) {
            errorLabel.setText("Koneksi ke database gagal!");
            errorLabel.setVisible(true);
            return false;
        }

        try {
            // Cek apakah username sudah ada
            String checkUsernameQuery = "SELECT * FROM admin WHERE username=?";
            PreparedStatement checkPs = conn.prepareStatement(checkUsernameQuery);
            checkPs.setString(1, username);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                errorLabel.setText("Username sudah terdaftar!");
                errorLabel.setVisible(true);
                return false;
            }

            // Jika belum ada, masukkan ke database
            String insertQuery = "INSERT INTO admin (username, password) VALUES (?, ?)";
            PreparedStatement insertPs = conn.prepareStatement(insertQuery);
            insertPs.setString(1, username);
            insertPs.setString(2, password);
            insertPs.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Terjadi kesalahan saat registrasi!");
            errorLabel.setVisible(true);
            return false;
        } finally {
            DB.closeConnection();
        }
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
            System.out.println("Error saat mengganti scene: " + e.getMessage());
        }
    }
}


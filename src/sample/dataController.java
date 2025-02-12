package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class dataController extends commonController implements Initializable {

    public int key;
    public String p_nama, p_jumlahKursi;
    public String text;
    public int last_key;
    public int last_data;
    public int[] save_data = null;

    // MySQL
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    // MySQL Config (gunakan driver terbaru!)
    public final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final String DB_URL = "jdbc:mysql://localhost:3306/hello_cinema?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    public final String USER = "root";
    public final String PASS = "";

    // Konfigurasi Koneksi
    public void config() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Koneksi Berhasil!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Ke Database Gagal: " + e.getMessage());
            conn = null;  // Pastikan conn diset null jika gagal
        }
    }

    // Menutup Koneksi
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
            System.out.println("Koneksi Ditutup!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    // Setter
    public int setKey(int key) {
        return this.key = key;
    }

    public void setText(String t) {
        text = t;
    }

    public void setData(String nama, String jumlah_kursi) {
        p_nama = nama;
        p_jumlahKursi = jumlah_kursi;
    }
}

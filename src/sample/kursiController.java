/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Scanner;
/**
 *
 * @author GL522VXK
 */
public class kursiController extends pesanController implements Initializable{
    
    @FXML
    private ImageView a1,a2,a3,a4,a5,a6,a7,a8,a9;
    @FXML
    private ImageView b1,b2,b3,b4,b5,b6,b7,b8,b9;
    @FXML
    private ImageView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    @FXML
    private ImageView d1,d2,d3,d4,d5,d6,d7,d8,d9;
    @FXML
    private ImageView e1,e2,e3,e4,e5,e6,e7,e8,e9;
    @FXML
    private Label count_seat,data_kursi;
    
    int x = 0;
    public String a[] = new String[45];
    public int jumlah = 0;
//    public String a_save[] = new String[jumlah];
//    public int xz = 0;

    
    boolean a1_stat = false,a2_stat = false ,a3_stat = false,a4_stat = false,a5_stat = false,a6_stat = false,a7_stat = false,a8_stat = false,a9_stat = false;
    boolean b1_stat = false,b2_stat = false,b3_stat = false,b4_stat = false,b5_stat = false,b6_stat = false,b7_stat = false,b8_stat = false,b9_stat = false;
    boolean c1_stat = false,c2_stat = false,c3_stat = false,c4_stat = false,c5_stat = false,c6_stat = false,c7_stat = false,c8_stat = false,c9_stat = false;
    boolean d1_stat = false,d2_stat = false,d3_stat = false,d4_stat = false,d5_stat = false,d6_stat = false,d7_stat = false,d8_stat = false,d9_stat = false;
    boolean e1_stat = false,e2_stat = false,e3_stat = false,e4_stat = false,e5_stat = false,e6_stat = false,e7_stat = false,e8_stat = false,e9_stat = false;
    
    String seat_true = "..\\img\\chairRed.png";
    String seat_false = "..\\img\\chairBlack.png";
    
    @Override
    public void sendData(int a) {
        setKey(a);
        int kursi = 0;
        try {
        dataController DB = new dataController();
        DB.config();
        
        con = DB.conn;
        stat = DB.stmt;
        
        
        sql = "SELECT * FROM data where id = "+key+"";
        rs = stat.executeQuery(sql);
        
        while (rs.next()) {
            kursi  = rs.getInt("f_seat");
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void savedata(int jumlah) {   
//       do{
//            a_save[xz] = a[xz];
//            xz++;
//        }while(xz < jumlah);
//       System.out.println("Savedata : "+Arrays.toString(a_save));
    }
    
    @FXML
    private void finishAction(ActionEvent event) {
        Node source1 = (Node) event.getSource();
        Stage stage1 = (Stage)  source1.getScene().getWindow();
        stage1.close();
        changeScene();
        System.out.println(Arrays.toString(a));
        System.out.println("Jumlah : " + jumlah);
        
    }
    
    private boolean clicked(boolean stat, ImageView iv, String label){
        if(stat == false){
            iv.setImage(new Image(String.valueOf(this.getClass().getResource(seat_true))));  
            a[x] = label;
            x += 1;
            jumlah += 1;
            return true;
        }else{
            iv.setImage(new Image(String.valueOf(this.getClass().getResource(seat_false))));
            jumlah -= 1;
            return false;
        }
    }
    
    @FXML
    private void a1Action(ActionEvent event) {
        clicked(a1_stat, a1, "a1");
    }
    
    @FXML
    private void a2Action(ActionEvent event) {
        clicked(a2_stat, a2, "a2");
    }
    
    @FXML
    private void a3Action(ActionEvent event) {
        clicked(a3_stat, a3, "a3");
    }
    
    @FXML
    private void a4Action(ActionEvent event) {
        clicked(a4_stat, a4, "a4");
    }
    
    @FXML
    private void a5Action(ActionEvent event) {
        clicked(a5_stat, a5, "a5");
    }
    
    @FXML
    private void a6Action(ActionEvent event) {
        clicked(a6_stat, a6, "a6");
    }
    
    @FXML
    private void a7Action(ActionEvent event) {
        clicked(a7_stat, a7, "a7");
    }
    
    @FXML
    private void a8Action(ActionEvent event) {
        clicked(a8_stat, a8, "a8");
    }
    
    @FXML
    private void a9Action(ActionEvent event) {
        clicked(a9_stat, a9, "a9");
    }
    
    @FXML
    private void b1Action(ActionEvent event) {
        clicked(b1_stat, b1, "b1");
    }
    
    @FXML
    private void b2Action(ActionEvent event) {
        clicked(b2_stat, b2, "b2");
    }
    
    @FXML
    private void b3Action(ActionEvent event) {
        clicked(b3_stat, b3, "b3");
    }
    
    @FXML
    private void b4Action(ActionEvent event) {
        clicked(b4_stat, b4, "b4");
    }
    
    @FXML
    private void b5Action(ActionEvent event) {
        clicked(b5_stat, b5, "b5");
    }
    
    @FXML
    private void b6Action(ActionEvent event) {
        clicked(b6_stat, b6, "b6");
    }
    
    @FXML
    private void b7Action(ActionEvent event) {
        clicked(b7_stat, b7, "b7");
    }
    
    @FXML
    private void b8Action(ActionEvent event) {
        clicked(b8_stat, b8, "b8");
    }
    
    @FXML
    private void b9Action(ActionEvent event) {
        clicked(b9_stat, b9, "b9");
    }
    
    @FXML
    private void c1Action(ActionEvent event) {
        clicked(c1_stat, c1, "c1");
    }
    
    @FXML
    private void c2Action(ActionEvent event) {
        clicked(c2_stat, c2, "c2");
    }
    
    @FXML
    private void c3Action(ActionEvent event) {
        clicked(c3_stat, c3, "c3");
    }
    @FXML
private void c4Action(ActionEvent event) {
    clicked(c4_stat, c4, "c4");
}

@FXML
private void c5Action(ActionEvent event) {
    clicked(c5_stat, c5, "c5");
}

@FXML
private void c6Action(ActionEvent event) {
    clicked(c6_stat, c6, "c6");
}

@FXML
private void c7Action(ActionEvent event) {
    clicked(c7_stat, c7, "c7");
}

@FXML
private void c8Action(ActionEvent event) {
    clicked(c8_stat, c8, "c8");
}

@FXML
private void c9Action(ActionEvent event) {
    clicked(c9_stat, c9, "c9");
}

@FXML
private void d1Action(ActionEvent event) {
    clicked(d1_stat, d1, "d1");
}

@FXML
private void d2Action(ActionEvent event) {
    clicked(d2_stat, d2, "d2");
}

@FXML
private void d3Action(ActionEvent event) {
    clicked(d3_stat, d3, "d3");
}

@FXML
private void d4Action(ActionEvent event) {
    clicked(d4_stat, d4, "d4");
}

@FXML
private void d5Action(ActionEvent event) {
    clicked(d5_stat, d5, "d5");
}

@FXML
private void d6Action(ActionEvent event) {
    clicked(d6_stat, d6, "d6");
}

@FXML
private void d7Action(ActionEvent event) {
    clicked(d7_stat, d7, "d7");
}

@FXML
private void d8Action(ActionEvent event) {
    clicked(d8_stat, d8, "d8");
}

@FXML
private void d9Action(ActionEvent event) {
    clicked(d9_stat, d9, "d9");
}

@FXML
private void e1Action(ActionEvent event) {
    clicked(e1_stat, e1, "e1");
}

@FXML
private void e2Action(ActionEvent event) {
    clicked(e2_stat, e2, "e2");
}

@FXML
private void e3Action(ActionEvent event) {
    clicked(e3_stat, e3, "e3");
}

@FXML
private void e4Action(ActionEvent event) {
    clicked(e4_stat, e4, "e4");
}

@FXML
private void e5Action(ActionEvent event) {
    clicked(e5_stat, e5, "e5");
}

@FXML
private void e6Action(ActionEvent event) {
    clicked(e6_stat, e6, "e6");
}

@FXML
private void e7Action(ActionEvent event) {
    clicked(e7_stat, e7, "e7");
}

@FXML
private void e8Action(ActionEvent event) {
    clicked(e8_stat, e8, "e8");
}

@FXML
private void e9Action(ActionEvent event) {
    clicked(e9_stat, e9, "e9");
}

    
    public void showData(){
//        data_kursi.setText(Arrays.toString(a));
    }
    
    public void showJumlah(){
//        count_seat.setText(String.valueOf(jumlah));
    }
    
    private void changeScene() {
        try {
            savedata(jumlah);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pesan.fxml"));
            Parent root = loader.load();
            pesanController scnd = loader.getController();
//          Pass whatever data you want. You can have multiple method calls here
            scnd.SendseatData(jumlah,key,a);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);

            root.setOnMousePressed(event -> {
                x = (int) event.getX();
                y = event.getY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.show();
        } catch (IOException e) {
            System.out.println("error saat change stages kursi");
            e.printStackTrace();
        }
    }
}

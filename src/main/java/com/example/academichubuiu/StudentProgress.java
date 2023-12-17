package com.example.academichubuiu;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.academichubuiu.Marks.marksarray;

public class StudentProgress implements Initializable {

    @FXML
    private PieChart ChartPie;

    @FXML
    private Button btnAdd;

    @FXML
    private TextArea taChartDataDisplay;

    @FXML
    private TextField txtmarks;

    @FXML
    private TextField txtname;

    public StudentProgress() {
    }


    @FXML
    void OnAdd(ActionEvent event) {

        String name = txtname.getText();
        double marks = new Integer(txtmarks.getText()).doubleValue();
        String id=txtmarks.getText();

        int ct=Marks.ctmarkcount(name,id);
        System.out.println(ct);


        int assignment=0;
        int mid=0;
        int Final=0;
        for (int i = 0; i < marksarray.size(); i++) {
int ass1 = 0,ass2=0;
            if (name.equalsIgnoreCase(marksarray.get(i).getCoursecode()) && id.equals(marksarray.get(i).getStudentid())) {
                try {

                 ass1=Integer.parseInt(marksarray.get(i).getAssignment1());
                 ass2=Integer.parseInt(marksarray.get(i).getAssignment1());
                    mid=Integer.parseInt(marksarray.get(i).getMid());
                    Final=Integer.parseInt(marksarray.get(i).getFinal());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format");
                }

                assignment=ass1+ass2;

            }

        }

        System.out.println("ct:"+ct+"ass"+assignment+"mid"+mid+"final"+Final);
for(int i=0;i<4;i++) {
    String st[]=new String[4];
    st[0]="Class Test";
    st[1]="Assignment";
    st[2]="Mid";
    st[3]="Final";
    int arr[]=new int[4];
    arr[0]=ct;
    arr[1]=assignment;
    arr[2]=mid;
    arr[3]=Final;

    PieChart.Data data = new PieChart.Data(st[i], arr[i]);
    ChartData.add(data);
    ChartPie.setData(ChartData);

    taChartDataDisplay.appendText(st[i] + "\nMarks: " + arr[i] + "\n");


}
    }

    @FXML
    private ImageView myImage;
    @FXML
    private ImageView bookImage;

    ObservableList<PieChart.Data> ChartData = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChartData = FXCollections.observableArrayList();
        ChartPie.setTitle("Student Progress");


        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(6000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.play();

        FadeTransition fade = new FadeTransition();
        fade.setNode(bookImage);
        fade.setDuration(Duration.millis(5000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }




    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;


    public void gotoThome(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teacher.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
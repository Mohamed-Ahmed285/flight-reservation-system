package group.proj;

import group.proj.Air_port.FlightsManager;
import group.proj.User.Passenger;
import group.proj.User.UserFileManger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {


    private FXMLLoader fxmlLoader;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private UserFileManger userManager;
    private FlightsManager flightsManager;
    private Passenger Currentuser;
    @FXML
    private TextField email_field;

    @FXML
    private TextField name_filed;
    @FXML
    private PasswordField pass_field;
    @FXML
    private TextField phone_field;



    public void setUserManager(UserFileManger userManager , Passenger CurrentUser) {
        this.userManager = userManager;
        this.Currentuser=CurrentUser;
    }
    public void setFlightsManager(FlightsManager flightsManager) {
        this.flightsManager = flightsManager;
    }
    public void to_menu(ActionEvent event) throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        root = fxmlLoader.load();
        UserMenuController controller = fxmlLoader.getController();
        controller.setUserManager(userManager,Currentuser);
        controller.setFlightsManager(flightsManager);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1200 , 620);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater( () -> {

            name_filed.setText(Currentuser.getUsername());
            pass_field.setText(Currentuser.getPassword());
            email_field.setText(Currentuser.getEmail());
            phone_field.setText(Currentuser.getPhone());

        });
    }
}

package View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterPage extends Stage{
    // finalليش عملناهم ?
    // عشان الإنترفيس او الواجهة بنفعش حد يجي يغير على العناصر المعينة لكن مؤشر هو بنفع تغير على محتوى العنصر لكن العنصر نفسو ما بتقدر تغيرو
    // global scopeوليش حطيناهم في ال?
    // بس للتذكير ليس إلاinstance variablesعشان اقدر اوصل الهم من اي كلاس اخر وفي هذا المكان اسمهم بكون 
    final CheckBox darkModeCheckBox; 
    
    final Label usernameLabel;
    final TextField usernameTF;
    
    final Label passwordLabel;
    final PasswordField passwordTF;
    final Label passwordConfirmLabel;
    final PasswordField passwordConfirmTF;
    
    final Label emailLabel;
    final TextField emailTF;
    
    final Label groupLabel;
    final ToggleGroup genderGroup;
    final RadioButton maleRadioBtn;
    final RadioButton femaleRadioBtn;
    
    final Button registerBtn;
    final Label statusLabel;
    final GridPane grid;
    
    final Label stackPaneLabel;
    final StackPane stackPane;
    final HBox containerHBox;
    
    
    public RegisterPage(){
        darkModeCheckBox = new CheckBox("Dark Mode");
        
        usernameLabel = new Label("User Name: ");
        usernameTF = new TextField();
        
        passwordLabel = new Label("Password: ");
        passwordTF = new PasswordField();
        
        passwordConfirmLabel = new Label("Conrirm Password: ");
        passwordConfirmTF = new PasswordField();
        
        emailLabel = new Label("Email: ");
        emailTF = new TextField();
        
        groupLabel = new Label("Gender: ");
        genderGroup = new ToggleGroup();
        maleRadioBtn = new RadioButton("Male");
        maleRadioBtn.setToggleGroup(genderGroup);
        maleRadioBtn.setUserData("male");
        femaleRadioBtn = new RadioButton("Female");
        femaleRadioBtn.setToggleGroup(genderGroup);
        femaleRadioBtn.setUserData("female");
        HBox genderHBox = new HBox(10, maleRadioBtn, femaleRadioBtn);
        
        statusLabel = new Label("");
        statusLabel.getStyleClass().add("statusLabel");
        
        registerBtn = new Button("Register");
        registerBtn.setCursor(Cursor.HAND);
        
        grid = new GridPane();
        grid.setVgap(30);
        grid.setHgap(20);
        grid.add(darkModeCheckBox, 0, 0);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameTF, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordTF, 1, 2);
        grid.add(passwordConfirmLabel, 0, 3);
        grid.add(passwordConfirmTF, 1, 3);
        grid.add(emailLabel, 0, 4);
        grid.add(emailTF, 1, 4);
        grid.add(groupLabel, 0, 5);
        grid.add(genderHBox, 1, 5);
        grid.add(registerBtn, 1, 6, 2, 2);
        grid.add(statusLabel, 1, 7, 2, 2);
        grid.setAlignment(Pos.CENTER);
        stackPaneLabel = new Label("Sign Up\nplease enter your info");
        stackPane = new StackPane(stackPaneLabel);
        containerHBox = new HBox(50, stackPane, grid);
        
        
        darkModeCheckBox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(containerHBox.getStyleClass().isEmpty())
                    containerHBox.getStyleClass().add("darkMode");
                else
                    containerHBox.getStyleClass().clear();
            }
        });
        
        registerBtn.setOnAction(event -> {
            try{
                ViewManager.openAdminPage();
                ViewManager.closeRegisterPage();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            /*
            if(usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty() || passwordConfirmTF.getText().isEmpty()
                    || emailTF.getText().isEmpty() || genderGroup.getSelectedToggle() == null){
                statusLabel.setText("Please, make sure to fill all fields.");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
            else if(!passwordTF.getText().equals(passwordConfirmTF.getText())){
                statusLabel.setText("Confirm Password is different!");
                statusLabel.setStyle("-fx-text-fill: red;");                
            }
            else if(!emailTF.getText().contains("@")){
                statusLabel.setText("E-mail address must has '@'");
                statusLabel.setStyle("-fx-text-fill: red;");
            }
            else{
                statusLabel.setText("Registration has been successfully");
                statusLabel.setStyle("-fx-text-fill: green;");
                // Creating A 'userInfo.txt' File
                File f = new File(System.getProperty("user.dir") + "/src/Model/userInfo.txt");
                try{
                    if(f.createNewFile())
                        System.out.println("File created: " + f.getName() + " Successfully.");
                    else
                        System.out.println("File already exists.");
                }
                catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                // Writing To The File
                try{
                    FileWriter fWriter = new FileWriter(f);
                    fWriter.write(usernameTF.getText() + "," + passwordTF.getText() + "," + emailTF.getText()
                            + "," + genderGroup.getSelectedToggle().getUserData().toString());
                    fWriter.close();
                }
                catch(IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                
                try {
                    //  AnotherTestView testView = new AnotherTestView();
                    ViewManager.openAdminPage();
                    
                } catch (IOException ex) {
                    Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            */
        });
        
        
        registerBtn.getStyleClass().add("btn");
        stackPane.getStyleClass().add("stackPane");
        
        StackPane root = new StackPane(containerHBox);
        
        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add("css/styles.css");
        
        this.setTitle("Registration Screen");
        this.setScene(scene);
        this.setResizable(false); // to make user don't able to resize the stage
//        this.show();
    }
    
}
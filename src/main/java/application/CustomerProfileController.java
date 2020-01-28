/**
 * Sample Skeleton for 'CustomerProfile.fxml' Controller Class
 */

package src.main.java.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;





public class CustomerProfileController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Myorders"
    private Button Myorders; // Value injected by FXMLLoader

    @FXML // fx:id="filling_a_complaint"
    private Button filling_a_complaint; // Value injected by FXMLLoader

    @FXML // fx:id="Change_pass"
    private Button Change_pass; // Value injected by FXMLLoader

    @FXML // fx:id="email"
    private TextField email; // Value injected by FXMLLoader

    @FXML // fx:id="ID"
    private TextField ID; // Value injected by FXMLLoader

    @FXML // fx:id="refund"
    private TextField refund; // Value injected by FXMLLoader

    @FXML // fx:id="phone"
    private TextField phone; // Value injected by FXMLLoader

    @FXML // fx:id="back"
    private Button back; // Value injected by FXMLLoader

    @FXML // fx:id="SaveChanges"
    private Button SaveChanges; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private TextField password; // Value injected by FXMLLoader

    @FXML // fx:id="Name"
    private TextField Name; // Value injected by FXMLLoader

    @FXML // fx:id="Visa_number"
    private TextField Visa_number; // Value injected by FXMLLoader

    @FXML // fx:id="CVV"
    private TextField CVV; // Value injected by FXMLLoader

    @FXML // fx:id="Date"
    private TextField Date; // Value injected by FXMLLoader

    String MyEmail = null;
    public void SeTEmail(String theEmail) {
		// TODO Auto-generated method stub
		MyEmail = theEmail;
	}
    public void setInfo(String[] text) {
    	ID.setText(text[0]);
    	Name.setText(text[1]);
    	phone.setText(text[2]);
    	email.setText(text[3]);
    	password.setText(text[4]);
    	Visa_number.setText(text[5]);
    	CVV.setText(text[6]);
       	Date.setText(text[7]);
    	refund.setText(text[8]);
    }
	@FXML
	void Backtocatalog(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		HomePage user = loader.getController();
//		Image im = new Image("images/background.jpg");info to hala
//		user.setimage(im);
//		user.set(MyEmail);
		Scene regist = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(regist);
		app_stage.show();
	}
	@FXML
	void CVVEdit(ActionEvent event) {
		String cvv = CVV.getText();
		if (cvv.length() != 3 || (!cvv.matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(null, "Please enter correct cvv number ");
		} else {
			CVV.setText(cvv);
			String message = "Edit#" + "CVV#" + MyEmail + "#" + cvv;
			Connect.client.handleMessageFromClientUI(message);
			if ("Editing Done".equals(Connect.client.servermsg))
				JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
			else if ("Editing Failed!".equals(Connect.client.servermsg)) {
				JOptionPane.showMessageDialog(null, "Editing Failed! ");
			}
		}
	}
	@FXML
	void EmailEdit(ActionEvent event) {
		String newEmail = email.getText();
		if (!(newEmail.contains("@hotmail.com")) && !(newEmail.contains("@gmail.com"))) {
			JOptionPane.showMessageDialog(null, "Please enter correct mail ");
		} else {
			email.setText(newEmail);

			String message = "Edit#" + "Email#" + MyEmail + "#" + newEmail;
			MyEmail = newEmail;
			Connect.client.handleMessageFromClientUI(message);
			if ("Editing Done".equals(Connect.client.servermsg))
				JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
			else if ("Editing Failed!".equals(Connect.client.servermsg)) {
				JOptionPane.showMessageDialog(null, "Editing Failed! ");
			}
		}

	}
	@FXML
	void NameEdit(ActionEvent event) {
		String name = Name.getText();
		Name.setText(name);
		String message = "Edit#" + "Name#" + MyEmail + "#" + name;
		Connect.client.handleMessageFromClientUI(message);
		if ("Editing Done".equals(Connect.client.servermsg))
			JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
		else if ("Editing Failed!".equals(Connect.client.servermsg)) {
			JOptionPane.showMessageDialog(null, "Editing Failed! ");
		}
	}
	
	@FXML
	void IDEdit(ActionEvent event) {
		String id = ID.getText();
		if (id.length() != 9 || (!id.matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(null, "Please enter correct id ");
		} else {
			ID.setText(id);
			String message = "Edit#" + "ID#" + MyEmail + "#" + id;
			Connect.client.handleMessageFromClientUI(message);
			if ("Editing Done".equals(Connect.client.servermsg))
				JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
			else if ("Editing Failed!".equals(Connect.client.servermsg)) {
				JOptionPane.showMessageDialog(null, "Editing Failed! ");
			}
		}
	}
	
	@FXML
	void PassEdit(ActionEvent event) {
		String pass = password.getText();

		password.setText(pass);
		String message = "Edit#" + "password#" + MyEmail + "#" + pass;
		Connect.client.handleMessageFromClientUI(message);
		if ("Editing Done".equals(Connect.client.servermsg))
			JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
		else if ("Editing Failed!".equals(Connect.client.servermsg)) {
			JOptionPane.showMessageDialog(null, "Editing Failed! ");
		}
	}
	
	@FXML
	void PhoneEdit(ActionEvent event) {
		String tel = phone.getText();
		if (tel.length() != 10 || !(tel.matches("(05[0-9]+)"))) {
			JOptionPane.showMessageDialog(null, "Please enter correct phone number ");
		} else {
			phone.setText(tel);
			String message = "Edit#" + "Tel#" + MyEmail + "#" + tel;
			Connect.client.handleMessageFromClientUI(message);
			if ("Editing Done".equals(Connect.client.servermsg))
				JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
			else if ("Editing Failed!".equals(Connect.client.servermsg)) {
				JOptionPane.showMessageDialog(null, "Editing Failed! ");
			}
		}

	}
	@FXML
	void DateEdit(ActionEvent event) {
		String date = Date.getText();
		if (date.length() != 5 || (!date.matches("(1[0-2]|0[1-9])/(2[0-9])"))) {
			JOptionPane.showMessageDialog(null, "Please enter correct date number ");
		} else {
			Date.setText(date);
			String message = "Edit#" + "VisaDate#" + MyEmail + "#" + date;
			Connect.client.handleMessageFromClientUI(message);
			if ("Editing Done".equals(Connect.client.servermsg))
				JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
			else if ("Editing Failed!".equals(Connect.client.servermsg)) {
				JOptionPane.showMessageDialog(null, "Editing Failed! ");
			}
		}

	}

	@FXML
	void VisaEdit(ActionEvent event) {
		String Visa = Visa_number.getText();
		if (Visa.length() != 16 || (!Visa.matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(null, "Please enter correct visa number ");
		} else {
			Visa_number.setText(Visa);
			String message = "Edit#" + "VisaNum#" + MyEmail + "#" + Visa;
			Connect.client.handleMessageFromClientUI(message);
			if ("Editing Done".equals(Connect.client.servermsg))
				JOptionPane.showMessageDialog(null, "Editing Done Successfully ");
			else if ("Editing Failed!".equals(Connect.client.servermsg)) {
				JOptionPane.showMessageDialog(null, "Editing Failed! ");
			}
		}

	}
	
	@FXML
	void Myorders(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("OrdersList.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		OrdersList user = loader.getController();
//		Image im = new Image("images/background.jpg");to hala
//		user.setimage(im);
//		user.set(MyEmail);
		Scene regist = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(regist);
		app_stage.show();
	}

	@FXML
	void filling_a_complaint(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Complaints.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		Complaints user = loader.getController();
//		Image im = new Image("images/background.jpg");to manar
//		user.setimage(im);
//		user.set(MyEmail);
		Scene regist = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(regist);
		app_stage.show();
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}

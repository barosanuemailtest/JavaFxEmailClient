package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.model.EmailMessage;
import com.barosanu.model.EmailTreeItem;
import com.barosanu.model.FormatableInteger;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private TreeView<String> folders;

    @FXML
    private TableView<EmailMessage> emailTableView;

    @FXML
    private TableColumn<EmailMessage, String> subjectCol;

    @FXML
    private TableColumn<EmailMessage, String> senderCol;

    @FXML
    private TableColumn<EmailMessage, String> recipientCol;

    @FXML
    private TableColumn<EmailMessage, FormatableInteger> sizeCol;

    @FXML
    private TableColumn<EmailMessage, Date> dateCol;

    public MainWindowController(ViewFactory viewFactory, EmailManager emailManager, String fxmlName) {
        super(viewFactory, emailManager, fxmlName);
    }

    @FXML
    void onOptionsClick() {
        this.viewFactory.showOptionsWindow();
    }

    @FXML
    void addAccountClick() {
        this.viewFactory.showLoginWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpFoldersView();
        setUpFolderSelection();
        setUpEmailsList();
    }

    private void setUpFoldersView(){
        folders.setRoot(emailManager.getFoldersRoot());
        folders.setShowRoot(false);
    }

    private void setUpEmailsList(){
        subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("subject"));
        senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("sender"));
        recipientCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("recipient"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, FormatableInteger>("size"));
        dateCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, Date>("date"));
    }

    private void setUpFolderSelection(){
        folders.setOnMouseClicked(e -> {
            EmailTreeItem<String> item = (EmailTreeItem<String>)folders.getSelectionModel().getSelectedItem();
            if(item != null) {
                emailTableView.setItems(item.getEmails());
            }
        });
    }
}

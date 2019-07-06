package com.barosanu;

import com.barosanu.controller.services.ServiceManager;
import com.barosanu.model.EmailAccount;
import com.barosanu.model.EmailTreeItem;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.FontSize;


public class EmailManager {

    private ServiceManager serviceManager;

    public EmailManager(){
        this(new ServiceManager());
    }
    public EmailManager(ServiceManager serviceManager){
        this.serviceManager = serviceManager;
    }

    //Themes handling:
    public ColorTheme getTheme() {
        return theme;
    }

    public void setTheme(ColorTheme theme) {
        this.theme = theme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    private ColorTheme theme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    //Folders handling:
    private EmailTreeItem<String> foldersRoot= new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> emailTreeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        emailTreeItem.setExpanded(true);
        foldersRoot.getChildren().add(emailTreeItem);
        serviceManager.submitFetchFoldersJob(emailAccount.getStore(), emailTreeItem);
    }

    // Selection model handling:
    private EmailTreeItem<String> selectedFolder;

    public EmailTreeItem<String> getSelectedFolder() {
        return selectedFolder;
    }

    public void setSelectedFolder(EmailTreeItem<String> selectedFolder) {
        this.selectedFolder = selectedFolder;
    }
}

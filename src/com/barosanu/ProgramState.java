package com.barosanu;

import com.barosanu.view.ViewFactory;

public class ProgramState {

    private PersistenceAccess persistenceAccess;
    private EmailManager emailManager;
    private ViewFactory viewFactory;

    public ProgramState(PersistenceAccess persistenceAccess, EmailManager emailManager) {
        this.persistenceAccess = persistenceAccess;
        this.emailManager = emailManager;
        this.viewFactory = new ViewFactory(emailManager);

    }

    public ProgramState() {
        this(new PersistenceAccess(), new EmailManager());
    }

    public void init() {
        this.checkPersistence();
    }

    private void checkPersistence() {
        if (this.persistenceAccess.loadFromPersistence() != null) {
            //TODO : load stuff
            showMainScreen();
        } else {
            showLoginWindow();
        }
    }

    private void showLoginWindow() {
        this.viewFactory.showLoginWindow();
    }

    private void showMainScreen() {
        this.viewFactory.showMainWindow();
    }


}

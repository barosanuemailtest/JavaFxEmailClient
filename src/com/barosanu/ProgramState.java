package com.barosanu;

import com.barosanu.view.ViewFactory;

public class ProgramState {

    private PersistenceAccess persistenceAccess;
    private ViewFactory viewFactory;

    public ProgramState(PersistenceAccess persistenceAccess, ViewFactory viewFactory) {
        this.persistenceAccess = persistenceAccess;
        this.viewFactory = viewFactory;
    }

    public ProgramState() {
        this(new PersistenceAccess(), new ViewFactory(new EmailManager()));
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

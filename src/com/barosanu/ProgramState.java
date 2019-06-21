package com.barosanu;

import com.barosanu.view.ViewFactory;

public class ProgramState {

    private PersistenceAccess persistenceAccess;
    private ModelAccess modelAccess;
    private ViewFactory viewFactory;

    public ProgramState(PersistenceAccess persistenceAccess, ModelAccess modelAccess) {
        this.persistenceAccess = persistenceAccess;
        this.modelAccess = modelAccess;
        this.viewFactory = new ViewFactory(modelAccess);

    }

    public ProgramState() {
        this(new PersistenceAccess(), new ModelAccess());
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

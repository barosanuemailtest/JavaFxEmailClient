package com.barosanu;

public class ProgramState {

    private PersistenceAccess persistenceAccess;
    private ModelAccess modelAccess;

    public ProgramState(PersistenceAccess persistenceAccess, ModelAccess modelAccess ){
        this.persistenceAccess = persistenceAccess;
        this.modelAccess = modelAccess;
    }

    public ProgramState(){
        this(new PersistenceAccess(), new ModelAccess());
    }

    private void checkPersistence(){
        if(this.persistenceAccess.loadFromPersistence() != null) {
            //TODO : load stuff
            // Salut Nadia!
        } else {

        }
    }


}

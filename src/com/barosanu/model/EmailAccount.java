package com.barosanu.model;

import java.util.Properties;

public class EmailAccount {

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        EmailUtils.addPropertiesToAccout(this);
    }

    private String address;
    private String password;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getAddress() {
        return address;
    }

    public Properties getProperties() {
        return properties;
    }
}

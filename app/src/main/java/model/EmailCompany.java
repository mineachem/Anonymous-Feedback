package model;

import java.io.Serializable;

/**
 * Created by Minea on 1/25/2018.
 */

public class EmailCompany implements Serializable {

    private String mail_id;
    private String mail_name;

    public EmailCompany(String mail_id, String mail_name) {
        this.mail_id = mail_id;
        this.mail_name = mail_name;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getMail_name() {
        return mail_name;
    }

    public void setMail_name(String mail_name) {
        this.mail_name = mail_name;
    }

    @Override
    public String toString() {
        return  mail_name ;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dao Van Do
 */
public class Partner {

    private String id;
    private String name;
    private String code;
    private String mail;

    public Partner(String id, String name, String code, String mail) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.mail = mail;
    }

    public Partner() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    

}

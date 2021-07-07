package com.tez.sikayetportali.model;

import java.util.Date;

public class Users {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String username;
    private String password;
    private String email;
    private Date create_date;
    private Date update_date;

    public Users() {
    }

    public Users(int id, String name, String surname, String phone, String username, String password, String email, Date create_date, Date update_date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }
}

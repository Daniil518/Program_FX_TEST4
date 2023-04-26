package com.example.program_fx_test.entities;

public class User {

    private String login;
    private String password;

    private Roles role;



    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public static void main(String[] args) {
        User user  = new User("login", "password");

        user.role = Roles.STUDENT;

        System.out.println("asd");

    }
}

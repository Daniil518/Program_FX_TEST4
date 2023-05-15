package com.example.program_fx_test;

import com.example.program_fx_test.entities.Roles;
import com.example.program_fx_test.entities.User;

public class Application {

    private static User currentUser;

    public static Roles getCurrentUserRole() {
        return currentUser.getRole();
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}

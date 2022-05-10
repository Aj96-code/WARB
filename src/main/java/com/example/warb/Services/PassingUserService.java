package com.example.warb.Services;

import com.example.warb.JPAEntities.User;
import javafx.scene.layout.StackPane;

public final class PassingUserService {
    private User CurrentUser;
    //Get/Make the Only is of this object in running program
    private final static PassingUserService INSTANCE = new PassingUserService();
    // Hides the Constructor that the program can not make a new instance of it
    private  PassingUserService(){}
    public static PassingUserService getInstance(){
        return INSTANCE;
    }

    public void setUser(User CurrentUser){
        this.CurrentUser = CurrentUser;
    }
    public User getUser(){
        return this.CurrentUser;
    }
}

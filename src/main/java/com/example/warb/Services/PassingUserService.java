package com.example.warb.Services;

import com.example.warb.JPAEntities.User;
import javafx.scene.layout.StackPane;

public final class PassingUserService {
    private User CurrentUser;
    private final static PassingUserService INSTANCE = new PassingUserService();
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

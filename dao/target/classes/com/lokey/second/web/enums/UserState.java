package com.lokey.second.web.enums;

/**
 * Created by lokey on 2018/1/9.
 */
public enum UserState {

    NOT_CHECKED(0),COMMON(1),NOT_ALLOWED(2);

    private int value;

    UserState(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}

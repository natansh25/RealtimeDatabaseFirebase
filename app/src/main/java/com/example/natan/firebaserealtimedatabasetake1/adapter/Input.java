package com.example.natan.firebaserealtimedatabasetake1.adapter;

/**
 * Created by natan on 11/6/2017.
 */

public class Input {

    private String text;
    private String name;


    public Input()
    {

    }




    public Input(String text, String name) {
        this.text = text;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }
}

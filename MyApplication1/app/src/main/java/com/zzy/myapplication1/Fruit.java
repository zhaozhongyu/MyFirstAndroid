package com.zzy.myapplication1;

/**
 * Created by xl on 2018/1/26.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return this.name;
    }
    public int getImageId(){
        return this.imageId;
    }
}

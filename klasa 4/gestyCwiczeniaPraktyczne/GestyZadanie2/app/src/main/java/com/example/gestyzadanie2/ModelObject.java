package com.example.gestyzadanie2;

public enum ModelObject {
    RED(R.string.RED,R.layout.red),
    BLUE(R.string.BLUE,R.layout.blue),
    GREEN(R.string.GREEN,R.layout.green);


    int TitleID;
    int LayoutID;
    ModelObject(int TitleIDm, int LayoutIDm) {
        TitleID=TitleIDm;
        LayoutID=LayoutIDm;
    }
    public int getLayoutID(){return LayoutID;}
    public int getTitleID(){return TitleID;}
}

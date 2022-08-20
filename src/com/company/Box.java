package com.company;
import java.util.ArrayList;
import  java.util.List;

public class Box {
    public  int x;
    public  int y;
    public  List<Unit> listBox=new ArrayList<>();
    public BoxType boxType;

    public  Box(BoxType boxType,int x,int y)
    {
        this.boxType=boxType;
        this.x=x;
        this.y=y;
    }
    public void addUnit(Unit unit)
    {
        this.listBox.add(unit);
    }
    @Override
    public String toString() {
        return  "x: "+x+"y: "+y+  listBox;
    }
}

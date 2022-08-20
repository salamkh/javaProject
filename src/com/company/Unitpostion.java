package com.company;

import java.io.Serializable;

public class Unitpostion implements Serializable
{
    private  int centerX;
    private  int CenterY;
    private  int radius;

    public int getCenterX()
    {
        return centerX;
    }

    public int getCenterY()
    {
        return CenterY;
    }

    @Override
    public String toString() {
        return "Unitpostion{" +
                "centerX=" + centerX +
                ", CenterY=" + CenterY +
                '}';
    }
     public int getRadius()
    {
        return radius;
    }

    public void setCenterX(int centerX)
    {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY)
    {
        CenterY = centerY;
    }

    public void setRadius(Name name)
    {
        if (name==Name.TaslaTank)
            radius=20;
        else if (name==Name.Sniper)
            radius=3;
        else if (name==Name.MirageTank)
            radius=15;
        else if (name==Name.Infantry)
            radius=3;
        else if (name==Name.GrizzlyTank)
            radius=20;
        else if (name==Name.NavySeal)
            radius=3;
        else if (name==Name.TankDestroyer)
            radius=20;
        else if (name==Name.PrismTank)
            radius=20;
        else if (name==Name.Pillbox)
            radius=40;
        else if (name==Name.PrismTowe)
            radius=30;
        else if (name==Name.GrandCannon)
            radius=40;
        else if (name==Name.MAINBASE)
            radius=50;
        else if (name==Name.BlackEagle)
            radius=0;
        else if (name==Name.PatriotMissileSystem)
            radius=40;
    }

    public  boolean squareIsOccupied()
    {
     return false;
    }

}

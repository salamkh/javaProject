package com.company;
import java.util.ArrayList;
public class Grid
{
    public ArrayList<Box> grid;
    public Grid() {
        grid = new ArrayList<Box>();

    }
    public synchronized boolean isAvailable(int x,int y)
    {
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid.get(i).listBox.size();j++)
            {
                if(x>=20 && x<=39 &&y>=60 && y<=79)
                    return false;
                if(grid.get(i).listBox.get(j).Postion.getCenterX()==x && grid.get(i).listBox.get(j).Postion.getCenterY()==y && grid.get(i).listBox.get(j).unitType!=UnitType.AirPlane)
                    return false;
            }
        }
        return true;
    }
    public void zoomIn(int firstX,int firstY,int endX,int endY)
    {
        for(int i=firstX;i<endX;i++)
        {
            for(int j=firstY;j<endY;j++)
            {
                System.out.print(grid.get(i).listBox.get(j).toString());
            }
            System.out.println(" ");
        }
    }
}
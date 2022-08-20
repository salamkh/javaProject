package com.company;
public abstract class Movment {

    public  void moveUp(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX() + 1;
        int y = unit.Postion.getCenterY();
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public    void moveDown(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX() - 1;
        int y = unit.Postion.getCenterY();
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public    void moveLeftUp(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX() + 1;
        int y = unit.Postion.getCenterY() - 1;
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public    void moveLeftDown(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX() - 1;
        int y = unit.Postion.getCenterY() - 1;
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public    void moveRightUp(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX() + 1;
        int y = unit.Postion.getCenterY() + 1;
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public   void moveRightDown(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX() - 1;
        int y = unit.Postion.getCenterY() + 1;
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }  public  void moveLeft(Unit unit,Grid grid) {
        int x = unit.Postion.getCenterX();
        int y = unit.Postion.getCenterY() - 1;
        if (x > 0 && x < 10000 && y > 0 && y < 10000 && grid.isAvailable(x,y)) {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public  void moveRight(Unit unit,Grid grid)
    {
        int x = unit.Postion.getCenterX();
        int y = unit.Postion.getCenterY() + 1;
        if (x>0 && x<10000 && y>0 && y<10000 && grid.isAvailable(x,y))
        {
            changeBox(unit,grid,x,y);
            unit.Postion.setCenterX(x);
            unit.Postion.setCenterY(y);
        }
    }
    public  void changeBox(Unit unit,Grid grid,int x,int y) {
        synchronized (grid) {
            int xNewBox = x / 20;
            int yNewBox = y / 20;
            int xOldBox = unit.Postion.getCenterX() / 20;
            int yOldBox = unit.Postion.getCenterY() / 20;
            if (xNewBox != xOldBox || yNewBox != yOldBox) {
                for (int i = 0; i < grid.grid.size(); i++) {
                    if (grid.grid.get(i).x == xNewBox && grid.grid.get(i).y == yNewBox) {
                        grid.grid.get(i).listBox.add(unit);
                    } else {
                        Box box = new Box(BoxType.Plain, xNewBox, yNewBox);
                        box.listBox.add(unit);
                        grid.grid.add(box);
                    }
                    if (grid.grid.get(i).x == xOldBox && grid.grid.get(i).y == yOldBox) {
                        for (int j = 0; j < grid.grid.get(i).listBox.size(); j++) {
                            if (grid.grid.get(i).listBox.get(j).Postion.getCenterX() == unit.Postion.getCenterX() && grid.grid.get(i).listBox.get(j).Postion.getCenterY() == unit.Postion.getCenterY()) {
                                grid.grid.get(i).listBox.remove(j);
                            }
                        }
                    }
                }
                unit.Postion.setCenterX(x);
                unit.Postion.setCenterY(y);
            } else {
                for (int i = 0; i < grid.grid.size(); i++) {
                    if (grid.grid.get(i).x == xOldBox && grid.grid.get(i).y == yOldBox) {
                        for (int j = 0; j < grid.grid.get(i).listBox.size(); j++) {
                            if (grid.grid.get(i).listBox.get(j).Postion.getCenterX() == unit.Postion.getCenterX() && grid.grid.get(i).listBox.get(j).Postion.getCenterY() == unit.Postion.getCenterY()) {
                                grid.grid.get(i).listBox.get(j).Postion.setCenterX(x);
                                grid.grid.get(i).listBox.get(j).Postion.setCenterY(y);
                            }
                        }
                    }
                }
            }
        }
    }
public abstract void move(Unit unit,Grid grid) throws InterruptedException;
}

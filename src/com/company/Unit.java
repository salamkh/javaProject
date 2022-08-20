package com.company;

import java.io.Serializable;

public abstract class Unit  implements Serializable,Runnable {
    protected DoDGameManager game;
    protected  Name name;
    protected  Object[] canAttack=new Object[]{};
    protected  Movment movment;
    protected  Unitpostion Postion;
    protected UnitProperty unitProprties[];
     UnitType unitType;
     int teamId;
     public Unit()
     {
         this.Postion=new Unitpostion();
         unitProprties=new UnitProperty[6];
     }

    public UnitProperty[] getUnitProprties() {
        return unitProprties;
    }

    public void setUnitProprties(UnitProperty[] unitProprties) {
        this.unitProprties = unitProprties;
    }


    public void setCanAttack(UnitType[] canAttack) {
        this.canAttack = canAttack;
    }

    public void setMovment(Movment movment) {
        this.movment = movment;
    }

    public void setPostion(Unitpostion postion) {
        Postion = postion;
    }
    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }


    public Object[] getCanAttack() {
        return canAttack;
    }

    public Movment getMovment() {
        return movment;
    }

    public Unitpostion getPostion() {
        return Postion;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void run(){
        game=DoDGameManager.singletondod();
        if(teamId==1)
        {
            movment=new AttackerMovement();
            System.out.println("run "+this.teamId+this.name+this.Postion.getCenterX()+"/"+this.Postion.getCenterY());
            try {
                    movment.move(this, game.grid);
            } catch (InterruptedException e) { e.printStackTrace();}
            System.out.println("one attacker end");
        }
        else if(teamId==2)
        {
            movment=new DefenderMovement();
                System.out.println("run "+this.teamId+this.name+this.Postion.getCenterX()+"/"+this.Postion.getCenterY());
                try {
                    movment.move(this, game.grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("one defender end");
        }
    }
}

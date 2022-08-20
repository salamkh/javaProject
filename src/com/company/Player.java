package com.company;
import java.io.Serializable;
import java.util.ArrayList;
public abstract class Player implements Serializable
{
    public ArrayList<Unit>playerUnit;
    protected int teamId;
    protected int coins;

    public Player(int coins) {
        this.coins = coins;
        playerUnit=new ArrayList<Unit>();
    }


    public abstract void NewGame();
    public abstract void LoadGame();
    public abstract void buyUnit();
}


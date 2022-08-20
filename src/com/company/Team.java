package com.company;
import java.io.Serializable;
import java.util.ArrayList;
public abstract class Team implements Serializable
{
    public ArrayList<Player> players;
    public Team()
    {
        players=new ArrayList<Player>();

    }
   // private Unitpostion[] teamUnitsInitializationPostions;
  public abstract  void addPlayer(int numberOfPlayers);
}

package com.company;

public class DeffenderTeam extends  Team  {
    @Override
    public void addPlayer(int numOfPlayer)
    {
        for (int i=0;i<numOfPlayer;i++)
    {
        Player player = new ConsolePlayer();
        player.teamId=2;
        player.buyUnit();
        this.players.add(player);
    }
    }
}
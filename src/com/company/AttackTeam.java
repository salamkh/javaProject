package com.company;

public class AttackTeam extends Team
{
    @Override
    public void addPlayer(int numOfPlayer)
    {
        for (int i=0;i<numOfPlayer;i++)
        {
            Player player = new ConsolePlayer();
            player.teamId=1;
            player.buyUnit();
            this.players.add(player);
        }
    }
}

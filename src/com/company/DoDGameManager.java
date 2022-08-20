package com.company;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DoDGameManager implements  Serializable {
    public Grid grid;
    public static Unit mainBase;
    public static int remainingAttackUnit;
    public static double reminingTime=3;
    public Team defenderTeam;
    public Team attackerTeam;
    protected GameState gameState;
    private static DoDGameManager  doDGameManager ;
    public static ExecutorService executorService;
    private DoDGameManager()
    {
        gameState=GameState.RUNNING;
        Box box;
        mainBase = new UnitFactory().createUnit(Name.MAINBASE, 60, 60,2);
        grid = new Grid();
        box = new Box(BoxType.Plain,3, 3);
        box.listBox.add(mainBase);
        grid.grid.add(box);
        Box terrain=new Box(BoxType.River,6,1);
        grid.grid.add(terrain);
        terrain=new Box(BoxType.River,6,3);
        grid.grid.add(terrain);
        terrain=new Box(BoxType.Bridges,6,2);
        grid.grid.add(terrain);
        terrain=new Box(BoxType.Valley,1,3);
        grid.grid.add(terrain);
        defenderTeam = new DeffenderTeam();
        //defenderTeam.addPlayer(2);
        attackerTeam = new AttackTeam();
        //attackerTeam.addPlayer(2);
    }
    class MyTimer extends TimerTask {
        public void run() {
            System.out.println("time over");
            if (DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0)
            {
                gameState=GameState.ATTACK_WIN;
                System.out.println(gameState);
                executorService.shutdownNow();
                return;
            }
            else
            {
                gameState= GameState.DEFENDER_WIN;
                System.out.println(gameState);
                executorService.shutdownNow();
                return;
            }
        }
    }
    public void stopGame()
    {
        Timer timer=new Timer();
        MyTimer myTimer=new MyTimer();
        timer.schedule(myTimer,100000);
    }
    public static DoDGameManager singletondod (){
        if(doDGameManager==null) {
            doDGameManager=new DoDGameManager();
        }
        return doDGameManager;
    }
     /*public void run()
     {
         while (true)
         {
         if (DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0)
         {
             gameState=GameState.ATTACK_WIN;
             System.out.println(gameState);
             executorService.shutdownNow();
             return;
         }
         else if(remainingAttackUnit==0 )
         {
             gameState= GameState.DEFENDER_WIN;
             System.out.println(gameState);
             executorService.shutdownNow();
             return;
         }
         }
     }*/
     public void runGame() throws InterruptedException {
         executorService= Executors.newFixedThreadPool(40);
         stopGame();
         for (int i = 0; i < defenderTeam.players.size(); i++) {
             for (int j = 0; j < defenderTeam.players.get(i).playerUnit.size(); j++) {
                 executorService.execute(defenderTeam.players.get(i).playerUnit.get(j));
             }
         }
         for (int i = 0; i < attackerTeam.players.size(); i++) {
             for (int j = 0; j < attackerTeam.players.get(i).playerUnit.size(); j++) {
                 executorService.execute(attackerTeam.players.get(i).playerUnit.get(j));
             }
         }
      /*   while (true)
         {
             if (DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0)
             {
                 gameState=GameState.ATTACK_WIN;
                 System.out.println(gameState);
                 executorService.shutdownNow();
                 return;
             }
             else if(remainingAttackUnit==0 )
             {
                 gameState= GameState.DEFENDER_WIN;
                 System.out.println(gameState);
                 executorService.shutdownNow();
                 return;
             }
         }*/
     }

    public void putOnGrid() {
        for (int i = 0; i < defenderTeam.players.size(); i++) {
            for (int j = 0; j < defenderTeam.players.get(i).playerUnit.size(); j++) {
                int x = defenderTeam.players.get(i).playerUnit.get(j).Postion.getCenterX() / 20;
                int y = defenderTeam.players.get(i).playerUnit.get(j).Postion.getCenterY() / 20;
                int k;
                for (k = 0; k < grid.grid.size(); k++) {
                    if (grid.grid.get(k).x == x && grid.grid.get(k).y == y) {
                        grid.grid.get(k).listBox.add(defenderTeam.players.get(i).playerUnit.get(j));
                        break;
                    }
                }
                if (k == grid.grid.size()) {
                    Box box = new Box(BoxType.Plain,x, y);
                    box.listBox.add(defenderTeam.players.get(i).playerUnit.get(j));
                    grid.grid.add(box);
                }
            }
        }
        for (int i = 0; i < attackerTeam.players.size(); i++) {

            for (int j = 0; j < attackerTeam.players.get(i).playerUnit.size(); j++) {
                int x = attackerTeam.players.get(i).playerUnit.get(j).Postion.getCenterX() / 20;
                int y = attackerTeam.players.get(i).playerUnit.get(j).Postion.getCenterY() / 20;
                int k;
                for (k = 0; k < grid.grid.size(); k++) {
                    if (grid.grid.get(k).x == x && grid.grid.get(k).y == y) {
                        grid.grid.get(k).listBox.add(attackerTeam.players.get(i).playerUnit.get(j));
                        break;
                    }
                }
                if (k == grid.grid.size()) {
                    Box box = new Box(BoxType.Plain,x, y);
                    box.listBox.add(attackerTeam.players.get(i).playerUnit.get(j));
                    grid.grid.add(box);
                }

            }
        }
    }
    public  void printWholeGrid()
    {
        for (int i = 0; i <grid.grid.size() ; i++) {
            for (int j = 0; j <grid.grid.get(i).listBox.size() ; j++) {
                System.out.print("the type of unit:  "+grid.grid.get(i).listBox.get(j).unitType+"\t\n"+
                        "the name of unit:  "+grid.grid.get(i).listBox.get(j).name+"\t\n"+
                         "The postion of unit: "+grid.grid.get(i).listBox.get(j).Postion.getCenterX()+","+grid.grid.get(i).listBox.get(j).Postion.getCenterY()+"\t\n"+
                        "the health of unit:  "+grid.grid.get(i).listBox.get(j).unitProprties[1].getPropertyVale()+"\t\n"+
                        "the armor of Unit:  "+grid.grid.get(i).listBox.get(j).unitProprties[0].getPropertyVale()+"\t\n"+
                        "the attack damage of unit:  "+grid.grid.get(i).listBox.get(j).unitProprties[2].getPropertyVale()+"\t\n"+
                        "the attack range of unit:  "+grid.grid.get(i).listBox.get(j).unitProprties[4].getPropertyVale()+"\t\n"+
                        "the movement speed of unit:  "+grid.grid.get(i).listBox.get(j).unitProprties[5].getPropertyVale()+"\t\n"
                        +"The attackspeed of unit: "+grid.grid.get(i).listBox.get(j).unitProprties[3].getPropertyVale()+"\t\n"
                );
                System.out.println("units that can attack it:");
                if (grid.grid.get(i).listBox.get(j).name==Name.MAINBASE)
                    System.out.println("it cannot attack anything");
                else
                    for (int k = 0; k <grid.grid.get(i).listBox.get(j).canAttack.length ; k++) {
                        System.out.println(grid.grid.get(i).listBox.get(j).canAttack[k]);
                    }
            }
        }
    }
}

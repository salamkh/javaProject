package com.company;
import java.util.ArrayList;
import java.util.Random;

public class UnitAttack
{
    Unit destination;
    public ArrayList<Unit> unitsInRange=new ArrayList<Unit>();
    public  ArrayList<Unit> setunitsInRange(Unit unit,Grid grid) {
        synchronized (grid) {
            int startX = (int) (unit.Postion.getCenterX() - unit.unitProprties[4].getPropertyVale());
            int startY = (int) (unit.Postion.getCenterY() - unit.unitProprties[4].getPropertyVale());
            int endX = (int) (unit.Postion.getCenterX() + unit.unitProprties[4].getPropertyVale());
            int endY = (int) (unit.Postion.getCenterY() + unit.unitProprties[4].getPropertyVale());
            if (startX < 0)
                startX = 0;
            if (startY < 0)
                startY = 0;
            if (endX > 10000)
                endX = 10000;
            if (endY > 10000)
                endY = 10000;
            for (int i = 0; i < grid.grid.size(); i++) {
                for (int j = 0; j < grid.grid.get(i).listBox.size(); j++) {
                    if (grid.grid.get(i).listBox.get(j).Postion.getCenterX() >= startX && grid.grid.get(i).listBox.get(j).Postion.getCenterX() <= endX && grid.grid.get(i).listBox.get(j).Postion.getCenterY() >= startY && grid.grid.get(i).listBox.get(j).Postion.getCenterY() <= endY) {
                        if (unit.name == Name.BombCars) {
                            for (int k = 0; k < unit.canAttack.length; k++) {
                                if (unit.canAttack[k] == grid.grid.get(i).listBox.get(j).name.unitType) {
                                    unitsInRange.add(grid.grid.get(i).listBox.get(j));
                                }
                            }
                        } else if ((unit.teamId != grid.grid.get(i).listBox.get(j).teamId)) {
                            if (grid.grid.get(i).listBox.get(j).name == Name.MAINBASE && unit.teamId == 1) {
                                unitsInRange.add(grid.grid.get(i).listBox.get(j));
                                return unitsInRange;
                            }
                            for (int k = 0; k < unit.canAttack.length - 1; k++) {
                                if (unit.canAttack[k] == grid.grid.get(i).listBox.get(j).name.unitType) {
                                    unitsInRange.add(grid.grid.get(i).listBox.get(j));
                                }
                            }
                        }
                    }
                }
            }
            return unitsInRange;
        }
    }
   public Unit attackOnSpecificStrategy()
   {
       AttackStratgy [] attackStratgy = new AttackStratgy[3];
       attackStratgy[0]=new RandomAttackStrategy();
       attackStratgy[1]=new LowestHealthAttackStratgy();
       attackStratgy[2]=new HighestDamageAttackStratgy();
       int x=(int) new Random().nextInt(attackStratgy.length);
     return attackStratgy[x].PrioritizeUniteToAttack(unitsInRange);
   }
   public synchronized void attack(Unit source,Grid grid) throws InterruptedException {
       setunitsInRange(source,grid);
       if(source.name==Name.BombCars) {
           if(unitsInRange.size()!=0) {
               Thread.sleep(2000);
               for (int k = 0; k < unitsInRange.size(); k++) {
                   for (int i = 0; i < grid.grid.size(); i++) {
                       for (int j = 0; j < grid.grid.get(i).listBox.size(); j++) {
                           if (grid.grid.get(i).listBox.get(j).Postion.getCenterX() == unitsInRange.get(k).Postion.getCenterX() && grid.grid.get(i).listBox.get(j).Postion.getCenterY() == unitsInRange.get(k).Postion.getCenterY()) {
                               if (unitsInRange.get(k).unitProprties[0].getPropertyVale() != 0) {
                                   unitsInRange.get(k).unitProprties[1].update(unitsInRange.get(k).unitProprties[1].getPropertyVale() - (source.unitProprties[2].getPropertyVale() * unitsInRange.get(k).unitProprties[0].getPropertyVale()));
                               } else {
                                   unitsInRange.get(k).unitProprties[1].update(unitsInRange.get(k).unitProprties[1].getPropertyVale() - (source.unitProprties[2].getPropertyVale()));
                               }
                               if (unitsInRange.get(k).unitProprties[1].getPropertyVale() <= 0) {
                                   grid.grid.get(i).listBox.remove(j);
                                   if (unitsInRange.get(k).teamId == 1) {
                                       DoDGameManager.remainingAttackUnit--;
                                   }
                               }
                           }
                       }
                   }
                   return;
               }
           }
       }
       if (unitsInRange.size()!=0 && source.unitProprties[3].getPropertyVale()!=0){
       destination=new UnitFactory();
       boolean b=false;
       if(source.teamId==1)
       {
           for(int i=0;i<unitsInRange.size();i++)

               if(unitsInRange.get(i).name==Name.MAINBASE)
               {
                    destination =  unitsInRange.get(i);
                    b=true;
               }
           if(b==false)
               destination=attackOnSpecificStrategy();
       }
       else
       {
           destination = attackOnSpecificStrategy();
       }
           int xBox=destination.Postion.getCenterX()/20;
           int yBox=destination.Postion.getCenterY()/20;
           for(int i=0;i<grid.grid.size();i++)
           {
               if(grid.grid.get(i).x==xBox && grid.grid.get(i).y==yBox && grid.grid.get(i).boxType==BoxType.Bridges)
               {
                   grid.grid.get(i).boxType=BoxType.River;
               }
           }
       while (destination.unitProprties[1].getPropertyVale()>0 && source.unitProprties[1].getPropertyVale()>0)
       {
           if(destination.unitProprties[0].getPropertyVale()!=0) {
               destination.unitProprties[1].update(destination.unitProprties[1].getPropertyVale() - (source.unitProprties[2].getPropertyVale() * destination.unitProprties[0].getPropertyVale()));
           }
           else
           {
               destination.unitProprties[1].update(destination.unitProprties[1].getPropertyVale() - (source.unitProprties[2].getPropertyVale()));
           }
           System.out.println(source.teamId+" "+source.name+":"+destination.teamId+" "+destination.name +" / "+destination.unitProprties[1].getPropertyVale());
           double time = 1000 /  source.unitProprties[3].getPropertyVale();
           Thread.sleep((long)time);
       }
           if(destination.name==Name.MAINBASE)
           {
               DoDGameManager.mainBase.unitProprties[1].update(0);
           }
       for(int i=0;i<grid.grid.size();i++) {
           for (int j = 0; j < grid.grid.get(i).listBox.size(); j++) {
               if (grid.grid.get(i).listBox.get(j).Postion.getCenterX() == destination.Postion.getCenterX() && grid.grid.get(i).listBox.get(j).Postion.getCenterY() == destination.Postion.getCenterY()) {
                   grid.grid.get(i).listBox.remove(j);
               if(destination.teamId==1)
               {
                   DoDGameManager.remainingAttackUnit--;
               }
               }
           }
       }
   }
}
}

package com.company;

public class DefenderMovement extends Movment {

    @Override
    public void move(Unit unit, Grid grid) throws InterruptedException {
        int ymax = unit.Postion.getCenterY() + 20;
        int ymin = unit.Postion.getCenterY() - 20;
        if (ymax > 10000) ymax = 10000;
        if (ymin < 0) ymin = 0;
        while (true) {
            if(DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0 || DoDGameManager.remainingAttackUnit==0||unit.unitProprties[1].getPropertyVale() <= 0)
                return;
            if (unit.unitType == UnitType.AirPlane || unit.unitProprties[5].getPropertyVale() == 0) {
               // System.out.println("run "+unit.teamId+unit.name+unit.Postion.getCenterX()+"/"+unit.Postion.getCenterY());
                UnitAttack defenderunitattack = new UnitAttack();
                defenderunitattack.attack(unit, grid);
            } else {
                while (grid.isAvailable(unit.Postion.getCenterX(), (unit.Postion.getCenterY() + 1)) &&( unit.Postion.getCenterY() + 1) < ymax) {
                    if(DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0 || DoDGameManager.remainingAttackUnit==0||unit.unitProprties[1].getPropertyVale() <= 0)
                        return;
                   // System.out.println("run "+unit.teamId+unit.name+unit.Postion.getCenterX()+"/"+unit.Postion.getCenterY());
                    moveRight(unit, grid);
                    UnitAttack defenderunitattack = new UnitAttack();
                    try {
                        defenderunitattack.attack(unit, grid);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    double time = 1000 / unit.unitProprties[5].getPropertyVale();
                    Thread.sleep((long) time);
                }
                while (grid.isAvailable(unit.Postion.getCenterX(), unit.Postion.getCenterY() - 1) && unit.Postion.getCenterY() - 1 > ymin) {
                    if(DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0 || DoDGameManager.remainingAttackUnit==0||unit.unitProprties[1].getPropertyVale() <= 0)
                        return;
                   // System.out.println("run "+unit.teamId+unit.name+unit.Postion.getCenterX()+"/"+unit.Postion.getCenterY());
                    moveLeft(unit, grid);
                    UnitAttack defenderunitattack = new UnitAttack();
                    try {
                        defenderunitattack.attack(unit, grid);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    double time = 1000 / unit.unitProprties[5].getPropertyVale();
                    Thread.sleep((long) time);
                }
            }
        }
    }
}


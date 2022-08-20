
package com.company;

public class AttackerMovement extends  Movment {
    @Override
    public void move(Unit unit, Grid grid) throws InterruptedException {
        UnitAttack unitAttack = new UnitAttack();
        while (unit.unitProprties[1].getPropertyVale() > 0) {
            //System.out.println("run "+unit.teamId+unit.name+unit.Postion.getCenterX()+"/"+ unit.Postion.getCenterY());
            if(DoDGameManager.mainBase.unitProprties[1].getPropertyVale()<=0 || DoDGameManager.remainingAttackUnit==0||unit.unitProprties[1].getPropertyVale() <= 0)
                return;
            int r = unit.Postion.getCenterY() - 60;
            int t = unit.Postion.getCenterX() - 60;
            if (r > 0 && t > 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveLeftDown(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (r < 0 && t < 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveRightUp(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (r == 0 && t > 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveDown(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (r == 0 && t < 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveUp(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (t == 0 && r > 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveLeft(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (t == 0 && r < 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveRight(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (t > 0 && r < 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveLeftUp(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            } else if (t < 0 && r > 0) {
                if (unit.unitProprties[5].getPropertyVale() != 0)
                    moveRightDown(unit, grid);
                try {
                    unitAttack.attack(unit, grid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            }
            if (unit.unitProprties[5].getPropertyVale() != 0) {
                double time = 1000 / unit.unitProprties[5].getPropertyVale();
                int xBox = unit.Postion.getCenterX() / 20;
                int yBox = unit.Postion.getCenterY() / 20;
                for (int i = 0; i < grid.grid.size(); i++) {
                    if (grid.grid.get(i).x == xBox && grid.grid.get(i).y == yBox && grid.grid.get(i).boxType == BoxType.River) {
                        time *= 2;
                    }
                }
                Thread.sleep((long) time);
            }
        }
    }
}

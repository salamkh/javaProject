package com.company;

public class AttackSpeedUnitProperty extends  UnitProperty {
    private double attackSpeed;
    @Override
    public void setPropertyVale(Name name)
    {
        if (name==Name.TaslaTank)
            attackSpeed=0.60;
        else if (name==Name.Sniper)
            attackSpeed=0.4;
        else if (name==Name.MirageTank)
            attackSpeed=1;
        else if (name==Name.Infantry)
            attackSpeed=1.5;
        else if (name==Name.GrizzlyTank)
            attackSpeed=0.60;
        else if (name==Name.NavySeal)
            attackSpeed=2;
        else if (name==Name.TankDestroyer)
            attackSpeed=0.60;
        else if (name==Name.PrismTank)
            attackSpeed=0.60;
        else if (name==Name.Pillbox)
            attackSpeed=0.70;
        else if (name==Name.PrismTowe)
            attackSpeed=0.50;
        else if (name==Name.GrandCannon)
            attackSpeed=0.90;
        else if (name==Name.MAINBASE)
            attackSpeed=0.00;
        else if (name==Name.BlackEagle)
            attackSpeed=2;
        else if (name==Name.PatriotMissileSystem)
            attackSpeed=0.90;
        else if (name==Name.BombCars)
            attackSpeed=0.9;
    }
    @Override
    public double getPropertyVale() {
        return attackSpeed;
    }
    @Override
    public void update (double value)
    {

    }
}

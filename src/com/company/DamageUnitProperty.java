package com.company;

public class DamageUnitProperty extends UnitProperty
{
    private double damage;

    @Override
    public void setPropertyVale(Name name) {
        if (name==Name.TaslaTank)
            damage=300;
        else if (name==Name.Sniper)
            damage=75;
        else if (name==Name.MirageTank)
            damage=1000;
        else if (name==Name.Infantry)
            damage=50;
        else if (name==Name.GrizzlyTank)
            damage=250;
        else if (name==Name.NavySeal)
            damage=60;
        else if (name==Name.TankDestroyer)
            damage=400;
        else if (name==Name.PrismTank)
            damage=300;
        else if (name==Name.Pillbox)
            damage=100;
        else if (name==Name.PrismTowe)
            damage=100;
        else if (name==Name.GrandCannon)
            damage=150;
        else if (name==Name.MAINBASE)
            damage=0;
        else if (name==Name.BlackEagle)
            damage=400;
        else if (name==Name.PatriotMissileSystem)
            damage=50;
        else if (name==Name.BombCars)
            damage=1500;
    }

    @Override
    public double getPropertyVale() {
        return damage;
    }
    @Override
    public void update (double value)
    {

    }
}

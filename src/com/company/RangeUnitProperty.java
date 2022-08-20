package com.company;

public class RangeUnitProperty extends UnitProperty
{
    private double range;

    @Override
    public void setPropertyVale(Name name) {
        if (name==Name.TaslaTank)
            range=250;
        else if (name==Name.Sniper)
            range=700;
        else if (name==Name.MirageTank)
            range=10;
        else if (name==Name.Infantry)
            range=50;
        else if (name==Name.GrizzlyTank)
            range=250;
        else if (name==Name.NavySeal)
            range=50;
        else if (name==Name.TankDestroyer)
            range=150;
        else if (name==Name.PrismTank)
            range=150;
        else if (name==Name.Pillbox)
            range=200;
        else if (name==Name.PrismTowe)
            range=200;
        else if (name==Name.GrandCannon)
            range=400;
        else if (name==Name.MAINBASE)
            range=0;
        else if (name==Name.BlackEagle)
            range=30;
        else if (name==Name.PatriotMissileSystem)
            range=400;
        else if (name==Name.BombCars)
            range=200;
    }

    @Override
    public double getPropertyVale() {
        return range;
    }
    @Override
    public void update (double value)
    {

    }
}

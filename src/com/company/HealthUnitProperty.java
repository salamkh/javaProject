package com.company;

public class HealthUnitProperty extends  UnitProperty
{
    private double health;

    @Override
    public void setPropertyVale(Name name) {
        if (name==Name.TaslaTank)
            health=1000;
        else if (name==Name.Sniper)
            health=250;
        else if (name==Name.MirageTank)
            health=750;
        else if (name==Name.Infantry)
            health=250;
        else if (name==Name.GrizzlyTank)
            health=1000;
        else if (name==Name.NavySeal)
            health=400;
        else if (name==Name.TankDestroyer)
            health=1000;
        else if (name==Name.PrismTank)
            health=1000;
        else if (name==Name.Pillbox)
            health=4000;
        else if (name==Name.PrismTowe)
            health=4000;
        else if (name==Name.GrandCannon)
            health=6500;
        else if (name==Name.MAINBASE)
            health=10000;
        else if (name==Name.BlackEagle)
            health=1500;
        else if (name==Name.PatriotMissileSystem)
            health=2500;
        else if (name==Name.BombCars)
            health=2000;
    }
    @Override
    public void update (double value)
    {
        this.health=value;
    }

    @Override
    public double getPropertyVale() {
        return health;
    }

}

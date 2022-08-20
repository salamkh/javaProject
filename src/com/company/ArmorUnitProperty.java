package com.company;
public class ArmorUnitProperty extends  UnitProperty
{
private double armor;

    @Override
    public void setPropertyVale(Name name) {
        if (name==Name.TaslaTank)
            armor=0.5;
        else if (name==Name.Sniper)
            armor=0.10;
        else if (name==Name.MirageTank)
            armor=0.10;
        else if (name==Name.Infantry)
            armor=0.20;
        else if (name==Name.GrizzlyTank)
            armor=0.40;
        else if (name==Name.NavySeal)
            armor=0.20;
        else if (name==Name.TankDestroyer)
            armor=0.50;
        else if (name==Name.PrismTank)
            armor=0.35;
        else if (name==Name.Pillbox)
            armor=0.70;
        else if (name==Name.PrismTowe)
            armor=0.70;
        else if (name==Name.GrandCannon)
            armor=0.30;
        else if (name==Name.MAINBASE)
            armor=0.00;
        else if (name==Name.BlackEagle)
            armor=0.00;
        else if (name==Name.PatriotMissileSystem)
            armor=0.20;
        else if (name==Name.BombCars)
            armor=0.0;
    }
    @Override
    public double getPropertyVale() {
        return armor;
    }
    @Override
    public void update (double value)
    {

    }
}

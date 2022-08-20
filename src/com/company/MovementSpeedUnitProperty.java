package com.company;

public class MovementSpeedUnitProperty extends UnitProperty {
    private double movementSpeed;
    @Override
    public void setPropertyVale(Name name)
    {
        if (name==Name.TaslaTank)
            movementSpeed=30;
        else if (name==Name.Sniper)
            movementSpeed=10;
        else if (name==Name.MirageTank)
            movementSpeed=60;
        else if (name==Name.Infantry)
            movementSpeed=10;
        else if (name==Name.GrizzlyTank)
            movementSpeed=30;
        else if (name==Name.NavySeal)
            movementSpeed=20;
        else if (name==Name.TankDestroyer)
            movementSpeed=20;
        else if (name==Name.PrismTank)
            movementSpeed=20;
        else if (name==Name.Pillbox)
            movementSpeed=0;
        else if (name==Name.PrismTowe)
            movementSpeed=0;
        else if (name==Name.GrandCannon)
            movementSpeed=0;
        else if (name==Name.MAINBASE)
            movementSpeed=0;
        else if (name==Name.BlackEagle)
            movementSpeed=100;
        else if (name==Name.PatriotMissileSystem)
            movementSpeed=0;
        else if (name==Name.BombCars)
            movementSpeed=0;
    }
    @Override
    public double getPropertyVale() {
        return movementSpeed;
    }
    @Override
    public void update (double value)
    {

    }
}
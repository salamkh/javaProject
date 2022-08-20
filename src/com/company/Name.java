package com.company;

public enum Name {
    TaslaTank(UnitType.Tank,50),MirageTank(UnitType.Tank,70),TankDestroyer(UnitType.Tank,50),PrismTank(UnitType.Tank,60)
    ,Sniper(UnitType.SOLDIER,5),Infantry(UnitType.SOLDIER,3),GrizzlyTank(UnitType.SOLDIER,50),NavySeal(UnitType.SOLDIER,10)
    ,Pillbox(UnitType.Structure,150),PrismTowe(UnitType.Structure,150),GrandCannon(UnitType.Structure,200)
    ,PatriotMissileSystem(UnitType.Structure,175),BlackEagle(UnitType.AirPlane,75)
    ,MAINBASE(UnitType.Structure,0),BombCars(UnitType.Tank,20);
    UnitType unitType;
    int price;
    Name(UnitType unitType,int price)
    {
        this.unitType=unitType;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public UnitType getUnitType() {
        return unitType;
    }
}

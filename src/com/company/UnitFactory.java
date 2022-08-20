package com.company;
public class UnitFactory extends Unit
{
public Unit createUnit(Name name,int x,int y,int teamId)
{
    this.teamId=teamId;
    this.name=name;
    this.Postion.setCenterY(x);
    this.Postion.setCenterX(y);
    this.Postion.setRadius(name);
    this.unitType=name.unitType;
    this.unitProprties[0]=new ArmorUnitProperty();
    this.unitProprties[0].setPropertyVale(name);
    this.unitProprties[1]=new HealthUnitProperty();
    this.unitProprties[1].setPropertyVale(name);
    this.unitProprties[2]=new DamageUnitProperty();
    this.unitProprties[2].setPropertyVale(name);
    this.unitProprties[3]=new AttackSpeedUnitProperty();
    this.unitProprties[3].setPropertyVale(name);
    this.unitProprties[4]=new RangeUnitProperty();
    this.unitProprties[4].setPropertyVale(name);
    this.unitProprties[5]=new MovementSpeedUnitProperty();
    this.unitProprties[5].setPropertyVale(name);
    if(this.name==Name.Sniper || this.name==Name.Infantry || this.name==Name.Pillbox ) {
        canAttack=new UnitType[1];
        this.canAttack[0] = UnitType.SOLDIER;
    }
    else if(this.name==Name.TaslaTank || this.name==Name.NavySeal || this.name==Name.PrismTowe || this.name==Name.GrandCannon ||this.name==Name.BombCars)
    {
        canAttack=new UnitType[2];
        this.canAttack[0]= UnitType.SOLDIER;
        this.canAttack[1]= UnitType.Tank;
    }
    else if(this.name==Name.MirageTank || this.name==Name.GrizzlyTank || this.name==Name.PrismTank || this.name==Name.TankDestroyer)
    {
        canAttack=new UnitType[3];
        this.canAttack[0]= UnitType.SOLDIER;
        this.canAttack[1]= UnitType.Tank;
        this.canAttack[2]= UnitType.Structure;
    }
    else  if(this.name==Name.PatriotMissileSystem)
    {
        canAttack=new UnitType[1];
        this.canAttack[0]= UnitType.AirPlane;
    }
    else if(this.name==Name.BlackEagle && this.teamId==1)
    {
        canAttack=new Name[1];
        this.canAttack[0]=Name.MAINBASE;
    }
    else if(this.name==Name.BlackEagle && this.teamId==2)
    {
        canAttack=new UnitType[1];
        this.canAttack[0]=UnitType.AirPlane;
    }
    return this;
}

}
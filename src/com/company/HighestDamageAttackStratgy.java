package com.company;
import  java.util.ArrayList;
public class HighestDamageAttackStratgy implements AttackStratgy
{
    @Override
    public Unit PrioritizeUniteToAttack(ArrayList<Unit> units)
    {
        UnitFactory unitFactory=new UnitFactory();
        unitFactory= (UnitFactory) units.get(0);
        for(Unit x:units)
        {
            if(x.unitProprties[2].getPropertyVale()> unitFactory.unitProprties[2].getPropertyVale())
                unitFactory=(UnitFactory) x;
        }
        return unitFactory;
    }
}

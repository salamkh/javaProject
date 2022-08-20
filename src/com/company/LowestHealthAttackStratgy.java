package com.company;
import java.util.ArrayList;
import java.util.List;
public class LowestHealthAttackStratgy implements  AttackStratgy
{

    @Override
    public Unit PrioritizeUniteToAttack(ArrayList<Unit> units)
    {
        UnitFactory unitFactory = new UnitFactory();
          unitFactory = (UnitFactory) units.get(0);
        for(int i=0;i<units.size();i++)
        {
            if(units.get(i).unitProprties[1].getPropertyVale()> unitFactory.unitProprties[1].getPropertyVale())
                unitFactory=(UnitFactory) units.get(i);
        }
        return unitFactory;
    }
    }



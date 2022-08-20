package com.company;

import java.util.ArrayList;
import java.util.Random;

public class RandomAttackStrategy implements AttackStratgy
{
    @Override
    public Unit PrioritizeUniteToAttack(ArrayList<Unit> units)
    {
        int x=(int) new Random().nextInt(units.size());
        return units.get(x);
    }
}
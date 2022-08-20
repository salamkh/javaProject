package com.company;

import java.io.Serializable;

public abstract  class UnitProperty implements Serializable
{
    public abstract void setPropertyVale(Name name);
    public abstract double getPropertyVale();
    public abstract void update (double value) ;
    public String toString()
    {
        return String.valueOf(getPropertyVale());
    }
}

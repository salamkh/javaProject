package com.company;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class ConsolePlayer extends Player implements Serializable
{
    public ConsolePlayer()
    {
        super(3000);
    }
    public ConsolePlayer(int coins) {
        super(coins);
    }
    @Override
    public void NewGame()
    {

    }
    public  void LoadGame()
    {

    }
    static int r = 1;
    static ArrayList<Unit> check=new ArrayList<Unit>();
    public void buyUnit()
    {
        System.out.println("Buying units of "+(r++)+" Player :");
        do
        {
            int x=1;
            for (Name G : Name.values()) {
                if (this.coins >= G.getPrice()) {
                    if(G==Name.MAINBASE)
                        continue;
                    System.out.println("Enter "+(x++)+" to buy "+G.toString()+" its price :"+G.getPrice());
                }
            }
            System.out.println("Enter 15 if you don't want to buy any thing");
            Scanner scanner = new Scanner(System.in);
            int choic;
            try {
                do {
                    choic = scanner.nextInt();
                    if (choic == 15)
                        return;
                } while (choic < 0 || choic > 15);
                int xUnit = 0;
                int yUnit = 0;
                if (this.teamId == 2) {
                    do {
                        System.out.println("please enter the cardinates between 40 and 100");
                        xUnit = scanner.nextInt();
                        yUnit = scanner.nextInt();
                    } while (xUnit > 100 || xUnit < 40 || yUnit > 100 || yUnit < 40);
                } else {
                    do {
                        System.out.println("please enter the cardinates ");
                        xUnit = scanner.nextInt();
                        yUnit = scanner.nextInt();
                    } while (((xUnit > 20 && xUnit < 39) || (xUnit > 120 && xUnit < 139)) && (yUnit > 20 && yUnit < 79));
                }
                for (int i = 0; i < check.size(); i++) {
                    if (check.get(i).Postion.getCenterX() == xUnit && check.get(i).Postion.getCenterY() == yUnit && check.get(i).unitType != UnitType.AirPlane) {
                        System.out.println("this position is reserved try again");
                        xUnit = scanner.nextInt();
                        yUnit = scanner.nextInt();
                    }
                }

            switch (choic)
            {
                case 1:
                    playerUnit.add(new UnitFactory().createUnit(Name.TaslaTank,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.TaslaTank,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.TaslaTank.getPrice();
                    break;
                case 2:
                    playerUnit.add( new UnitFactory().createUnit(Name.MirageTank,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.MirageTank,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.MirageTank.getPrice();
                    break;
                case 3:
                    playerUnit.add( new UnitFactory().createUnit(Name.TankDestroyer,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.TankDestroyer,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.TankDestroyer.getPrice();
                    break;
                case 4:
                    playerUnit.add( new UnitFactory().createUnit(Name.PrismTank,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.PrismTank,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.PrismTank.getPrice();
                    break;
                case 5:
                    playerUnit.add(new UnitFactory().createUnit(Name.Sniper,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.Sniper,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.Sniper.getPrice();
                    break;
                case 6:
                    playerUnit.add(new UnitFactory().createUnit(Name.Infantry,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.Infantry,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.Infantry.getPrice();
                    break;
                case 7:
                    playerUnit.add(new UnitFactory().createUnit(Name.GrizzlyTank,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.GrizzlyTank,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.GrizzlyTank.getPrice();
                    break;
                case 8:
                    playerUnit.add(new UnitFactory().createUnit(Name.NavySeal,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.NavySeal,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.NavySeal.getPrice();
                    break;
                case 9:
                    playerUnit.add(new UnitFactory().createUnit(Name.Pillbox,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.Pillbox,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.Pillbox.getPrice();
                    break;
                case 10:
                    playerUnit.add(new UnitFactory().createUnit(Name.PrismTowe,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.PrismTowe,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.PrismTowe.getPrice();
                    break;
                case 11:
                    playerUnit.add(new UnitFactory().createUnit(Name.GrandCannon,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.GrandCannon,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.GrandCannon.getPrice();
                    break;
                case 12:
                    playerUnit.add(new UnitFactory().createUnit(Name.PatriotMissileSystem,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.PatriotMissileSystem,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.PatriotMissileSystem.getPrice();
                    break;
                case 13:
                    playerUnit.add(new UnitFactory().createUnit(Name.BlackEagle,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.BlackEagle,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.BlackEagle.getPrice();
                    break;
                case 14:
                    playerUnit.add(new UnitFactory().createUnit(Name.BombCars,xUnit,yUnit,this.teamId));
                    check.add(new UnitFactory().createUnit(Name.BombCars,xUnit,yUnit,this.teamId));
                    coins-=(int)Name.BombCars.getPrice();
                    break;
                default:
                    break;
            }
            }catch (NumberFormatException e){System.out.println("False input");}
        } while (this.coins>= 3 );
    }
}
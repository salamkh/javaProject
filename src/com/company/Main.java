package com.company;

import java.io.*;

public class Main implements Serializable {
    public static  void main(String[] args) throws InterruptedException {
        DoDGameManager dod=DoDGameManager.singletondod();
      try {
         /*FileOutputStream fileOutputStream=new FileOutputStream(new File("C:\\Users\\96399\\Desktop\\dodGame.bin"));
          ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
          objectOutputStream.writeObject( dod.attackerTeam);
          objectOutputStream.writeObject( dod.defenderTeam);
          objectOutputStream.close();
          fileOutputStream.close();
          System.out.println("succesfully");*/
            FileInputStream fileInputStream=new FileInputStream(new File("C:\\Users\\96399\\Desktop\\dodGame.bin"));
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
          AttackTeam attackTeam=(AttackTeam)objectInputStream.readObject();
          DeffenderTeam deffenderTeam=(DeffenderTeam)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("succesfully");
          dod.attackerTeam=attackTeam;
          dod.defenderTeam=deffenderTeam;
        }catch (FileNotFoundException e){System.out.println("File not found");}
         catch (IOException e){System.out.println("Error initializing stream");}
         catch (ClassNotFoundException e){e.printStackTrace();}
        dod.putOnGrid();
        for(int i=0;i<dod.attackerTeam.players.size();i++)
        {
            DoDGameManager.remainingAttackUnit+=dod.attackerTeam.players.get(i).playerUnit.size();
        }
        dod.runGame();
    }
}

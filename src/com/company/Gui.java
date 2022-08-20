package com.company;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.*;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setFullScreen(true);
        stage.setTitle("WAR GAME");
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\wp6690501.jpg");
        Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        Button button=new Button("START");
        button.setMinSize(100,50);
        button.setOnAction(e-> {
/*
                    GameFx gameFx = null;
                    gameFx = new GameFx();
                    stage.getScene().setRoot(gameFx.creatContent());
                });
*/
            Board board=null;
            try {
                board=new Board();
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            try {
                stage.getScene().setRoot(board.getPane());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        Button button1=new Button("EXIT");
        button1.setMinSize(100,50);
        button1.setOnAction(new ExitButtonListener());
        Button button2=new Button("pause");
        button2.setMinSize(100,50);
        Pane pane=new Pane();
        pane.getChildren().add(imageView);
        pane.getChildren().add(button);
        button.setLayoutX(600);
        button.setLayoutY(300);
        pane.getChildren().add(button1);
        button1.setLayoutX(200);
        button1.setLayoutY(600);
        pane.getChildren().add(button2);
        button2.setLayoutX(1000);
        button2.setLayoutY(600);
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public static  void main(String[] args) throws FileNotFoundException {
        DoDGameManager dod=DoDGameManager.singletondod();
        try {

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
         catch (
    IOException e){System.out.println("Error initializing stream");}
         catch (ClassNotFoundException e){e.printStackTrace();}
        System.out.println(dod.attackerTeam.players.get(0).playerUnit.size());
        System.out.println(dod.attackerTeam.players.get(1).playerUnit.size());
        System.out.println(dod.defenderTeam.players.get(0).playerUnit.size());
        System.out.println(dod.defenderTeam.players.get(1).playerUnit.size());

    launch(args);
    }

}

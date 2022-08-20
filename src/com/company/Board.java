package com.company;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Board
{
   /* public Team defenderTeam;
    public Team attackerTeam;
*/    public Grid grid=new Grid();
    GridPane gridPane=new GridPane();
    Pane pane=new Pane();
    Pane pane1=new Pane();
    Button button2=new Button("CLICK HERE TO START");
    Button button3=new Button("CLICK HERE TO EXIT!");
    Button[][]buttons=new Button[25][25];
    ImagesUnit imagesUnit=new ImagesUnit();
    int rows=25;
    int columns=25;

    public Board() throws IOException {
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void createButtons()
    {

        button2.setMinSize(150,50);
        button2.setLayoutX(1000);
        button2.setLayoutY(600);
/*        button2.setOnAction(e-> {
            PutOnGuiBoard putOnGuiBoard= null;
            try {
                putOnGuiBoard = new PutOnGuiBoard();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            //stage.getScene().setRoot(gameFx.creatContent());
            try {
                setGridPane(putOnGuiBoard.putUnit());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        });
*/
        button3.setMinSize(150,50);
        button3.setLayoutX(1000);
        button3.setLayoutY(600);
        button3.setOnAction(new ExitButtonListener());
    }
    FileInputStream fileInputStream=new FileInputStream(new File("C:\\Users\\96399\\Desktop\\project_lan_pro\\4_5951750264712071300.bin"));
    ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);


    GridPane createBoard() throws IOException, ClassNotFoundException {
        AttackTeam attackTeam=(AttackTeam)objectInputStream.readObject();
        DeffenderTeam deffenderTeam=(DeffenderTeam)objectInputStream.readObject();

        /*for (int l = 0; l <buttons.length ; l++) {
            for (int m = 0; m <buttons.length ; m++) {
                if (l==3&&m==3) {
                    if (buttons[l][m] == null) {
                        imagesUnit.MainBase.setFitHeight(30);
                        imagesUnit.MainBase.setFitWidth(30);
                        buttons[l][m] = new Button("", imagesUnit.MainBase);
                        buttons[l][m].setMinSize(35, 35);
                        gridPane.add(buttons[l][m], l, m);
                    } else {
                        while (buttons[l][m] != null)
                            l++;
                        m++;
                    }
                    imagesUnit.MainBase.setFitHeight(30);
                    imagesUnit.MainBase.setFitWidth(30);
                    buttons[l][m] = new Button("", imagesUnit.MainBase);
                    buttons[l][m].setMinSize(35, 35);
                    gridPane.add(buttons[l][m], l, m);

                }
            }
        }

*/
        for (int i = 0; i < attackTeam.players.size(); i++) {
            for (int j = 0; j < attackTeam.players.get(i).playerUnit.size(); j++) {
                int x = attackTeam.players.get(i).playerUnit.get(j).Postion.getCenterX() / 20;
                int y = attackTeam.players.get(i).playerUnit.get(j).Postion.getCenterY() / 20;
                if (attackTeam.players.get(i).playerUnit.get(j).name==Name.BlackEagle)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                    if (buttons[k][l]==null) {
                                        imagesUnit.BlackEagle.setFitHeight(30);
                                        imagesUnit.BlackEagle.setFitWidth(30);
                                        buttons[x][y] = new Button("", imagesUnit.BlackEagle);
                                        buttons[x][y].setMaxSize(40, 40);
                                        gridPane.add(buttons[x][y], x, y);
                                    }
                                    else {
                                        while (buttons[k][l]!=null)
                                        {
                                            k++;
                                            l++;
                                        }
                                        imagesUnit.BlackEagle.setFitHeight(30);
                                        imagesUnit.BlackEagle.setFitWidth(30);
                                        buttons[k][l] = new Button("", imagesUnit.BlackEagle);
                                        buttons[k][l].setMaxSize(40, 40);
                                        gridPane.add(buttons[k][l], k, l);

                                    }
                            }
                        }
                    }
                }

                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.GrandCannon)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y&&buttons[k][l]==null) {
                                if (buttons[k][l]==null) {
                                    imagesUnit.GrandCannon.setFitHeight(30);
                                    imagesUnit.GrandCannon.setFitWidth(30);
                                    buttons[k][l] = new Button("", imagesUnit.GrandCannon);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.GrandCannon.setFitHeight(30);
                                    imagesUnit.GrandCannon.setFitWidth(30);
                                    buttons[k][l] = new Button("", imagesUnit.GrandCannon);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);


                                }
                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.GrizzlyTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.GrizzlyTank.setFitHeight(30);
                                imagesUnit.GrizzlyTank.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.GrizzlyTank);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.GrizzlyTank.setFitHeight(30);
                                    imagesUnit.GrizzlyTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.GrizzlyTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.Infantry)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.Infantry.setFitHeight(30);
                                imagesUnit.Infantry.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.Infantry);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.Infantry.setFitHeight(30);
                                    imagesUnit.Infantry.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.Infantry);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }


                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.MirageTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.MirageTank.setFitHeight(30);
                                imagesUnit.MirageTank.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.MirageTank);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.MirageTank.setFitHeight(30);
                                    imagesUnit.MirageTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.MirageTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }


                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.NavySeal)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y&&buttons[k][l]==null) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.NavySeal.setFitHeight(30);
                                imagesUnit.NavySeal.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.NavySeal);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.NavySeal.setFitHeight(30);
                                    imagesUnit.NavySeal.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.NavySeal);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.PatriotMissileSystem)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.PatriotMissileSystem.setFitHeight(30);
                                imagesUnit.PatriotMissileSystem.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.PatriotMissileSystem);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PatriotMissileSystem.setFitHeight(30);
                                    imagesUnit.PatriotMissileSystem.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PatriotMissileSystem);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }

                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.Pillbox)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.PillBox.setFitHeight(30);
                                imagesUnit.PillBox.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.PillBox);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PillBox.setFitHeight(30);
                                    imagesUnit.PillBox.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PillBox);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }

                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.PrismTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.PrismTank.setFitHeight(30);
                                imagesUnit.PrismTank.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.PrismTank);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PrismTank.setFitHeight(30);
                                    imagesUnit.PrismTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PrismTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.PrismTowe)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.PrismTower.setFitHeight(30);
                                imagesUnit.PrismTower.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.PrismTower);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PrismTower.setFitHeight(30);
                                    imagesUnit.PrismTower.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PrismTower);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.Sniper)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null) {
                                    Button button = new Button();
                                    button.setPrefSize(35, 35);
                                    imagesUnit.Sniper.setPreserveRatio(true);
                                    imagesUnit.Sniper.fitWidthProperty().bind(button.widthProperty());
                                    imagesUnit.Sniper.fitHeightProperty().bind(button.heightProperty());
                                    button.setGraphic(imagesUnit.Sniper);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    Button button = new Button();
                                    button.setPrefSize(35, 35);
                                    imagesUnit.Sniper.setPreserveRatio(true);
                                    imagesUnit.Sniper.fitWidthProperty().bind(button.widthProperty());
                                    imagesUnit.Sniper.fitHeightProperty().bind(button.heightProperty());
                                    button.setGraphic(imagesUnit.Sniper);

                                }


                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.TankDestroyer)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.TankDestroyer.setFitHeight(30);
                                imagesUnit.TankDestroyer.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.TankDestroyer);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.TankDestroyer.setFitHeight(30);
                                    imagesUnit.TankDestroyer.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.TankDestroyer);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (attackTeam.players.get(i).playerUnit.get(j).name==Name.TaslaTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                imagesUnit.TeslaTank.setFitHeight(30);
                                imagesUnit.TeslaTank.setFitWidth(30);
                                buttons[k][l] =new Button("", imagesUnit.TeslaTank);
                                buttons[k][l].setMinSize(35, 35);
                                gridPane.add(buttons[k][l], k, l);
                            }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.TeslaTank.setFitHeight(30);
                                    imagesUnit.TeslaTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.TeslaTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }


            }
        }
        //**************************************************
        for (int i = 0; i < deffenderTeam.players.size(); i++) {
            for (int j = 0; j < deffenderTeam.players.get(i).playerUnit.size(); j++) {
                int x = deffenderTeam.players.get(i).playerUnit.get(j).Postion.getCenterX() / 20;
                int y = deffenderTeam.players.get(i).playerUnit.get(j).Postion.getCenterY() / 20;
                if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.BlackEagle)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null) {
                                    imagesUnit.BlackEagle.setFitHeight(30);
                                    imagesUnit.BlackEagle.setFitWidth(30);
                                    buttons[x][y] = new Button("", imagesUnit.BlackEagle);
                                    buttons[x][y].setMaxSize(40, 40);
                                    gridPane.add(buttons[x][y], x, y);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.BlackEagle.setFitHeight(30);
                                    imagesUnit.BlackEagle.setFitWidth(30);
                                    buttons[k][l] = new Button("", imagesUnit.BlackEagle);
                                    buttons[k][l].setMaxSize(40, 40);
                                    gridPane.add(buttons[k][l], k, l);

                                }
                            }
                        }
                    }
                }

                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.GrandCannon)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y&&buttons[k][l]==null) {
                                if (buttons[k][l]==null) {
                                    imagesUnit.GrandCannon.setFitHeight(30);
                                    imagesUnit.GrandCannon.setFitWidth(30);
                                    buttons[k][l] = new Button("", imagesUnit.GrandCannon);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.GrandCannon.setFitHeight(30);
                                    imagesUnit.GrandCannon.setFitWidth(30);
                                    buttons[k][l] = new Button("", imagesUnit.GrandCannon);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);


                                }
                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.GrizzlyTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.GrizzlyTank.setFitHeight(30);
                                    imagesUnit.GrizzlyTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.GrizzlyTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.GrizzlyTank.setFitHeight(30);
                                    imagesUnit.GrizzlyTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.GrizzlyTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.Infantry)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.Infantry.setFitHeight(30);
                                    imagesUnit.Infantry.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.Infantry);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.Infantry.setFitHeight(30);
                                    imagesUnit.Infantry.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.Infantry);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }


                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.MirageTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.MirageTank.setFitHeight(30);
                                    imagesUnit.MirageTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.MirageTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.MirageTank.setFitHeight(30);
                                    imagesUnit.MirageTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.MirageTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }


                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.NavySeal)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y&&buttons[k][l]==null) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.NavySeal.setFitHeight(30);
                                    imagesUnit.NavySeal.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.NavySeal);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.NavySeal.setFitHeight(30);
                                    imagesUnit.NavySeal.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.NavySeal);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.PatriotMissileSystem)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.PatriotMissileSystem.setFitHeight(30);
                                    imagesUnit.PatriotMissileSystem.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PatriotMissileSystem);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PatriotMissileSystem.setFitHeight(30);
                                    imagesUnit.PatriotMissileSystem.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PatriotMissileSystem);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }

                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.Pillbox)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.PillBox.setFitHeight(30);
                                    imagesUnit.PillBox.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PillBox);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PillBox.setFitHeight(30);
                                    imagesUnit.PillBox.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PillBox);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }

                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.PrismTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.PrismTank.setFitHeight(30);
                                    imagesUnit.PrismTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PrismTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PrismTank.setFitHeight(30);
                                    imagesUnit.PrismTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PrismTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.PrismTowe)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.PrismTower.setFitHeight(30);
                                    imagesUnit.PrismTower.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PrismTower);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.PrismTower.setFitHeight(30);
                                    imagesUnit.PrismTower.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.PrismTower);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.Sniper)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null) {
                                    Button button = new Button();
                                    button.setPrefSize(35, 35);
                                    imagesUnit.Sniper.setPreserveRatio(true);
                                    imagesUnit.Sniper.fitWidthProperty().bind(button.widthProperty());
                                    imagesUnit.Sniper.fitHeightProperty().bind(button.heightProperty());
                                    button.setGraphic(imagesUnit.Sniper);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    Button button = new Button();
                                    button.setPrefSize(35, 35);
                                    imagesUnit.Sniper.setPreserveRatio(true);
                                    imagesUnit.Sniper.fitWidthProperty().bind(button.widthProperty());
                                    imagesUnit.Sniper.fitHeightProperty().bind(button.heightProperty());
                                    button.setGraphic(imagesUnit.Sniper);

                                }


                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.TankDestroyer)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.TankDestroyer.setFitHeight(30);
                                    imagesUnit.TankDestroyer.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.TankDestroyer);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.TankDestroyer.setFitHeight(30);
                                    imagesUnit.TankDestroyer.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.TankDestroyer);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
                else if (deffenderTeam.players.get(i).playerUnit.get(j).name==Name.TaslaTank)
                {
                    for (int k = 0; k <buttons.length ; k++) {
                        for (int l = 0; l <buttons.length ; l++) {
                            if (k==x&&l==y) {
                                if (buttons[k][l]==null)
                                {
                                    imagesUnit.TeslaTank.setFitHeight(30);
                                    imagesUnit.TeslaTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.TeslaTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);
                                }
                                else {
                                    while (buttons[k][l]!=null)
                                    {
                                        k++;
                                        l++;
                                    }
                                    imagesUnit.TeslaTank.setFitHeight(30);
                                    imagesUnit.TeslaTank.setFitWidth(30);
                                    buttons[k][l] =new Button("", imagesUnit.TeslaTank);
                                    buttons[k][l].setMinSize(35, 35);
                                    gridPane.add(buttons[k][l], k, l);

                                }

                            }
                        }
                    }
                }
            }
        }

        //**************************************************
                for (int k = 0; k <buttons.length ; k++) {
            for (int l = 0; l <buttons.length ; l++) {
                if (buttons[k][l]==null)
                {
                    buttons[k][l]=new Button();
                    buttons[k][l].setMinSize(35,35);
                    gridPane.add(buttons[k][l],k,l);
                }

            }
        }

        for (int n = 0; n <buttons.length ; n++) {
            for (int m = 0; m <buttons.length ; m++) {
            if (n==3&&m==3)
            {
                buttons[n][m].setPrefSize(35,35);
            }else
                buttons[n][m].setPrefSize(35,35);
            }
        }
        return gridPane;
    }
    public Pane getPane() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\wp6690568.jpg");
        javafx.scene.image.Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        createButtons();

//        setGridPane( putImageOnButton());
        pane.getChildren().addAll(imageView,createBoard(),button3);
        return  pane;
    }
}
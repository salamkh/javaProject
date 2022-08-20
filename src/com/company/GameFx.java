package com.company;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
public class GameFx
{
    public static final int tilesSize=50;
    public static final int width=50;
    public static final int height=50;
    Pane pane=new Pane();
    private  Group tileGroup=new Group();
    private Group pieceGroup=new Group();
    public Parent creatContent()
    {
        pane.setPrefSize(width*tilesSize,height*tilesSize);
        pane.getChildren().addAll(tileGroup,pieceGroup);
        for (int y = 0; y <height ; y++) {
            for (int x = 0; x <width ; x++) {
                Tile tile=new Tile((x+y)%2==0,x,y);
                tileGroup.getChildren().add(tile);
            }
        }
        return pane;
    }

    public void setGridPane()
    { }
    public Pane getGridPane()
    {
        setGridPane();
        return pane;
    }

}
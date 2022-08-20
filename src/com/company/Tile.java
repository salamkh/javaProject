package com.company;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Tile extends Rectangle
{

   /* public boolean hasPiece()
    {
        return piece!=null;
    }
*/
   /*public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public Piece getPiece() {
        return piece;
    }
*/    public Tile(boolean light,int x, int y)
    {
        setWidth(GameFx.height);
        setHeight(GameFx.tilesSize);
        relocate(x*GameFx.tilesSize,y*GameFx.tilesSize);
        setFill(light ? Color.valueOf("#feb"):Color.valueOf("#582"));
   // setFill(Color.GRAY,Color.TAN);


    }
}

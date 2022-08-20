package com.company;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImagesUnit
{
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\BlackEagle.jpeg");
    Image image=new Image(fileInputStream);
    ImageView BlackEagle=new ImageView(image);

    FileInputStream fileInputStream1=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\GrandCannon.jpg");
    Image image1=new Image(fileInputStream1);
    ImageView GrandCannon=new ImageView(image1);

    FileInputStream fileInputStream2=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\GrizzlyTank.jpeg");
    Image image2=new Image(fileInputStream2);
    ImageView GrizzlyTank=new ImageView(image2);

    FileInputStream fileInputStream3=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\Infantry.jpg");
    Image image3=new Image(fileInputStream3);
    ImageView Infantry=new ImageView(image3);

    FileInputStream fileInputStream4=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\MainBase.jpg");
    Image image4=new Image(fileInputStream4);
    ImageView MainBase=new ImageView(image4);

    FileInputStream fileInputStream5=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\MirageTank.jpg");
    Image image5=new Image(fileInputStream5);
    ImageView MirageTank=new ImageView(image5);

    FileInputStream fileInputStream6=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\NavySeal.jpg");
    Image image6=new Image(fileInputStream6);
    ImageView NavySeal=new ImageView(image6);

    FileInputStream fileInputStream7=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\PatriotMissileSystem.jpg");
    Image image7=new Image(fileInputStream7);
    ImageView PatriotMissileSystem=new ImageView(image7);

    FileInputStream fileInputStream8=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\PillBox.jpeg");
    Image image8=new Image(fileInputStream8);
    ImageView PillBox=new ImageView(image8);

    FileInputStream fileInputStream9=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\PrismTank.jpeg");
    Image image9=new Image(fileInputStream9);
    ImageView PrismTank=new ImageView(image9);

    FileInputStream fileInputStream10=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\PrismTower.jpeg");
    Image image10=new Image(fileInputStream10);
    ImageView PrismTower=new ImageView(image10);

    FileInputStream fileInputStream11=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\Sniper.png");
    Image image11=new Image(fileInputStream11);
    ImageView Sniper=new ImageView(image11);

    FileInputStream fileInputStream12=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\TankDestroyer.jpeg");
    Image image12=new Image(fileInputStream12);
    ImageView TankDestroyer=new ImageView(image12);

    FileInputStream fileInputStream13=new FileInputStream("C:\\Users\\96399\\Desktop\\project_lan_pro\\src\\com\\images\\TeslaTank.png");
    Image image13=new Image(fileInputStream13);
    ImageView TeslaTank=new ImageView(image13);

    public ImagesUnit() throws FileNotFoundException {
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends AnimatedActor
{
    //8 palettes with 3 colors each, first 2 for body first 3 for head
    //palette 0 is same as in base Images
    static List<Palette> palettes = null;
    static List<GreenfootImage> baseImages = null;
    static List<GreenfootImage> imageCatalogueBody = null;
    static List<GreenfootImage> imageCatalogueHead = null;


    static public void loadImagesFromFile()
    {
        palettes = new ArrayList<Palette>(8);
        for (int i=0;i<8;i++)
        {
            GreenfootImage image = new GreenfootImage(new String("palette_0")+String.valueOf(i+1)+".png");
            ArrayList<Color> c = new ArrayList<Color>(3);
            for (int j=0;j<3;j++)
                c.add(image.getColorAt(1+8*j,0));
            palettes.add(new Palette(c.get(0),c.get(1),c.get(2)));
        }
        baseImages = new ArrayList<GreenfootImage>(5);
        for (int i=1;i<6;i++)
        {
            baseImages.add(new GreenfootImage(new String("straight_0")+String.valueOf(i)+".png"));
        }
    }

    static public void createImageCatalogue(int iPalette)
    {
        imageCatalogueBody = new ArrayList<GreenfootImage>(baseImages.size());
        imageCatalogueHead = new ArrayList<GreenfootImage>(baseImages.size());
        for (int i=0;i<baseImages.size();i++)
        {
            GreenfootImage head = new GreenfootImage(baseImages.get(i));
            if (iPalette>0)
                ;

        }

    }
    
    static public GreenfootImage changePalette(GreenfootImage baseImage,Palette oldPal, Palette oldPal)
    {
        GreenfootImage newImage = new GreenfootImage(baseImage);
    }
}